package BlueBridgeCup;
/**
  * 插排存在问题已解决，本类废弃，正确答案见包下InsertSort.java
 * @author mlp520
 *
 */
public class day02_01 {
	public static void main(String[] args) {
		int[] out = insertSort(new int[] {6,4,6,7,8,9,5,42,9},8);
		
		for (int i : out) {
			System.out.println(i);
		}
	}
	
	public static int[] insertSort(int[] arr,int key) {
		if (key == 0) {
			return arr;
		}
		insertSort(arr, key - 1);
		int x = arr[key];
		
		while (key > 0&& x < arr[key - 1]) {
			arr[key] = arr[key - 1];
			
			key = key - 2;
		}
		return arr;
	}
}
