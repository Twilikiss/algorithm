package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
	() 得 1 分。
	AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
	(A) 得 2 * A 分，其中 A 是平衡括号字符串。


示例 1：
输入： "()"
输出： 1

示例 2：
输入： "(())"
输出： 2

示例 3：
输入： "()()"
输出： 2

示例 4：
输入： "(()(()))"
输出： 6
 
提示：
S 是平衡括号字符串，且只含有 ( 和 ) 。
2 <= S.length <= 50

 * @author mlp52
 *
 */
public class A856括号分数 {
	public static void main(String[] args) {
		int i = scoreOfParentheses02("((()()))");
		System.out.println(i);
	}
	//代码待处理
	public int scoreOfParentheses(String s) {
		int answer = 0;
		if (s.length() == 2) {
			return 1;
		}
		Map<Character, Character> opMap = new HashMap<>();
		opMap.put(')', '(');
		Stack<Character> room = new Stack<>();
		int index = 0;
		for (int i = index; i < s.length(); i++) {
			char temp = s.charAt(i);
			if (opMap.containsKey(temp)) {
				room.pop();
			}
			room.push(temp);
		}
		return room.size();
	}
	//解法一：栈
	public static int scoreOfParentheses01(String s) {
		Deque<Integer> answerDeque = new ArrayDeque<>();
		answerDeque.push(0);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				answerDeque.push(0);
			} else {
				int value = answerDeque.pop();
				int InValue = answerDeque.pop() + Math.max(value * 2, 1);
				answerDeque.push(InValue);
			}
		}
		return answerDeque.peek();
	}
	//解法二：分治法
	public static int scoreOfParentheses02(String s) {
		if(s.length() == 2) {
			return 1;
		}
		int n = s.length();
		int len = 0;
		int IsBlance = 0;
		for (int i = 0; i < s.length(); i++) {
			IsBlance += s.charAt(i) == '(' ? 1 : -1; 
			if (IsBlance == 0) {
				len = i + 1;
				break;
			}	
		}
		if (len == n) {
			return 2 * scoreOfParentheses02(s.substring(1, n - 1));
		} else {
			return scoreOfParentheses02(s.substring(0,len)) + scoreOfParentheses02(s.substring(len));
		}
	}
}
