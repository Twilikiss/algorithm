package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 *
 * 提示：
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class A16最接近的三数之和 {
    public static void main(String[] args) {
        //[4,0,5,-5,3,3,0,-4,-5]
        //-2
        System.out.println(threeSumClosest02(new int[]{4,0,5,-5,3,3,0,-4,-5}, -2));
    }
    //错误解法
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0;i < nums.length;i++){
            if (i == 0 || i == nums.length - 1){
                if (i == 0 && target <= nums[i]){
                    return nums[0] + nums[1] + nums[2];
                }
                if (i == nums.length - 1 && (target <= nums[i] || target > nums[i])){
                    return nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
                }
            }
            if (target <= nums[i]){
                index = i;
                break;
            }
        }
        return nums[index - 1] + nums[index] + nums[index + 1];
    }

    // 尝试暴力解法，出现超时，（32 / 98 个通过测试用例）简单的三重循环不能通过所有的用例
    public static int threeSumClosest01(int[] nums, int target) {
        ArrayList<Integer> total = new ArrayList<>();
        for (int i = 0;i < nums.length;i++){
            for (int j = i + 1;j < nums.length;j++){
                for (int f = j + 1;f < nums.length;f++){
                    total.add(nums[i] + nums[j] + nums[f]);
                }
            }
        }
        Collections.sort(total);
        for (int i = 0;i < total.size();i++){
            if (target <= total.get(i)){
                return total.get(i);
            }
        }
        return total.get(total.size() - 1);
    }

    //下面尝试对for + 双指针
    public static int threeSumClosest02(int[] nums, int target) {
        Arrays.sort(nums);
        int best = 1000000;
        int n = nums.length;
        // 遍历，得到三个数的第一个数
        for(int i = 0;i < n;i++){
            // 当遇到下一个数和前一个数相等时，跳过
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            // 获取第二和第三的个数
            int left = i + 1;
            int right = n - 1;
            while (left < right){
                int test = nums[i] + nums[left] + nums[right];
                if (Math.abs(test - target) < Math.abs(best - target)){
                    best = test;
                }
                if (test < target){
                    int temp = left + 1;
                    while (temp < right && nums[temp] == nums[left]){
                        temp ++;
                    }
                    left = temp;
                } else {
                    int temp = right - 1;
                    while (temp > left && nums[temp] == nums[right]){
                        temp --;
                    }
                    right = temp;
                }
            }
        }
        return best;
    }
}
