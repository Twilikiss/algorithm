package LeetCode;

import java.util.Arrays;

/**
 *
 */
public class A1732找到最高海拔 {
    public static void main(String[] args) {
        System.out.println(largestAltitude01(new int[]{-5, 1, 5, 0, -7}));
    }

    //较为复杂
    public static int largestAltitude(int[] gain) {
        int[] ans = new int[gain.length + 1];
        ans[0] = 0;
        for (int i = 1;i < ans.length;i++){
            ans[i] = gain[i - 1] + ans[i - 1];
        }
        Arrays.sort(ans);
        return ans[ans.length - 1];
    }

    //维护前缀和
    public static int largestAltitude01(int[] gain) {
        int ans = 0;
        int sum = 0;
        for (int index : gain){
            sum += index;
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
