package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * <p>
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class A17电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("29"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if (digits.length() == 0) {
            return ans;
        }
        Map<Character, String> opMap = new HashMap<>();
        opMap.put('2', "abc");
        opMap.put('3', "def");
        opMap.put('4', "ghi");
        opMap.put('5', "jkl");
        opMap.put('6', "mno");
        opMap.put('7', "pqrs");
        opMap.put('8', "tuv");
        opMap.put('9', "wxyz");
        make(opMap,ans,0,new StringBuffer(),digits);
        return ans;

    }

    public static void make(Map<Character, String> opMap, List<String> date, int index, StringBuffer sf, String digits) {
        if (index == digits.length()) {
            date.add(sf.toString());
            return;
        }
        String digit = opMap.get(digits.charAt(index));
        int count = digit.length();
        for (int i = 0;i < count;i++){
            char temp = digit.charAt(i);
            sf.append(temp);
            make(opMap,date,index + 1,sf,digits);
            //这里的删除十分关键，可以把这个看作是不断变换（要替换的话要先把之前的删去再添加）每一位的字母（字母范围取决与传入的digits）
            sf.deleteCharAt(index);
        }
    }
}
