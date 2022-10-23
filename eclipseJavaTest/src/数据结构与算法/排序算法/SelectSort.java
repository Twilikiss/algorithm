package 数据结构与算法.排序算法;
/**
 * 选择排序
 * 选择排序时间复杂度也是O(n^2)
 * 经过比较我们发现，对80000条数据进行排序时，虽然冒泡排序和选择排序的时间复杂度是一样的，但是选择排序耗时774毫秒，
 * 冒泡排序为5555毫秒，原因是选择排序比冒泡排序交换次数更加少
 * @author mlp52
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] arrays = new int[80000];
		for(int i =0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
		long begin = System.currentTimeMillis();
		selectSort(arrays);
		long end = System.currentTimeMillis();
		System.out.println("输出的数组耗时为 ： " + (end - begin) + "毫秒");
	}
	//选择排序
	public static void selectSort(int[] inNumbers) {
		//假定最小值的索引和对应最小值
		for(int i = 0;i < inNumbers.length - 1;i++) {
			int minIndex = i;
			int min = inNumbers[i];
			for (int j = i; j < inNumbers.length; j++) {
				if (min > inNumbers[j]) {
					min = inNumbers[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				inNumbers[minIndex] = inNumbers[i];
				inNumbers[i] = min;	
			}
		}
	}
}
