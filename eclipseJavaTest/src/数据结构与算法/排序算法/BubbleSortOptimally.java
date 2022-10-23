package 数据结构与算法.排序算法;

import java.io.IOException;

/**
 * 冒泡排序的优化版本
 * @author mlp52
 *
 */
public class BubbleSortOptimally {
	public static void main(String[] args) throws IOException{
		int[] arrays = new int[80000];
		for(int i =0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
		long begin = System.currentTimeMillis();
		
		//第一遍排序，按照从小到大进行排序
		int temp = 0; //临时变量
		boolean isFlag = false; // 判断是否发生过交换
		for (int j = 0; j < arrays.length - 1; j++) {
			for (int i = 0; i < arrays.length - 1 - j; i++) {
				// 如果前面的数比后面的大,则进行交换
				if (arrays[i] > arrays[i + 1]) {
					isFlag = true;
					temp = arrays[i];
					arrays[i] = arrays[i + 1];
					arrays[i + 1] = temp;
				}
			}
			if (!isFlag) {
				break;
			} else {
				isFlag = false;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("输出的数组耗时为 ： " + (end - begin) + "毫秒");
	}

}
