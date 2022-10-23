package LeetCode;

import java.util.ArrayList;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false

 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class A101对称二叉树 {
    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(1);
        TreeNode node02 = new TreeNode(2);
        TreeNode node03 = new TreeNode(2);
        TreeNode node04 = new TreeNode(2);
        TreeNode node05 = new TreeNode(2);
        TreeNode node06 = new TreeNode(4);
        TreeNode node07 = new TreeNode(4);
        node01.left = node02;
        node01.right = node03;
        node02.left = node04;
        node03.left = node05;
        boolean symmetric = isSymmetric01(node01);
        boolean b = isSymmetric02(node01);
        System.out.println(symmetric);
        System.out.println(b);
    }

    /**
     * 解法一：中序遍历法
     */
    private static ArrayList<Integer> left = new ArrayList<>();

    public static boolean isSymmetric01(TreeNode root) {
        infixOrder(root, 0);
        int index = 0;
        int right = left.size() - 1;
        while (index < right){
            if (left.get(index) != left.get(right)){
                return false;
            }
            index++;
            right--;
        }
        return true;
    }
    public static void infixOrder(TreeNode root,int i){
        if (root == null){
           left.add(101 + i);
            return;
        }
        infixOrder(root.left,i + 1);
        left.add(root.val);
        infixOrder(root.right, i + 1);
    }

    /**
     * 解法二：递归解法，向左右两边不断遍历
     */
    public static boolean isSymmetric02(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode node01,TreeNode node02){
        if (node01 == null && node02 == null){
            return true;
        }
        if(node01 == null || node02 == null){
            return false;
        }
        if(node01.val != node02.val){
            return false;
        }
        return check(node01.left, node02.right) && check(node01.right,node02.left);
    }
}
