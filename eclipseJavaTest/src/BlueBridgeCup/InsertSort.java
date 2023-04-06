package BlueBridgeCup;

import java.util.Arrays;


/**
  * 插入排序的代码实现
 * @author mlp52
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		int[] a = {12,1,3,4,1,-1,-4,2,-45,34,23,545};
		int[] out = sort(a);
		for(int number : out) {
			System.out.print(number + " ");
		}
	}
	
	
	public static int[] sort(int[] data) {
		for(int a = 1;a < data.length;a++) {
			//待插入的数字的值
			int temp = data[a];
			
			if (temp - data[a - 1] < 0) {
				//被插入数的角标
				int beInsert = a - 1;
				for(;beInsert >= 0 && data[beInsert] - temp > 0;beInsert--) {
					data[beInsert + 1] = data[beInsert];
					//输出方便查看
					System.out.println(Arrays.toString(data));
				}
				data[beInsert + 1] = temp;
			}
		}
		return data;
	}
}
