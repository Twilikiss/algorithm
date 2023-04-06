package BlueBridgeCup;

/**
  * 关于冒泡排序的基本思路
 * @author mlp52
 *
 */

import org.junit.Test;

public class BubbleSort {
	@Test
	public void test01() {
		int[] data = {12,22,13,14,12,5,7,4,8,3,8,-12,-44,123,122,112};
		
		int[] out = BubbleSort.sort(data);
		
		for(int a : out) {
			System.out.print(a + " ");
		}
	}
	
	public static int[] sort(int[] in) {
		for (int i = 0; i < in.length - 1; i++) {
			for(int j = 0;j < in.length - 1 - i;j++) {
				if(in[j] >= in[j + 1]) {
					int a = in[j];
					in[j] = in[j + 1];
					in[j + 1] = a;
				}
			}
		}
		return in;
	}

}
