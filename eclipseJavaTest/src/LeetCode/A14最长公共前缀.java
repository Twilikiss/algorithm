package LeetCode;

import com.sun.org.apache.xpath.internal.operations.Plus;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 */
public class A14最长公共前缀 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));
    }
    //解法一：对字符串数组内的字符串一一枚举来进行判断
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        boolean isChange = false;
        int index = 0;
        for(int j = 0;j < strs[0].length();j++){
            String temp = String.valueOf(strs[0].charAt(j));
            for(int i = 1;i < strs.length;i++){
                if (j >= strs[i].length()){
                    isChange = true;
                    break;
                }
                if (!temp.equals(String.valueOf(strs[i].charAt(j)))){
                    isChange = true;
                    break;
                }
            }
            if (isChange){
                break;
            } else {
                index++;
            }
        }
        return strs[0].substring(0,index);
    }
}
