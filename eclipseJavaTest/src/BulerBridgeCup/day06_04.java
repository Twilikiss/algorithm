package BulerBridgeCup;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。(动态规划经典例题) 示例 1： 输入：s = "babad" 输出："bab" 解释："aba"
 * 同样是符合题意的答案。 示例 2：
 * 
 * 输入：s = "cbbd" 输出："bb"
 * 
 * 提示： 1 <= s.length <= 1000 s 仅由数字和英文字母组成。
 * 
 * @author mlp52
 *
 */
public class day06_04 {
	public static void main(String[] args) {
			String iString = "cbbd";
			String longestPalindrome = longestPalindrome(iString);
			System.out.println(longestPalindrome);
	}

	public static String longestPalindrome(String s) {
		int L = s.length();
		//判断字符串长度为1时的情况
		if (L < 2) {
			return s;
		}	
		
		//将字符串转换为char型数组
		char[] charArray = s.toCharArray();
		//创建char型二维数组，记录是否为回文数
		boolean[][] dp = new boolean[L][L];
		int maxLen = 1;
		int begin = 0;
		//初始化回文子字符串长度为1的情况（true）
		for (int i = 0;i < L;i++) {
			dp[i][i] = true;
		}
		//字符串的长度大于1时的情况
		for(int len = 2;len <= L;len ++) {
			//枚举左边界（此处的边界可以设置的较为宽松）
			for(int leaf = 0;leaf < L;leaf ++) {
				//写出右边界（此处的右边界可以由左边界得出）
				int right = len + leaf - 1;
				
				//判断右边界是否越界（这样左边界可以设置的宽松些）
				if (right >= L) {
					break;
				}
				
				//判断子字符串的两端是否相等
				if (charArray[leaf] != charArray[right]) {
					dp[leaf][right] = false;
				} else {
					//当子字符串的长度小于3（即长度为2和3时，只要判断左右两端的数字相等即可）
					if (right - leaf < 3) {
						dp[leaf][right] = true;
					} else {
						dp[leaf][right] = dp[leaf + 1][right - 1];
					}
				}
				
				if (dp[leaf][right] && right - leaf + 1 > maxLen) {
					maxLen = right - leaf + 1;
					begin = leaf;
				}
			}
		}
		return s.substring(begin,begin + maxLen);
	}
}
