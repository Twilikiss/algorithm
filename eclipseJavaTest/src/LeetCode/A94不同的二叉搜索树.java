package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

示例 1：

输入：n = 3
输出：5

示例 2：
输入：n = 1
输出：1
 
提示：
1 <= n <= 19
 * @author mlp52
 *
 */
public class A94不同的二叉搜索树 {
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}

	//根节点x将树分成两部分——【1~x】和【x~n】
	public static int numTrees(int n) {
		int[] answer = new int[n + 1];
		answer[0] = 1;
		answer[1] = 1;
		for(int i = 2;i <= n;i++) {
			for(int k= 1;k <= i;k++) {
				answer[i] += answer[k - 1] * answer[i - k];
			}
		}
		return answer[n];
	}
	
}