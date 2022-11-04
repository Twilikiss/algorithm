package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**
 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。

示例 2：
输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。

示例 3：
输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。

提示：
3 <= nums.length <= 3000
-105 <= nums[i] <= 105

 * @author mlp52
 *
 */
public class A15三数之和 {
	public static void main(String[] args) {
		int[] nums = {-1,0,1,2,-1,-4};
		List<List<Integer>> list = threeSum01(nums);
		for(List<Integer> out : list) {
			System.out.println(out);
		}
	}
	/**
	 * 代码太过复杂或者出现重复现象
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int length = nums.length;
		List<List<Integer>> ans = new ArrayList<>();
		HashSet<Integer> total = new HashSet<>();
		if (nums.length == 3){
			if (nums[0] + nums[1] + nums[2] != 0) return ans;
		}
		int indexSpit = 0;
		while (true){
			if (nums[indexSpit] >= 0){
				break;
			}
			indexSpit++;
		}
		for (int i = 0;i < indexSpit;i++){
			int a1 = nums[i];
			for (int j = length - 1;j >= indexSpit;j--){
				int a2 = nums[j];
				nums[i] = 100001;
				nums[j] = 100001;
				if (!total.contains(- a1 - a2)){
					if (Arrays.binarySearch(nums,- a1 - a2) >= 0){
						List<Integer> temp = new ArrayList<>();
						temp.add(a1);
						temp.add(a2);
						temp.add(- a1 - a2);
						ans.add(temp);
						total.add(- a1 - a2);
					}
				}
				nums[i] = a1;
				nums[j] = a2;
			}

		}
		return ans;
    }

	/**
	 * 巧妙利用第一项 < 第二项 < 第三项来做到去重的效果
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum01(int[] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<>();
		for (int first = 0;first < length;first++){
			if (first > 0 && nums[first - 1] == nums[first]){
				continue;
			}
			int third = length - 1;
			int temp = nums[first];
			for (int second = first + 1;second < length;second++){
				if (second > first + 1 && nums[second - 1] == nums[second]){
					continue;
				}
				while (second < third && nums[second] + nums[third] + temp > 0){
					third--;
				}
				if (second == third){
					break;
				}
				if (nums[second] + nums[third] + temp == 0){
					List<Integer> list = new ArrayList<>();
					list.add(nums[first]);
					list.add(nums[second]);
					list.add(nums[third]);
					ans.add(list);
				}
			}
		}
		return ans;
	}
}
