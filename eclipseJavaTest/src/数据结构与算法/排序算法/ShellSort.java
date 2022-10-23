package 数据结构与算法.排序算法;

import java.util.Arrays;

/**
 * 希尔排序——交换法实现和移动法实现
 * @author mlp52
 *
 */
public class ShellSort {
	public static void main(String[] args) {
		//测试用例
		int[] arrays = new int[80000];
		for(int i =0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
		long begin = System.currentTimeMillis();
//		shellSortByExchange(arrays); 
		shellSortByMoving(arrays);
//		System.out.println(Arrays.toString(arrays));
		long end = System.currentTimeMillis();
		System.out.println("所耗时间为" + (end - begin) + "毫秒");
	}
	
	// 希尔排序——交换版，所耗时间为4593毫秒
	public static void shellSortByExchange(int[] inNumbers) {
		int temp = 0; // 保留临时变量值
		System.out.println(Arrays.toString(inNumbers));
		for(int gap = inNumbers.length / 2;gap > 0;gap /= 2 ) {
			for(int i = gap;i < inNumbers.length;i++) {
				for (int j = i - gap; j >= 0; j -= gap) {
					if (inNumbers[j] > inNumbers[j + gap]) {
						temp = inNumbers[j];
						inNumbers[j] = inNumbers[j + gap];
						inNumbers[j + gap] = temp;
					}
//					System.out.println(Arrays.toString(inNumbers));
				}
			}
		}
	}
	
	//希尔排序——移动版，移动版较于交换法快很多,所耗时间为13毫秒
	public static void shellSortByMoving(int[] inNumbers) {
		//增量gap，并逐步缩小增量
		for(int gap = inNumbers.length / 2;gap > 0;gap /= 2) {
			//从第gap个元素，逐个对其所在的组进行直接插入排序
			for(int i = gap;i < inNumbers.length;i++) {
				int insertIndex = i;
				int inserVal = inNumbers[insertIndex];
//				if (inNumbers[insertIndex] < inNumbers[insertIndex - gap]) {
				while(insertIndex - gap >= 0 && inserVal < inNumbers[insertIndex - gap]) {
					inNumbers[insertIndex] = inNumbers[insertIndex - gap];
					insertIndex -= gap;
				}
//				}
				if (insertIndex != i) {
					inNumbers[insertIndex] = inserVal;
				}
			}
		}
	}
}	
