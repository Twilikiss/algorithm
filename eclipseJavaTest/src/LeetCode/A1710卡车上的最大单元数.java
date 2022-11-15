package LeetCode;

import java.util.Arrays;

/**
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 * <p>
 * 示例 1：
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * <p>
 * 示例 2：
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 * <p>
 * <p>
 * 提示：
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 */
public class A1710卡车上的最大单元数 {
    public static void main(String[] args) {
        //[[962,723],[867,701],[575,390],[843,207],[9,586],[786,323],[126,686],[533,443],[363,72],[641,844]]
        //1486
        int[][] i = new int[][]{new int[]{962, 723}, new int[]{867, 701}, new int[]{575, 390}, new int[]{641, 844}};
        System.out.println(maximumUnits02(i, 1465));
    }

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int tempType = 0;
        int tempSize = 0;
        for (int i = 1; i <= boxTypes.length - 1; i++) {
            for (int j = 0; j < boxTypes.length - i; j++) {
                if (boxTypes[j][1] < boxTypes[j + 1][1]) {
                    tempType = boxTypes[j][0];
                    tempSize = boxTypes[j][1];
                    boxTypes[j] = boxTypes[j + 1];
                    boxTypes[j + 1] = new int[]{tempType, tempSize};
                }
            }
        }
        int total = 0;
        for (int i = 0; i < boxTypes.length; i++) {
            int type = boxTypes[i][0];
            int size = boxTypes[i][1];
            if (truckSize < type) {
                total = total + size * truckSize;
                break;
            }
            total = total + type * size;
            truckSize -= type;
        }
        return total;
    }

    /**
     * 贪心算法(不完全是感觉)
     *
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public static int maximumUnits01(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x, y) -> y[1] - x[1]);
        int total = 0;
        for (int[] boxType : boxTypes) {
            int type = boxType[0];
            int size = boxType[1];
            if (truckSize < type) {
                total = total + size * truckSize;
                break;
            }
            total = total + type * size;
            truckSize -= type;
        }
        return total;
    }

    /**
     * 计数排序的使用
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public static int maximumUnits02(int[][] boxTypes, int truckSize) {
        int ans = 0;
        int[] date = new int[10001];
        for (int[] boxType : boxTypes){
            date[boxType[1]] += boxType[0];
        }
        int i;
        for (i = 1000;i > 0 && truckSize >= 0;i--){
            ans += date[i] * i;
            truckSize -= date[i];
        }
        // 多多少补多少
        return ans + Math.min(0,truckSize) * i + 1;
    }

}
