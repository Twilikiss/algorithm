package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 【贪心算法！】
 * <待解决！！！！！！>
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势
 * 可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
要求：返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。

示例 1：
输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
输出：[2,11,7,15]

示例 2：
输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
输出：[24,32,8,12] 

提示：
1 <= nums1.length <= 105
nums2.length == nums1.length
0 <= nums1[i], nums2[i] <= 109


 * @author mlp52
 *
 */
public class A870优势洗牌 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(advantageCount02(new int[]{12,24,8,32},new int[]{13,25,32,11})));
	}
	public static int[] advantageCount(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		ArrayList<Integer> list01 = doArrays(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> list02 = doArrays(nums2);
		int index = 0;
		int[] answer = new int[nums1.length];
		for (int i = 0; i < list01.size(); i++) {
			for (int j = 0; j < list02.size(); j++) {
				if (list01.get(i) < list02.get(j)) {
					list02.remove(j - 1);
					answer[i] = nums1[index - 1];
					break;
				}
				index ++;
			}
		}
		return answer;
    }
	public static ArrayList<Integer> doArrays(int[] in) {
		ArrayList<Integer> outArrayList = new ArrayList<>();
		for (int i = 0; i < in.length; i++) {
			outArrayList.add(in[i]);
		}
		return outArrayList;
	}
	
	//正确解法一
	public static int[] advantageCount02(int[] nums1, int[] nums2) {
		int n = nums1.length;
		Integer[] index = new Integer[nums2.length];
		for(int i = 0;i < n;i++) {
			index[i] = i;
		}
		Arrays.sort(nums1);
		Arrays.sort(index,(x,y) ->nums2[x] - nums2[y]);
		int L = 0;
		int R = n - 1;
		for(int out : nums1) {
			if (out > nums2[index[L]]) {
				nums2[index[L++]] = out;
			} else {
				nums2[index[R--]] = out;
			}
		}
		return nums2;
	}
}
