package LeetCode;

/**
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * <p>
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * <p>
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。
 * 注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * <p>
 * 示例 2：
 * <p>
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * <p>
 * 提示：
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都 不重复
 */
public class A764最大加号标志 {
    public static void main(String[] args) {
        System.out.println(orderOfLargestPlusSign(5, new int[][]{new int[]{4, 2}}));
    }
    //为啥错了啊！！！！！！！！！！
    public static int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = 1;
            }
        }
        for (int i = 0; i < mines.length; i++) {
            int x = mines[i][0];
            int y = mines[i][1];
            map[x][y] = 0;
        }
        int maxSize = 0;
        int size = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (isMatch(map, i, j, size)) {
                    maxSize += 1;
                    size++;
                    break;
                }
            }
        }
        if (size == 0){
            return 1;
        } else {
            return maxSize;
        }
    }

    public static boolean isMatch(int[][] map, int midPosX, int midPosY, int size) {
        if (midPosX - size < 0 || midPosX + size >= map.length){
            return false;
        }
        if (midPosY - size < 0 || midPosY + size >= map.length){
            return false;
        }
        for (int i = midPosX - size;i <= midPosX + size;i++){
            if (map[i][midPosY] == 0){
                return false;
            }
        }
        for (int i = midPosY - size;i <= midPosY + size;i++){
            if (map[midPosX][i] == 0){
                return false;
            }
        }
        return true;
    }
    //评论区大佬的暴力解法
    public static int orderOfLargestPlusSign01(int n, int[][] mines) {
        int ans = 0;
        int[][] target = new int[n][n];
        for (int i = 0;i < mines.length;i++){
            target[mines[i][0]][mines[i][1]] = 1;
        }
        for (int i = 0;i < n;i++){
            for (int j = 0;j < n;j++){
                ans = Math.max(ans,find(target,i,j,n));
            }
        }
        return ans;
    }
    public static int find(int[][] map,int x, int y,int n){
        if (map[x][y] == 1){
            return 0;
        }
        int k = 0;
        while (true){
            if (x - k < 0 || map[x - k][y] == 1 || x + k == n || map[x + k][y] == 1 || y - k < 0 || map[x][y - k] == 1 || y + k == n || map[x][y + k] == 1){
                break;
            }
            k++;
        }
        return k;
    }
}
