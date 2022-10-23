package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树 。

示例 1：
输入：root = [1,3,null,null,2]
输出：[3,1,null,null,2]
解释：3 不能是 1 的左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。

示例 2：
输入：root = [3,1,4,null,null,2]
输出：[2,1,4,null,null,3]
解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 
提示：
树上节点的数目在范围 [2, 1000] 内
-231 <= Node.val <= 231 - 1
 
进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用 O(1) 空间的解决方案吗？
 * @author mlp52
 *
 */
public class A99恢复二叉搜索树 {
	public static void main(String[] args) {
		TreeNode node01 = new TreeNode(3);
		TreeNode node02 = new TreeNode(2);
		TreeNode node03 = new TreeNode(1);
		TreeNode node04 = new TreeNode(4);
		node01.left = node03;
		node01.right = node04;
		node04.left = node02;
		recoverTree(node01);
	}

	private static TreeNode t1 = null;
	private static TreeNode t2 = null;
	private static TreeNode pre = null;
	
	public static void recoverTree(TreeNode root) {
		justDoIt(root);
		int temp = t1.val;
		t1.val = t2.val;
		t2.val = temp;
	}
	public static void justDoIt(TreeNode root){
		if (root == null) {
			return;
		}
		justDoIt(root.left);
		if (pre != null && pre.val > root.val) {
			if (t1 == null) {
				t1 = pre;
			}
			t2 = root;
		}
		pre = root;
		justDoIt(root.right);
	}
}
