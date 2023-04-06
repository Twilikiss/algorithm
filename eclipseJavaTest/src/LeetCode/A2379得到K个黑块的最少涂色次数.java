package LeetCode;

/**
 * @author cxb
 * @ClassName A2379得到K个黑块的最少涂色次数
 * @date 9/3/2023 上午8:55
 */
public class A2379得到K个黑块的最少涂色次数 {
    public static void main(String[] args) {
        int result = minimumRecolors02("WBBWWBBWBW",7);
        System.out.println(result);
    }

    // 解法一
    public static int minimumRecolors(String blocks, int k) {
        int minValue = Integer.MAX_VALUE;
        int total = 0;
        for (int index = 0; index <= blocks.length() - k; index++) {
            for (int i = index; i < index + k; i++) {
                total += blocks.charAt(i) == 'W' ? 1 : 0;
            }
            minValue = Math.min(total, minValue);
            total = 0;
        }
        return minValue;
    }

    // 解法二：滑动窗口
    public static int minimumRecolors02(String blocks, int k) {
        int left = 0;
        int right = 0;
        int minValue = 0;
        int total = 0;
        for (int i = 0; i < k; i++) {
            total += blocks.charAt(i) == 'W' ? 1 : 0;
            right++;
        }
        minValue = total;
        while (right < blocks.length()) {
            total -= blocks.charAt(left) == 'W' ? 1 : 0;
            total += blocks.charAt(right) == 'W' ? 1 : 0;
            minValue = Math.min(total, minValue);
            left++;
            right++;
        }
        return minValue;
    }
}
