package day02;

import org.junit.Test;

/**
 * 把符合下列属性的数组 arr 称为 山脉数组 ：

arr.length >= 3
存在下标 i（0 < i < arr.length - 1），满足
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0 。

示例 1：
输入：arr = [2,1,4,7,3,2,5]
输出：5
解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5

示例 2：
输入：arr = [2,2,2]
输出：0
解释：不存在山脉子数组。
 
提示：
1 <= arr.length <= 104
0 <= arr[i] <= 104

进阶：
你可以仅用一趟扫描解决此问题吗？
你可以用 O(1) 空间解决此问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-mountain-in-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author mlp52
 *
 */
public class Leecode845 {
	
	@Test
	public void longestMountain() {
		        
		int[] arr = {0,1,2,3,4,5,4,3,2,1,0};
		int arr_index = 0;
				
				int max = arr[0];
				
				int b = 0;
				
				for(int i = 1;i < arr.length;i++) {
					if(max < arr[i]) {
						max = arr[i];
						arr_index = i;
					}
				}
				
				if(arr_index == arr[arr.length - 1]) {
					b =  0;
				}
	
				
				for(int a = arr_index;a >= 0;a--) {
					for(int c = a - 1;c >= 0;c--) {
						if(arr[a] < arr[c]) {
							b = (arr_index - a) * 2 + 1;
						}
					}
				}
				System.out.println(b);
				
			    }

		}
