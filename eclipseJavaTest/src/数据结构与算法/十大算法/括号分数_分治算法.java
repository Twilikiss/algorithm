package 数据结构与算法.十大算法;

public class 括号分数_分治算法 {
	public static void main(String[] args) {
		int i = scoreOfParentheses02("()(())()");
		System.out.println(i);
	}
	// 解法二：分治法
	public static int scoreOfParentheses02(String s) {
		if (s.length() == 2) {
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
			return scoreOfParentheses02(s.substring(0, len)) + scoreOfParentheses02(s.substring(len));
		}
	}
}
