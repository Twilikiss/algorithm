package 数据结构与算法.排序算法;

import java.util.Arrays;

/**
  * 归并排序的代码实现--递归实现
  * 排序结束所耗时间为：8毫秒
 * 
 * @author mlp52
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arrays = new int[80000];
		for(int i = 0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
		int[] temp = new int[arrays.length];
		long start = System.currentTimeMillis();
		mergeSort(arrays, 0, arrays.length - 1, temp);
		long end = System.currentTimeMillis();
//		System.out.println("排序后的数组为 : " + Arrays.toString(arrays));
		System.out.println("排序结束所耗时间为：" + (end - start) + "毫秒");
	}
	
	//拆分+合并的方法
	//不断地进行递归，将数组拆分到只剩一个数，此时地right - left = 1
	public static void mergeSort(int[] inNumbers,int left,int right,int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			//向左递归进行分解
			mergeSort(inNumbers, left, mid, temp);
			
			//向右递归进行分解
			mergeSort(inNumbers, mid + 1, right, temp);
			
			//每分解一次就合并一次
			merge(inNumbers, left, mid, right, temp);
		}
	}
	
	//合并方法
	/**
	 * 
	 * @param inNumbers 原始数组
	 * @param left  左索引
	 * @param mid   中间索引
	 * @param right 右索引
	 * @param temp  临时中转数组
	 */
	public static void merge(int[] inNumbers,int left,int mid,int right,int[] temp) {
		int i = left; // 初始化i,左边有序序列的初始索引
		int j = mid + 1; // 初始化j,右边有序序列的初始索引
		int t = 0; // 临时数组的下标索引
		
		//合并左右两边的数据(已有序)按照规则填充到临时数组里
		//处理到左右两边有一边处理完毕为止
		while(i <= mid && j <= right) {
			if (inNumbers[i] <= inNumbers[j]) {
				temp[t] = inNumbers[i];
				i++;
			} else {
				temp[t] = inNumbers[j];
				j++;
			}
			t++;
		}
		//把有剩余一边的数据直接填充到临时数组里
		while(i <= mid) {// 如果左边有剩余的数据
			temp[t] = inNumbers[i];
			i++;
			t++;
		}
		while(j <= right) {// 如果右边有剩余的数据
			temp[t] = inNumbers[j];
			j++;
			t++;
		}
		
		//将temp的元素拷贝到原数组中
		t = 0;
		int templeft = left;// 待拷贝原数组的最左边的下标
//		System.out.println("templeft:" + templeft + "  " + "right:" + right);
		while(templeft <= right) {
			inNumbers[templeft] = temp[t];
			templeft++;
			t++;
		}
	
	}
}
