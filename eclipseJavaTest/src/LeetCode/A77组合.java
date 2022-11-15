package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 示例 1：
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class A77组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 3));
    }
    public static List<List<Integer>> combine(int n, int k) {
        Deque<Integer> temp = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        make(temp,ans,n,k,1);
        return ans;
    }

    public static void make(Deque<Integer> temp,List<List<Integer>> ans, int n, int k,int start){
        if (temp.size() == k){
            ans.add(new ArrayList<>(temp));
        } else {
            for (int i = start;i <= n-(k-temp.size()) + 1;i++){
                temp.addLast(i);
                make(temp,ans,n,k,i + 1);
                temp.removeLast();
            }
        }
    }
}
