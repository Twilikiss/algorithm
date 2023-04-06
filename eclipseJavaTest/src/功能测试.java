import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 功能测试 {
    public static void main(String[] args) throws IOException {
//        //要求给与2 * n的大小和”（“、”）“这两个符号，对这些括号的排列有哪些
//        Scanner scanner = new Scanner(System.in);
//        String n = scanner.nextLine();
//        List<String> ans = new ArrayList<>();
//        int m = Integer.parseInt(n);
//        make(new char[m * 2], 0, ans);
//        System.out.println(ans);
        int[] arrays = new int[]{1, 3, 2};
        Arrays.sort(arrays);
        System.out.println(Arrays.toString(arrays));

    }

    //联系二叉树的遍历
    public static void make(char[] date, int pos, List<String> result) {
        if (pos == date.length) {
            result.add(new String(date));
        } else {
            date[pos] = '(';
            make(date, pos + 1, result);
            date[pos] = ')';
            make(date, pos + 1, result);
        }
    }

    @Test
    public void test01() {
        System.out.println(
                "                ********\n" +
                        "               ************\n" +
                        "               ####....#.\n" +
                        "             #..###.....##....\n" +
                        "             ###.......######              ###            ###\n" +
                        "                ...........               #...#          #...#\n" +
                        "               ##*#######                 #.#.#          #.#.#\n" +
                        "            ####*******######             #.#.#          #.#.#\n" +
                        "           ...#***.****.*###....          #...#          #...#\n" +
                        "           ....**********##.....           ###            ###\n" +
                        "           ....****    *****....\n" +
                        "             ####        ####\n" +
                        "           ######        ######\n" +
                        "##############################################################\n" +
                        "#...#......#.##...#......#.##...#......#.##------------------#\n" +
                        "###########################################------------------#\n" +
                        "#..#....#....##..#....#....##..#....#....#####################\n" +
                        "##########################################    #----------#\n" +
                        "#.....#......##.....#......##.....#......#    #----------#\n" +
                        "##########################################    #----------#\n" +
                        "#.#..#....#..##.#..#....#..##.#..#....#..#    #----------#\n" +
                        "##########################################    ############");
    }

    @Test
    public void test02() {
        char a = 'a';
        int b = 1;
        System.out.println((char) (b + a));
    }

    @Test
    public void test03() {
        int[] nums = new int[]{1, 3, 2, 4, 5, 9, 7, 8, 6};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test04() {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int f = Integer.parseInt(s);
        String out = String.valueOf((f - 32) / 9 * 5);
        System.out.println("Celsius = " + out);
    }
}

class StringOp {
    //判断字符串数字的个数
    public int countNum(String date) {
        int ans = 0;
        for (int i = 0; i < date.length(); i++) {
            char c = date.charAt(i);
            if (Character.isDigit(c)) {
                ans++;
            }
        }
        return ans;
    }
}