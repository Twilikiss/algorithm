package LeetCode;

import org.junit.validator.PublicClassValidator;

import com.sun.org.apache.bcel.internal.generic.I2F;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

例如，121 是回文，而 123 不是。

示例 1：
输入：x = 121
输出：true

示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。
 

提示：
-231 <= x <= 231 - 1
 
进阶：你能不将整数转为字符串来解决这个问题吗？

 * @author mlp52
 *
 */
public class 回文数 {
	public static void main(String[] args) {
		System.out.println(isPalindrome(12112));
		System.out.println(isPalindrome01(12112));
	}

	/**
	 * 解法一：将int转为字符串来进行处理
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		String xString = Integer.toString(x);
		boolean isWrong = false;
		for (int i = 0; i < xString.length(); i++) {
			int j = xString.length() - 1 -i;
			if (i > j) {
				break;
			}
			if (xString.charAt(i) != xString.charAt(j)) {
				isWrong = true;
				break;
			}
		}
		return !isWrong;
	}
	/**
	 * 求解的思路：将整个数字反转过来并不是最简的，可以考虑将数字的一半反转过来检查与上半段是否相等
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome01(int x) {
		int reversalNumber = 0;
		//排除负数，负数一定不是回文数
		//除了个位数0以外，个位为0的都不是回文数
		if(x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		while (reversalNumber < x) {
			reversalNumber = reversalNumber * 10 + x % 10;
			x = x / 10;
		}
		return  x == reversalNumber || x == reversalNumber / 10;
	}
}
