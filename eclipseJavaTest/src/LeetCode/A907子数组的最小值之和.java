package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个整数数组 arr，找到 min(b)的总和，其中 b 的范围为 arr 的每个（连续）子数组。
 * 由于答案可能很大，因此 返回答案模 10^9 + 7 。
 * <p>
 * 示例 1：
 * 输入：arr = [3,1,2,4]
 * 输出：17
 * 解释：
 * 子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
 * 最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
 * <p>
 * 示例 2：
 * 输入：arr = [11,81,94,43,3]
 * 输出：444
 * <p>
 * 提示：
 * 1 <= arr.length <= 3 * 104
 * 1 <= arr[i] <= 3 * 104
 */
public class A907子数组的最小值之和 {
    public static void main(String[] args) {
        int i = sumSubarrayMinsPro(new int[]{3, 1, 2, 4});
        System.out.println(i);
    }
    //简单的暴力枚举超时！！！
    public static int sumSubarrayMins(int[] arr) {
        long ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int value = arr[j];
                if (i + j > arr.length - 1) {
                    break;
                }
                for (int k = 0; k <= i; k++) {
                    if (value > arr[j + k]) {
                        value = arr[j + k];
                    }
                }
                ans += value;
            }
        }
        return (int)(ans % (Math.pow(10, 9) + 7));
    }

    private static final int MOD = 1000000007;
    //解法一：  单调栈，通过模拟操作我们可以看出，每一个数组的最小值是存在比较大的重复的，重复比较会导致超时，
    //      这里引入单调栈，找出左边第一个小于当前元素和右边第一个等于或小于当前元素的位置
    public static int sumSubarrayMinsPro(int[] arr) {
        int n = arr.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] left = new int[n];
        int[] right = new int[n];
        //从左往右遍历
        for (int i = 0;i < n;i++){
            while (!monoStack.isEmpty() && arr[i] <= arr[monoStack.peek()]){
                monoStack.pop();
            }
            left[i] = i - (monoStack.isEmpty() ? -1 : monoStack.peek());
            monoStack.push(i);
        }
        monoStack.clear();
        //从右到左遍历
        for (int i = n - 1;i >= 0;i--){
            while (!monoStack.isEmpty() && arr[i] < arr[monoStack.peek()]){
                monoStack.pop();
            }
            right[i] = (monoStack.isEmpty() ? n : monoStack.peek()) - i;
            monoStack.push(i);
        }
        long ans = 0;
        for (int i = 0;i < n;i++){
            ans = (ans + (long)left[i] * right[i] * arr[i]) % MOD;
        }
        return (int) ans;
    }
}
