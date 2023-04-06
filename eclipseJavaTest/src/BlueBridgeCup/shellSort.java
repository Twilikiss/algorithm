package BlueBridgeCup;
/**
  * 希尔排序的代码实现（代码基本没问题，但是对于第二层for循环中的“i++”很难理解，待解决）
 * @author mlp52
 *
 */
public class shellSort {
	public static void main(String[] args) {
		int[] a = {12,1,3,4,1,-1,-4,2,-45,34,23,545};
		int[] out = Sort(a);
		for(int number : out) {
			System.out.print(number + " ");
		}
	}
	
	public static int[] Sort(int[] data) {
		 for(int interval = (data.length >> 1);interval > 0;interval = interval >> 1) {
			 for(int i = interval;i < data.length;i++) {
				 int temp = data[i];
				 int beInsert = i - interval;
				 if (temp - data[beInsert] < 0) {
					for(;beInsert >= 0 && temp - data[beInsert] < 0;beInsert -= interval) {
						data[beInsert + interval] = data[beInsert];
					}
					data[beInsert + interval] = temp;
				}
			 }
		 }
		 return data;
	}
}
