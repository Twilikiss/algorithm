package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。 

示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 
提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

 * @author mlp52
 *
 */
public class 寻找两个正序数组的中位数 {
	public static void main(String[] args) {
		int[] num1 = new int[] {};
		int[] num2 = new int[] {1};
		
		double out = findMedianSortedArrays_01(num1, num2);
		
		System.out.println(out);
	}
	public static double findMedianSortedArrays_01(int[] nums1, int[] nums2) {

		double mid = 0;
		
		ArrayList<Integer> sumArrayList = new ArrayList<>();
		
		for(int i = 0;i < nums1.length;i++) {
			sumArrayList.add(nums1[i]);
		}
		for(int i = 0;i < nums2.length;i++) {
			sumArrayList.add(nums2[i]);
		}
	
		Collections.sort(sumArrayList);
		
		int c = sumArrayList.size();	
		
		if(c == 0) {
			return 0;
		} else if(c == 1) {
			return (double)sumArrayList.get(0);
		}
		
		Double numDouble1 = Double.parseDouble(sumArrayList.get(c/2 - 1).toString());
		
		Double numDouble2 = Double.parseDouble(sumArrayList.get(c/2).toString());
		
		if(c%2 == 0) {
			mid = (numDouble1 + numDouble2)/2;
		} else {
			mid = sumArrayList.get(c/2);
		}
		
		return mid;
    }
	
	/**
	 * 尝试使用二分查找法解决，使时间复杂度降到O(log(m + n))
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays_02(int[] nums1, int[] nums2) {
		int length01 = nums1.length;
		int length02 = nums2.length;
		int total = length01 + length02;
		
		if (total % 2 == 1) {
			return getElement(nums1, nums2, total / 2 + 1);
		} else {
			return (getElement(nums1, nums2, total / 2) + getElement(nums1, nums2, total / 2 + 1)) / 2.0;
		}
	}
	
	public static int getElement(int[] nums1,int[] nums2,int k) { 
		int length01 = nums1.length;
		int length02 = nums2.length;
		int index01 = 0;
		int index02 = 0;
		
		//设置一个while循环，当到达数组边界即结束
		while(true) {
			if (index01 == length01) {
				return nums2[index02 + k - 1];
			} else if(index02 == length02) {
				return nums1[index01 + k - 1];
			} else if (k == 1) {
				return Math.min(nums1[index01], nums2[index02]);
			}
			int half = k / 2;
			int newindex01 = Math.min(index01 + half, length01) -1;
			int newindex02 = Math.min(index02 + half, length02) - 1;
			
			//判断对应位置的的值的大小
			int value01 = nums1[newindex01];
			int value02 = nums2[newindex02];
			
			if (value01 <= value02) {
				k -= (newindex01 - index01 + 1);
				//加1是因为包括newindex01位置都“删去”了
				index01 = newindex01 + 1;
			} else {
				k -= (newindex02 - index02 + 1);
				index02 = newindex02 + 1;
			}
		}
	}
}
