package BlueBridgeCup;

import org.junit.Test;

/**
 * 快速排序的思路分析 快速排序 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 * 
 * @author mlp52
 */
public class QuickSort {
	@Test
	public void test01() {
		int[] in = { 9, 86, 67, 453, 453, 235, 75, 56, 78, 34, 547, 867, 76, 578, 74, 27, 786, 34, 12, 34, 123, 3451,
				123, 125, 125235, 1234125, 4162362, 12351, 1234, 231, 25425, 214 };

		sort(in, 0, in.length - 1);

		for (int out : in) {
			System.out.print(out + " ");
		}
	}

	// 交换数组指定索引的元素
	private static void swap(int[] source, int low, int high) {
		int temple = source[high];
		source[high] = source[low];
		source[low] = temple;
	}

	public static void sort(int[] in, int start, int end) {
		if (start < end) {

			int base = in[start];
			int low = start;
			int high = end + 1;

			while (true) {
				// 向右遍历直到找出小于基准数的角标
				while (low < end && in[++low] - base <= 0)
					;
				// 向左遍历直到找出大于基准数的角标
				while (high > start && in[--high] - base >= 0)
					;
				if (low < high) {
					// 交换两者的位置
					swap(in, low, high);
				} else {
					break;
				}
			}

			swap(in, start, high);

			sort(in, start, high - 1);

			sort(in, high + 1, end);

		}

	}
}
