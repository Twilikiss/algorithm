package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是s的子序列的单词个数 。
 * <p>
 * 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。
 * <p>
 * 例如， “ace” 是 “abcde” 的子序列。
 * <p>
 * 示例 1:
 * 输入: s = "abcde", words = ["a","bb","acd","ace"]
 * 输出: 3
 * 解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
 * <p>
 * Example 2:
 * 输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * 输出: 2
 * <p>
 * 提示:
 * 1 <= s.length <= 5 * 104
 * 1 <= words.length <= 5000
 * 1 <= words[i].length <= 50
 * words[i]和 s 都只由小写字母组成。
 */
public class A792匹配子序列的单词数 {
    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        temp.add(3);
        temp.add(5);
        temp.add(7);
        temp.add(9);
        System.out.println(binarySearch(temp, 6));
    }

    /**
     * 解法一：hash表+二分查找，传统暴力枚举会出现超时现象
     *
     * @param s
     * @param words
     * @return
     */
    public static int numMatchingSubseq(String s, String[] words) {
        // 创建小写字母表内的hash表
        List<Integer>[] date = new List[26];
        for (int i = 0; i < date.length; i++) {
            date[i] = new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            // 创建字符对应出现的位置的
            date[index - 'a'].add(i);
        }

        int count = words.length;
        for (String word : words) {
            if (word.length() > s.length()) {
                count--;
                continue;
            }
            int index = -1;
            for (int i = 0;i < word.length();i++){
                char c = word.charAt(i);
                // 如果不存在或者未按照题目要求的顺序
                if (date[c - 'a'].isEmpty() || date[c - 'a'].get(date[c - 'a'].size() - 1) <= index){
                    count--;
                    break;
                }
                //通过二分查找法在date[c - 'a']找到第一个比index大的的值
                index = binarySearch(date[c - 'a'],index);
            }
        }
        return count;
    }

    public static int binarySearch(List<Integer> list,int target){
        int left = 0;
        int right = list.size() - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
