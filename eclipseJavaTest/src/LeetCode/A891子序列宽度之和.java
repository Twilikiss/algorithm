package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。
 * 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 109 + 7 取余 后的结果。
 * 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7] 的一个子序列。
 *
 * 示例 1：
 * 输入：nums = [2,1,3]
 * 输出：6
 * 解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
 * 相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
 * 宽度之和是 6 。
 *
 * 示例 2：
 * 输入：nums = [2]
 * 输出：0
 *
 *
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class A891子序列宽度之和 {
    public static void main(String[] args) {

    }
    //尝试对子序列问题进行回溯+剪枝,感觉会超时
    public static int sumSubseqWidths(int[] nums) {
        int n = nums.length;
        for (int i = 1;i <= n;i++){
            Deque<Integer> temp = new ArrayDeque<>();
            List<List<Integer>> in = new ArrayList<>();
            make(temp,in,nums,i,0);
        }
        return -1;
    }

    public static void make(Deque<Integer> total, List<List<Integer>> data,int[] source, int n, int index){

    }
}
