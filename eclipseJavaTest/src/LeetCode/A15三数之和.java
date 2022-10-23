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
		List<List<Integer>> list = threeSum(nums);
		for(List<Integer> out : list) {
			System.out.println(out);
		}
	}
	/**
	 * 代码失败，无法做到去重或去重方式冗余，继续进行改进
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answerArrayList = new ArrayList<>();
        //排除特殊情况
        if (nums.length < 3) {
			return answerArrayList;
		}
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
			return answerArrayList;
		}
        if (nums[0] == 0 && nums[nums.length - 1] == 0) {
        	 List<List<Integer>> temp = new ArrayList<>();
        	 List<Integer> integers = new ArrayList<>();
        	 integers.add(0);
        	 integers.add(0);
        	 integers.add(0);
        	 for (int i = 0; i < nums.length / 3; i++) {
				temp.add(integers);
			}
        	 return temp;
		}
        if (nums[0] * nums[nums.length - 1] >= 0) {
			return answerArrayList;
		}
        int SqitIndex = 0;
        while(true) {
        	if (nums[SqitIndex] == 0 || (nums[SqitIndex] * nums[SqitIndex + 1] < 0)) {
				break;
			}
        	SqitIndex++;
        }
        for(int i = 0;i <= SqitIndex;i++) {
        	for(int j = nums.length - 1;j >= nums.length - 1 - SqitIndex;j--) {
        		int findIndex = i + 1;
        		while (findIndex < j) {
					if (nums[i] + nums[j] + nums[findIndex] == 0) {
						List<Integer> numsList = new ArrayList<>();
						numsList.add(nums[i]);
						numsList.add(nums[j]);
						numsList.add(nums[findIndex]);
						answerArrayList.add(numsList);
					}
					findIndex++;
				}
        	}
        }
        return answerArrayList;
    }
}
