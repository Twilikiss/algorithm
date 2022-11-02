package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个数组 towers和一个整数 radius 。
 * <p>
 * 数组 towers 中包含一些网络信号塔，其中towers[i] = [xi, yi, qi]表示第i个网络信号塔的坐标是(xi, yi)且信号强度参数为qi。所有坐标都是在 X-Y 坐标系内的整数坐标。两个坐标之间的距离用 欧几里得距离计算。
 * <p>
 * 整数radius表示一个塔 能到达的 最远距离。如果一个坐标跟塔的距离在 radius以内，那么该塔的信号可以到达该坐标。在这个范围以外信号会很微弱，所以 radius以外的距离该塔是 不能到达的。
 * <p>
 * 如果第 i个塔能到达 (x, y)，那么该塔在此处的信号为⌊qi / (1 + d)⌋，其中d是塔跟此坐标的距离。一个坐标的 信号强度 是所有 能到达该坐标的塔的信号强度之和。
 * <p>
 * 请你返回数组 [cx, cy] ，表示 信号强度 最大的 整数 坐标点(cx, cy) 。如果有多个坐标网络信号一样大，请你返回字典序最小的 非负 坐标。
 * <p>
 * 注意：
 * <p>
 * 坐标(x1, y1)字典序比另一个坐标(x2, y2) 小，需满足以下条件之一：
 * 要么x1 < x2，
 * 要么x1 == x2 且y1 < y2。
 * ⌊val⌋表示小于等于val的最大整数（向下取整函数）。
 * <p>
 * <p>
 * 示例 1：
 * 输入：towers = [[1,2,5],[2,1,7],[3,1,9]], radius = 2
 * 输出：[2,1]
 * 解释：
 * 坐标 (2, 1) 信号强度之和为 13
 * - 塔 (2, 1) 强度参数为 7 ，在该点强度为 ⌊7 / (1 + sqrt(0)⌋ = ⌊7⌋ = 7
 * - 塔 (1, 2) 强度参数为 5 ，在该点强度为 ⌊5 / (1 + sqrt(2)⌋ = ⌊2.07⌋ = 2
 * - 塔 (3, 1) 强度参数为 9 ，在该点强度为 ⌊9 / (1 + sqrt(1)⌋ = ⌊4.5⌋ = 4
 * 没有别的坐标有更大的信号强度。
 * <p>
 * 示例 2：
 * 输入：towers = [[23,11,21]], radius = 9
 * 输出：[23,11]
 * 解释：由于仅存在一座信号塔，所以塔的位置信号强度最大。
 * <p>
 * 示例 3：
 * 输入：towers = [[1,2,13],[2,1,7],[0,1,9]], radius = 2
 * 输出：[1,2]
 * 解释：坐标 (1, 2) 的信号强度最大。
 * <p>
 * 提示：
 * 1 <= towers.length <= 50
 * towers[i].length == 3
 * 0 <= xi, yi, qi <= 50
 * 1 <= radius <= 50
 */
public class A1620网络信号最好的坐标 {
    public static void main(String[] args) {
        int[][] towers = new int[][]{new int[]{33, 24, 12}, new int[]{5, 34, 12}, new int[]{9, 45, 6}, new int[]{28, 12, 12}};
        System.out.println(Arrays.toString(bestCoordinate(towers, 2)));
    }

    public static int[] bestCoordinate(int[][] towers, int radius) {
        int maxY = 0;
        int maxX = 0;
        int minX = 0;
        int minY = 0;
        for (int i = 0;i < towers.length;i++){
            minX = Math.min(minX,towers[i][0]);
            minY = Math.min(minY,towers[i][1]);
            maxX = Math.max(maxX,towers[i][0]);
            maxY = Math.max(maxY,towers[i][1]);
        }
        int preMax = 0;
        int[] ans = new int[2];
        for (int x1 = minX;x1 <= maxX;x1++) {
            for (int y1 = minY;y1 <= maxY;y1++) {
                int max = 0;
                for (int i = 0; i < towers.length; i++) {
                    double v = Math.pow(towers[i][0] - x1, 2) + Math.pow(towers[i][1] - y1, 2);
                    if ((v > Math.pow(radius, 2))) {
                        continue;
                    }
                    max += (int) (towers[i][2] / (1 + Math.sqrt(v)));
                }
                if (max > preMax) {
                    ans[0] = x1;
                    ans[1] = y1;
                    preMax = max;
                }
                if (max == preMax) {
                    if (ans[0] > x1) {
                        ans[0] = x1;
                        ans[1] = y1;
                    }
                    if (ans[0] == x1 && ans[1] > y1) {
                        ans[0] = x1;
                        ans[1] = y1;
                    }
                }
            }

        }
        return ans;
    }
}
