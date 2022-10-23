package 数据结构与算法.排序算法;

import java.util.Arrays;

/**
 * 快速排序法
 *取一个支点，支点左右进行判断， 左右分别进行递归操作
 *废弃，用【3,9,-1,10,2,1,2,4,2,3,3,1,-3,-3】会栈溢出！！！！
 *正确的代码见QuickSortByJava.java
 * @author mlp52
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		int[] arrays = new int[] {3,9,-1,10,2,1,2,4,2,3,3,1,-3,-3};
		System.out.println(Arrays.toString(arrays));
		quickSort(arrays, 0, arrays.length - 1);
		System.out.println(Arrays.toString(arrays));
	}
	
	//快速排序法
	public static void quickSort(int[] inNumbers,int left,int right) {
		int l = left; // 左下标
		int r = right; // 右下标
		int pivot = inNumbers[(left + right) / 2]; // 中轴值，用于判断
		int temp = 0;
		// 开始进入循环，让小于pivot小的值放到它的左边，反之放到它的右边
		while(l < r) {
			// 在pivot的左边一直找，找到大于或者等于pivot值的才退出
			while (inNumbers[l] < pivot) {
				l += 1;
			}
			// 在pivot的右边一直找，找到小于或者等于pivot值的才退出
			while (inNumbers[r] > pivot) {
				r -= 1;
			}
			// 如果r >= l，则说明pivot左边均为小于或等于pivot的数，右边为大于或等于pivot的数
			if (l >= r) {
				break;
			}
			// 交换
			temp = inNumbers[l];
			inNumbers[l] = inNumbers[r];
			inNumbers[r] = temp;
			
			// 如果交换完后，发现inNumbers[l] == pivot，则r--，前移
			// 如果交换完后，发现inNumbers[r] == pivot，则l++，后移
			if(inNumbers[l] == pivot) {
				r -= 1;
			}
			if (inNumbers[r] == pivot) {
				l += 1;
			}
			// 当l==r时要将l++,r--
			if (l == r) {
				l++;
				r--;
			}
			if (left < r) {
				quickSort(inNumbers, left, r);
			}
			if (right > l) {
				quickSort(inNumbers, l, right);
			}
		}
	}
	
	// 交换代码
	public static void swap(int[] inNumbers,int index01,int index02) {
		
	}
}
