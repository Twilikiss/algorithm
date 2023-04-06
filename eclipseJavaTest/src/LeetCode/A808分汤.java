package LeetCode;

/**
 * 有 A 和 B 两种类型 的汤。一开始每种类型的汤有 n 毫升。有四种分配操作：
 * <p>
 * 提供 100ml 的 汤A 和 0ml 的 汤B 。
 * 提供 75ml 的 汤A 和 25ml 的 汤B 。
 * 提供 50ml 的 汤A 和 50ml 的 汤B 。
 * 提供 25ml 的 汤A 和 75ml 的 汤B 。
 * 当我们把汤分配给某人之后，汤就没有了。每个回合，我们将从四种概率同为 0.25 的操作中进行分配选择。如果汤的剩余量不足以完成某次操作，我们将尽可能分配。当两种类型的汤都分配完时，停止操作。
 * <p>
 * 注意 不存在先分配 100 ml 汤B 的操作。
 * <p>
 * 需要返回的值： 汤A 先分配完的概率 +  汤A和汤B 同时分配完的概率 / 2。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * <p>
 * <p>
 * 示例 1:
 * 输入: n = 50
 * 输出: 0.62500
 * 解释:如果我们选择前两个操作，A 首先将变为空。
 * 对于第三个操作，A 和 B 会同时变为空。
 * 对于第四个操作，B 首先将变为空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * <p>
 * 示例 2:
 * 输入: n = 100
 * 输出: 0.71875
 * <p>
 * <p>
 * 提示:
 * 0 <= n <= 109
 */
public class A808分汤 {
    public static void main(String[] args) {
        System.out.println(soupServings(222 * 25));
    }

    // 解法一：动态规划，在这一题中当 n > 179时，汤 A 被先取完的概率应该非常接近 1,它和 1 的误差（无论是绝对误差还是相对误差）都小于 10^-5
    // 注意观察dp[i][j]所代表的意义，再确定其意义后，要注意边界的特殊情况要另外进行讨论
    public static double soupServings(int n) {
        n = (int) Math.ceil((double) n / 25);
        if (n > 179) {
            return 1.0;
        }
        double[][] dp = new double[n + 1][n + 1];
        dp[0][0] = 0.5;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[Math.max(i - 4, 0)][j] + dp[Math.max(i - 3, 0)][Math.max(j - 1,0)] + dp[Math.max(i - 2, 0)][Math.max(j - 2, 0)] + dp[Math.max(i - 1,0)][Math.max(j - 3,0)]) / 4.0;
            }
        }
        return dp[n][n];
    }
}
