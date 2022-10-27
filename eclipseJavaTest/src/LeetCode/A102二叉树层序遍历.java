package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 *  示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数目在范围 [0, 2000] 内
 * -1000 <= Node.val <= 1000
 */
public class A102二叉树层序遍历 {
    public static void main(String[] args) {
        TreeNode node01 = new TreeNode(-150);
        TreeNode node02 = new TreeNode(-50);
        TreeNode node03 = new TreeNode(-147);
        TreeNode node04 = new TreeNode(-148);
        node01.right = node02;
        node02.right = node03;
        node03.right = node04;
        List<List<Integer>> lists = levelOrder(node01);
        System.out.println("done");
    }
    private static ArrayList<String> total = new ArrayList<>();
    public static List<List<Integer>> levelOrder(TreeNode root) {
        infixOrder(root,1000);
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0;i < total.size();i++){
            String temp = total.get(i);
            int index = Integer.parseInt(temp.substring(temp.length() - 4));
            int value = Integer.parseInt(temp) / 10000;
            if (!map.containsKey(index)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(value);
                map.put(index,list);
            } else {
                map.get(index).add(value);
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> in : map.entrySet()){
            ans.add(in.getValue());
        }
        return ans;
    }
    //借用之前在A100相同的二叉树中使用“层数”来做后缀
    public static void  infixOrder(TreeNode root, int size){
        if (root == null){
            return;
        }
        infixOrder(root.left,size + 1);
        String temp =String.valueOf(root.val) + size;
        total.add(temp);
        infixOrder(root.right,size + 1);
    }
}
