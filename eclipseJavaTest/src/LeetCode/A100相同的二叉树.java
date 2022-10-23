package LeetCode;

import java.util.ArrayList;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
//这里要注意不要简单照搬二叉树的中序遍历！！！
public class A100相同的二叉树 {
    public static void main(String[] args) {
        System.out.println(isSameTree(null, null));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p ==  null && q == null){
            return true;
        } else if(p == null || q == null){
            return false;
        } else if(p.val != q.val){
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
        }
    }
}
