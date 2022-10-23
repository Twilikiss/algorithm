package 数据结构与算法.树的实际应用;

import java.util.Arrays;

/**
 * 堆排序的代码实现
 * 8w条数据耗时：7~8毫秒
 * @author mlp52
 *
 */
public class 桶排序 {
	public static void main(String[] args) {
		//要求将下面这个数组进行升序排列
//		int[] arr = {5,3,8,4,6,1,2,7,9,1};
//		int[] arr = {4,6,8,5,9};
		int[] arrays = new int[80000];
		for(int i = 0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
        long start = System.currentTimeMillis();
        heapSort(arrays);
        long end = System.currentTimeMillis();
        System.out.println("排序耗时为 ：" + (end - start) + "毫秒");
	}
	
	//编写一个堆排序的方法
	public static void heapSort(int[] numbers) {
		System.out.println("开始堆排序！");
		
		//调用方法分步完成
//		adjustHeap(numbers, 1, numbers.length); //[4, 9, 8, 5, 6]
//		System.out.println("第一次操作，结果为 " + Arrays.toString(numbers));
		
//		adjustHeap(numbers, 0, numbers.length);//[9, 6, 8, 5, 4]
//		System.out.println("第二次操作，结果为 " + Arrays.toString(numbers));
		//从上面的代码我们可以总结出来
		//numbers.length / 2 - 1 是最后一个非叶子节点！！
		for(int i = numbers.length / 2 - 1;i >= 0;i--) {
			adjustHeap(numbers, i, numbers.length);
		}
//		System.out.println("第一次构建大顶堆结果为 " + Arrays.toString(numbers));
		
		//反复循环操作！！数组有n个数，则要操作n - 1次
		for(int j = numbers.length - 1;j > 0;j--) {
			//交换操作,j在循环中始终是操作数组中的最后一位
			int temp = numbers[j];
			numbers[j] = numbers[0];
			numbers[0] = temp;
			//思考为什么这里并没有循环调用adjustHeap的方法，而是直接传入根节点？
			//因为数组在交换过后，对于操作数组来说顺序除了根节点（因为交换）其余顺序是符合大顶堆，
			//因此直接调用该方法for循环交换比较调整一下即可
			adjustHeap(numbers, 0, j);
		}
//		System.out.println("数组桶排序后的结果为 " + Arrays.toString(numbers));
	}
	
	//将一个数组（二叉树）构建成一个大顶堆
	//numbers：传入的数组；i：非叶子节点在数组中索引；length：需要调整的元素个数，
	//													  length是逐渐减小的
	//方法的作用是将【以i对应的非叶子节点的树调整成大顶堆】
	public static void adjustHeap(int[] numbers,int i,int length) {
		int temp = numbers[i]; // 保留传入下标对应的非叶子节点的值
		//开始调整
		for(int k = i * 2 + 1;k < length;k = k * 2 + 1) {
			//这里要判断k + 1 是否大于 length，以防数组出现空指针异常
			if (k + 1 < length && numbers[k] < numbers[k + 1]) {
				k++;//如果出现右节点的值大于左节点的值则将指针k指向右节点
			}
			if (numbers[k] > temp) {//在这一子树中子节点的值大于父节点的值
				numbers[i] = numbers[k];//把较大的值赋给子树的父节点
				i = k;
			} else {
				break; //这里直接break的原因是因为当调用这个节点[i]时，
					  //以他为子节点为父节点的树已经在此之前调用该方法处理过了
			}
		} //当for循环结束，则以i为父节点的树的最大值放到了最顶（局部）
		numbers[i] = temp;//将临时存储的传入的以i为下标的值赋给当前的i下标
	}
}
