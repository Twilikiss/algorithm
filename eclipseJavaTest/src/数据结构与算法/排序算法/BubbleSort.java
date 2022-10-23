package 数据结构与算法.排序算法;

import java.util.Arrays;
/**
 * 简单模拟冒泡排序
 * 时间复杂度为O(n^2)
 * @author mlp52
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		int[] arrays = new int[] {3,9,-1,10,2,1,2,4,2,3,3,1,-3,-3};
		
		//第一遍排序，按照从小到大进行排序
		int temp = 0; //临时变量
		for (int j = 0; j < arrays.length - 1; j++) {
			for (int i = 0; i < arrays.length - 1 - j; i++) {
				// 如果前面的数比后面的大,则进行交换
				if (arrays[i] > arrays[i + 1]) {
					temp = arrays[i];
					arrays[i] = arrays[i + 1];
					arrays[i + 1] = temp;
				}
			}
		}
		System.out.println("冒泡排序的结果为 ： " + Arrays.toString(arrays));
	}

}
