package 数据结构与算法.十大算法;

import java.util.Arrays;

/**
 * 前面的二分查找是通过递归实现的，现在让我们尝试使用非递归的方式来实现
 * @author mlp52
 *
 */
public class 非递归二分查找 {
	public static void main(String[] args) {
		int[] arr = {12,1,44,2,3,42,11,5,76,23};
		Integer[] index = new Integer[arr.length];
		for(int i = 0;i < arr.length;i++) {
			index[i] = i;
		}
		Arrays.sort(index,(i,j) -> arr[i] - arr[j]);
		Arrays.sort(arr);
		int i = binarySearch(arr, 12);
		System.out.println(Arrays.toString(index));
		System.out.println("排序后的位置:" + i + " , 原始数组的位置:" + index[i]);
	}
	//二分查找非递归实现
	//传入的arr数组是结果经过升序排列的
	public static int binarySearch(int[] arr,int target) {
		//设置左右指针
		int left = 0;
		int right = arr.length - 1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if (arr[mid] == target) {
				return mid;
			} else if(arr[mid] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}
}
