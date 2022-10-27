package LeetCode;

/**
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * <p>
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class A11盛水最多的容器 {
    public static void main(String[] args) {
        System.out.println(maxArea02(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    //O(n2)在数据量过大时， 会出现代码超时！！！
    public static int maxArea(int[] height) {
        int length = height.length;
        int maxWater = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int min = 0;
                if (height[i] > height[j]) {
                    min = height[j];
                } else {
                    min = height[i];
                }
                if (maxWater < min * (j - i)) {
                    maxWater = min * (j - i);
                }
            }
        }
        return maxWater;
    }

    static int maxValue = 0;

    //正确解法：双指针！
    public static int maxArea02(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;
        while(left < right){
            int temp = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(temp,maxWater);
            if (height[left] >= height[right]){
                right--;
            } else {
                left++;
            }
        }
        return maxWater;
    }
}
