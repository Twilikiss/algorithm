package 数据结构与算法.十大算法;

/**
 * 初学KMP算法可能对创建部分匹配值表的过程比较难以理解
 */
public class 部分匹配值表 {
    public static void main(String[] args) {
        int[] abcdabcs = kmpNext("ABCDABD");
        System.out.println(abcdabcs);
    }
    //获取到一个字符串(子串) 的部分匹配值表
    public static int[] kmpNext(String dest) {
//创建一个 next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为 1 部分匹配值就是 0
        for (int i = 1, j = 0; i < dest.length(); i++) {
//当 dest.charAt(i) != dest.charAt(j) ，我们需要从 next[j-1]获取新的 j
//直到我们发现 有dest.charAt(i) == dest.charAt(j) 成立才退出
//这时 kmp 算法的核心点
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
//当 dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
