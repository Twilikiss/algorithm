package LeetCode;

import java.util.Deque;

/**
 *
 */
public class A3最长回文字符串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ab"));
    }

    //动态规划，官方解法较为复杂
    public static String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int begin = 0;
        int maxLen = 1;
        String[] date = s.split("");
        for (int L = 2; L <= date.length; L++) {
            // 从最左边开始遍历
            for (int i = 0; i < length; i++) {
                // 从左边界求出右边界
                int j = i + L - 1;
                if (j >= length) {
                    break;
                }
                if (!date[i].equals(date[j])) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen){
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    public static String longestPalindromePlus(String s) {
        return null;
    }
}
