package 数据结构与算法.排序算法;

import java.util.Arrays;

/**
 * 基数排序——代码实现
 * 基数排序(Radix Sort)是桶排序的扩展
 * 基本实现方式：将整数按位数切割成不同的数字，然后按每个
位数分别比较。
！！！！注意！！！！！
当前的代码是基础代码，只能处理正整数即int数组且元素均为正数
        排序完成耗时为25毫秒
当数据量来到8千万条数据时，代码报如下错误：
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 * @author mlp52
 *
 */
public class RadixSort {
	public static void main(String[] args) {
//		int[] arrays = new int[] {53,3,542,14,214};
		int[] arrays = new int[80000];
		for(int i = 0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
		long start = System.currentTimeMillis();
		radixSort(arrays);
		long end = System.currentTimeMillis();
		System.out.println("排序完成耗时为" + (end - start) + "毫秒");
	}
	
	//基数排序的方法
	public static void radixSort(int[] inNumbers) {
		//利用二维数组初始化桶
		int[][] bucket = new int[10][inNumbers.length];
		
		//设置一个数组来记录每一个桶内的数据个数，方便后续遍历
		int[] ElementCount = new int[10];
		
		//对传入的数字进行处理
		//判断循环放入的次数 = 原数组内最大数的位数
		int maxNumber = inNumbers[0];
		for(int i = 1;i < inNumbers.length;i++) {
			if (maxNumber < inNumbers[i]) {
				maxNumber = inNumbers[i];
			}
		}
		int maxNumberSize = (maxNumber + "").length();
		//开始进行遍历
		for(int i = 0;i < maxNumberSize;i++) {
			for(int j = 0;j < inNumbers.length;j++) {
				int digitOfElement = (int)(inNumbers[j] / Math.pow(10, i) % 10);
				//取出对应数值赋值到对应数组
				bucket[digitOfElement][ElementCount[digitOfElement]] = inNumbers[j];
				//对应桶的内的元素个数+1
				ElementCount[digitOfElement]++;
			}
			//遍历原数组的下标
			int index = 0;
			//遍历每一个桶，并将桶中的数据放入到原数组
			for(int k = 0;k < ElementCount.length;k++) {
				//判断桶中是否有数据
				if(ElementCount[k] != 0) {
					for(int l = 0;l < ElementCount[k];l++) {
						inNumbers[index++] = bucket[k][l];
					}
				}
				//遍历完成之后清空对应桶的数据方便进行下一轮的操作
				ElementCount[k] = 0;
			}
		}
	}
}
