package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。
 * <p>
 * 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 也应该出现在 y 之前。
 * <p>
 * 返回 满足这个性质的 s 的任意排列 。
 * <p>
 * <p>
 * 示例 1:
 * 输入: order = "cba", s = "abcd"
 * 输出: "cbad"
 * 解释:
 * “a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
 * 因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。
 * <p>
 * 示例 2:
 * 输入: order = "cbafg", s = "abcd"
 * 输出: "cbad"
 * <p>
 * 提示:
 * 1 <= order.length <= 26
 * 1 <= s.length <= 200
 * order 和 s 由小写英文字母组成
 * order 中的所有字符都 不同
 */
public class A791自定义字符串排序 {
    public static void main(String[] args) {
        System.out.println(customSortString01("kqep", "pekeq"));
    }

    public static String customSortString(String order, String s) {
        int[] orders = new int[26];
        // 为order里的每一个字母按照其自定义顺序进行赋值
        for (int i = 0; i < order.length(); i++) {
            orders[order.charAt(i) - 'a'] = i + 1;
        }
        Character[] dates = new Character[s.length()];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = s.charAt(i);
        }
        Arrays.sort(dates, Comparator.comparingInt(x -> orders[x - 'a']));
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < dates.length; i++) {
            ans.append(dates[i]);
        }
        return ans.toString();
    }

    //计数排序
    public static String customSortString01(String order, String s) {
        int[] dates = new int[26];
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            dates[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < order.length(); i++) {
            char index = order.charAt(i);
            while (dates[index - 'a'] > 0) {
                ans.append(index);
                dates[index - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            while (dates[i] > 0) {
                ans.append((char) (i + 'a'));
                dates[i]--;
            }
        }
        return ans.toString();
    }
}
