package 数据结构与算法.排序算法;

import java.util.Arrays;

/**
 * 插入排序
 * 插入排序的步骤比较复杂和不清晰，需要多多理解其中的相关操作
 * 时间复杂度
 * @author mlp52
 *
 */
public class InsertSort {
	public static void main(String[] args) {
		int[] arrays = new int[80000];
		for(int i = 0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
		inertionSort(arrays);
	}
	
	//插入排序(自主实现),可以尝试debug来进行理解
	public static void inertionSort(int[] inNumbers) {
		long begin = System.currentTimeMillis();
//		int count = 1;
		int insertVal = 0;
		int inserIndex = 0;
		for(int i = 1;i < inNumbers.length;i++) {
			insertVal = inNumbers[i]; // 待插入的数值
			inserIndex = i - 1; // 需要判断的数值的下标
			boolean isChange = false;
			while(inserIndex >= 0 && insertVal < inNumbers[inserIndex]) {
				isChange = true;
				inNumbers[inserIndex + 1] = inNumbers[inserIndex];
				inserIndex--;
			}
			if (isChange) {
				inNumbers[inserIndex + 1] = insertVal;
			} else {
				isChange = false;
			}
//			System.out.println("第" + count + "次插入！");
//			System.out.println(Arrays.toString(inNumbers));
//			count++;
		}
		long end = System.currentTimeMillis();
		System.out.println("消耗的时间为" + (end - begin) + "毫秒");
	}
}
