package LeetCode;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * <p>
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * <p>
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * <p>
 * 示例 2：
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] < n
 * nums 中的所有整数 互不相同
 * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
 */
public class A775全局倒置与局部倒置 {
    public static void main(String[] args) {
        System.out.println(isIdealPermutation(new int[]{0, 1, 2, 3}));
    }

    /**
     * 维护后缀最小值，重点找出非局部倒置！！！
     * @param nums
     * @return
     */
    public static boolean isIdealPermutation(int[] nums) {
       int n = nums.length;
       //先默认最小值为数组最后一个
       int minBuffer = nums[n - 1];
       for (int i = n - 3;i >= 0;i--){
           if (nums[i] > minBuffer){
               return false;
           }
           minBuffer = Math.min(nums[i + 1], minBuffer);
       }
       return true;
    }

    /**
     * 数学归纳法
     * @param nums
     * @return
     */
    public static boolean isIdealPermutation01(int[] nums) {
        for (int i = 0;i < nums.length;i++){
            if (Math.abs(nums[i] - i) > 1){
                return false;
            }
        }
        return true;
    }

    }
