package LeetCode;

/**
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 *
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 109 + 7 取模 的值。
 *
 * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
 *
 * 示例 1:
 *
 * 输入: n = 3
 * 输出: 5
 * 解释: 五种不同的方法如上所示。
 *
 * 示例 2:
 * 输入: n = 1
 * 输出: 1
 *
 * 提示：
 * 1 <= n <= 1000
 */
public class A790多米诺和托米诺平铺 {
    public static void main(String[] args) {
        System.out.println(numTilings(60));
    }
    static final int MOD = 1000000007;

    public static int numTilings(int n) {
        int[][] mark = new int[n + 1][4];
        // 初始化设定，第0列为第三种情况（即上下都有瓷砖）
        mark[0][3] = 1;
        for (int i = 1;i <= n;i++){
            mark[i][0] = mark[i - 1][3] % MOD;
            mark[i][1] = (mark[i - 1][0] % MOD + mark[i - 1][1]) % MOD;
            mark[i][2] = (mark[i - 1][0] % MOD + mark[i - 1][2]) % MOD;
            mark[i][3] = (((mark[i - 1][0] % MOD + mark[i - 1][1]) % MOD + mark[i - 1][2]) % MOD + mark[i - 1][3]) % MOD;
        }
        return mark[n][3];
    }
}
