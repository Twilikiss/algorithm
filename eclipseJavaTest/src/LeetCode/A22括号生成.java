package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * 1 <= n <= 8
 */
public class A22括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        make(new char[n * 2], 0, result);
        return result;
    }

    public static void make(char[] tempDate, int pos, List<String> result) {
        if (pos == tempDate.length) {
//            result.add(new String(tempDate));
            if (findIsCorrect(tempDate)) {
                result.add(new String(tempDate));
            }
        } else {
            tempDate[pos] = '(';
            make(tempDate, pos + 1, result);
            tempDate[pos] = ')';
            make(tempDate, pos + 1, result);
        }
    }

    public static boolean findIsCorrect(char[] date) {
        int total = 0;
        for (char temp : date) {
            if (temp == '(') {
                total++;
            } else {
                total--;
            }
            if (total < 0) {
                return false;
            }
        }
        return total == 0;
    }
}
