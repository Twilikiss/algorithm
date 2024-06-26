package LeetCode;

import java.util.Arrays;

/**
 * 给定你一个整数数组 nums
 *
 * 我们要将 nums 数组中的每个元素移动到 A 数组 或者 B 数组中，使得 A 数组和 B 数组不为空，并且 average(A) == average(B) 。
 *
 * 如果可以完成则返回true ， 否则返回 false  。
 *
 * 注意：对于数组 arr ,  average(arr) 是 arr 的所有元素的和除以 arr 长度。
 *
 *
 * 示例 1:
 * 输入: nums = [1,2,3,4,5,6,7,8]
 * 输出: true
 * 解释: 我们可以将数组分割为 [1,4,5,8] 和 [2,3,6,7], 他们的平均值都是4.5。
 *
 * 示例 2:
 * 输入: nums = [3,1]
 * 输出: false
 *
 * 提示:
 * 1 <= nums.length <= 30
 * 0 <= nums[i] <= 104
 */
public class A805数组的均值分割 {
    public static void main(String[] args) {

    }
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1){
            return false;
        }
        if (nums.length == 2){
            return nums[0] == nums[1];
        }
        Arrays.sort(nums);
        return false;
    }
}
