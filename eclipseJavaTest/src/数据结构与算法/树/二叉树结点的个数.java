package 数据结构与算法.树;

import LeetCode.TreeNode;

public class 二叉树结点的个数 {
    int count = 0;
    public void countChild(TreeNode root){
        if (root.left != null){
            countChild(root.left);
        }
        if (root.right != null){
            countChild(root.right);
        }
        count++;
    }
}
