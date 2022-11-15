package LeetCode;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *      /  \
 *    15   7
 * 返回它的最大深度 3 。
 */
public class A104二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node01 = new TreeNode(9);
        TreeNode node02 = new TreeNode(20);
        TreeNode node03 = new TreeNode(15);
        TreeNode node04 = new TreeNode(7);
        root.left = node01;
        root.right = node02;
        node02.left = node03;
        node02.right = node04;
        System.out.println(maxDepth(root));
    }
    static int max = 1;
    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        make(root,1);
        return max;
    }
    public static void make(TreeNode root, int size){
        if (root.left != null){
            make(root.left, size + 1);
        }
        max = Math.max(max, size);
        if (root.right != null){
            make(root.right, size+ 1);
        }
    }
}
