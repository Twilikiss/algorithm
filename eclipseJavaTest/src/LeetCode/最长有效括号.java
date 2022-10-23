package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

示例 3：
输入：s = ""
输出：0
 
提示：
0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'

 * @author mlp52
 *
 */
public class 最长有效括号 {
	public static void main(String[] args) {
		int out = longestValidParentheses("))))()(()((");
		System.out.println(out);
	}

	public static int longestValidParentheses(String s) {
		int maxValue = 0;
		Deque<Integer> count = new ArrayDeque<>();
		count.push(-1);
		for(int i = 0;i < s.length();i++) {
			if (s.charAt(i) == '(') {
				count.push(i);
			} else {
				count.pop();
				if (count.isEmpty()) {
					count.push(i);
				} else {
					maxValue = Math.max(maxValue, i - count.peek());
				}
			}
		}
		return maxValue;
	}
}
