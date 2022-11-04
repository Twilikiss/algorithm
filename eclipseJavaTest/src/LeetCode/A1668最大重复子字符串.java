package LeetCode;

/**
 * 给你一个字符串sequence，如果字符串 word连续重复k次形成的字符串是sequence的一个子字符串，那么单词word 的 重复值为 k 。
 * 单词 word的 最大重复值是单词word在sequence中最大的重复值。如果word不是sequence的子串，那么重复值k为 0 。
 *
 * 给你一个字符串 sequence和 word，请你返回 最大重复值k 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：sequence = "ababc", word = "ab"
 * 输出：2
 * 解释："abab" 是 "ababc" 的子字符串。
 * 示例 2：
 *
 * 输入：sequence = "ababc", word = "ba"
 * 输出：1
 * 解释："ba" 是 "ababc" 的子字符串，但 "baba" 不是 "ababc" 的子字符串。
 * 示例 3：
 *
 * 输入：sequence = "ababc", word = "ac"
 * 输出：0
 * 解释："ac" 不是 "ababc" 的子字符串。
 *
 *
 * 提示：
 *
 * 1 <= sequence.length <= 100
 * 1 <= word.length <= 100
 * sequence 和word都只包含小写英文字母。
 *
 */
public class A1668最大重复子字符串 {
    public static void main(String[] args) {
        System.out.println(maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba","aaaba"));
    }
    public static int maxRepeating(String sequence, String word) {
        if(!sequence.contains(word)){
            return 0;
        }
        int total = 0;
        String op = word;
        while (true){
            if (sequence.indexOf(word) != -1){
                total++;
            } else {
                break;
            }
            word += op;
        }
        return total;
    }
}
