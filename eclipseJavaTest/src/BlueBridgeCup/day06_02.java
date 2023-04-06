package BlueBridgeCup;

import java.util.Arrays;


/**
 * 题2：旋转数组的最小数字(改造二分法)
   把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
   输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
   例如数组{3，4，5，1，2}为{1，2，3，4，5}的一个旋转，该数组的最小值为1.
 * @author mlp52
 *
 */
public class day06_02 {
	public static void main(String[] args) {
		int[] a = {4,5,1,2,3};
		int out = findMin01(a);
		System.out.println(out);
		System.out.println("**********************************************************");
		int[] b = {4,5,1,2,3};
		int out01 = findMinByDichotomy(b);
		System.out.println(out01);
	}
	//暴力开解法
	public static int findMin01(int[] in) {
		Arrays.sort(in);
		return in[0];
	}
	/**
	  * 利用二分法的变体，迭代形式查找（针对该特殊的要求的题目效率更高）
	  * 但只能针对特定的递增数组
	 * @param in
	 * @return
	 */
	public static int findMinByDichotomy(int[] in) {
		int begin = 0;
		int end = in.length - 1;
		if (in[begin] < in[end]) {
			return in[begin];
		}
		//判断此时数组个数，当数组的个数只有两个时，角标最后一个必是最小值
		while (begin + 1 < end){
			int mid = begin + ((end - begin) >> 1);
			if (in[mid] > in[begin]) {
				begin = mid;
			} else {
				end = mid;
			}
		}
		return in[end];
	}
}
