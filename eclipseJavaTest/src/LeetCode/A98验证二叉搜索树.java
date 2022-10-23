package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 

示例 1：

输入：root = [2,1,3] 
输出：true

示例 2：

输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。


提示：
树中节点数目范围在[1, 104] 内
-231 <= Node.val <= 231 - 1
 * @author mlp52
 *
 */
public class A98验证二叉搜索树 {
	public static void main(String[] args) {
		TreeNode node01 = new TreeNode(1);
		TreeNode node012 = new TreeNode(2);
		TreeNode node013 = new TreeNode(3);
		node012.left = node01;
		node012.right = node013;
		System.out.println(isValidBST(node012));
	}
	private static List<Integer> totaList = new ArrayList<>();

	public static boolean isValidBST(TreeNode root) {
		infixe(root);
		for(int i = 1;i < totaList.size();i++) {
			if (totaList.get(i) < totaList.get(i - 1)) {
				return false;
			}
		}
		return true;
	}

	public static void infixe(TreeNode root) {
		if (root.left != null) {
			infixe(root.left);
		}
		totaList.add(root.val);
		if (root.right != null) {
			infixe(root.right);
		}
	}
}

