package LeetCode;

import java.util.ArrayList;

/**
 *
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 *
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 *
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 *
 *
 * 示例 1：
 * 输入：s = "book"
 * 输出：true
 * 解释：a = "bo" 且 b = "ok" 。a 中有 1 个元音，b 也有 1 个元音。所以，a 和 b 相似。
 *
 * 示例 2：
 * 输入：s = "textbook"
 * 输出：false
 * 解释：a = "text" 且 b = "book" 。a 中有 1 个元音，b 中有 2 个元音。因此，a 和 b 不相似。
 * 注意，元音 o 在 b 中出现两次，记为 2 个。
 *
 * 提示：
 * 2 <= s.length <= 1000
 * s.length 是偶数
 * s 由 大写和小写 字母组成
 *
 * @ClassName A1704判断字符串的两半是否相似
 * @author   mlp52
 * @date  2022/11/11 15:58
 * @return
 * @param
 */
public class A1704判断字符串的两半是否相似 {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("book"));
    }
    public static boolean halvesAreAlike(String s) {
        ArrayList<Character> mark = new ArrayList<>();
        mark.add('a');
        mark.add('e');
        mark.add('i');
        mark.add('o');
        mark.add('u');
        mark.add('A');
        mark.add('E');
        mark.add('I');
        mark.add('O');
        mark.add('U');
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0;i < s.length() / 2;i++){
            if (mark.contains(s.charAt(i))){
                countLeft++;
            }
        }
        for (int i = s.length() / 2;i < s.length();i++){
            if (mark.contains(s.charAt(i))){
                countRight++;
            }
        }
        if (countLeft == countRight){
            return true;
        }
        return false;
    }
}
