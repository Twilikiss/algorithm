package LeetCode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import sun.launcher.resources.launcher;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: s = "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 
提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成

 * @author mlp520
 *
 */
public class 无重复字符的最长子串 {
	public static void main(String[] args) {
		String aString = "peewkew";
		System.out.println(lengthOfLongestSubstring(aString));
	}
	
	/**
	 * 滑动窗口解法，通常判断重复字符串是通过HashSet
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		
		Set<Character> windowSet = new HashSet<>();
		
		int n = s.length();
		int rk = -1;
		int total = 0;
		for(int i = 0;i < n;i++) {
			while(rk + 1 < n && !windowSet.contains(s.charAt(rk + 1))) {
				windowSet.add(s.charAt(rk + 1));
				rk++;
			}
			total = Math.max(total, rk - i + 1); 
			
			windowSet.remove(s.charAt(i));
		}
	    return total;
    }
}
