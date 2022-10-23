package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
示例 1：
输入：n = 3
输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

示例 2：
输入：n = 1
输出：[[1]]

提示：
1 <= n <= 8

 * @author mlp52
 *
 */
public class A95不同的二叉搜索树II {
	//本题采用的是回溯算法！
	public static List<TreeNode> generateTrees(int n) {
		if(n == 0) {
			return new ArrayList<>();
		}
		return genateTreeNodes(1, n);
	}
	
	public static List<TreeNode> genateTreeNodes(int start, int end){
		List<TreeNode> total = new ArrayList<>();
		if (start > end) {
			total.add(null);
			return total;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = genateTreeNodes(start, i - 1);
			List<TreeNode> right = genateTreeNodes(i + 1, end);
			for(TreeNode leftNode : left) {
				for(TreeNode rightNode : right) {
					TreeNode rootNode = new TreeNode(i);
					rootNode.left = leftNode;
					rootNode.right = rightNode;
					total.add(rootNode);
				}
			}
		}
		return total;
	}

}
