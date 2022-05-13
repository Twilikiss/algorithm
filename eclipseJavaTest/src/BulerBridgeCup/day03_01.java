package BulerBridgeCup;

/**
 * 二分法查找的递归解法
 * 
 * @author mlp520
 *
 */
public class day03_01 {

	public static void main(String[] args) {
		int[] arrays = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int begin = 0;
		int end = arrays.length - 1;
		int key = 5;
		int local = BinarySearch(arrays, begin, end, key);
		System.out.println(local);
	}

	public static int BinarySearch(int[] arrays, int begin, int end, int key) {
		if (begin > end) {
			return -1;
		}
		
		int mid = (begin + end) / 2;
		
		int midValue = arrays[mid];
		
		if (key > midValue) {
			return BinarySearch(arrays, mid + 1, end, key);
		} else if (key < midValue) {
			return BinarySearch(arrays, begin, mid - 1, key);
		} else {
			return mid;
		}

	}
}
