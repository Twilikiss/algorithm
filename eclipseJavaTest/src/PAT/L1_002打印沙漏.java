package PAT;

import java.io.*;
import java.util.ArrayList;

/**
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 * <p>
 * *****
 * ***
 * *
 * ***
 * *****
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 * <p>
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 * <p>
 * 输入格式:
 * 输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。
 * <p>
 * 输出格式:
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 * <p>
 * 输入样例:
 * 19 *
 * 输出样例:
 * *****
 * ***
 * *
 * ***
 * *****
 * 2
 * 代码长度限制
 * 16 KB
 * 时间限制
 * 400 ms
 * 内存限制
 * 64 MB
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] date = bf.readLine().split(" ");
        int total = Integer.parseInt(date[0]);
        String op = date[1];
        int storey = (int) Math.sqrt((total - 1) / 2.0 + 1);
        int max = (int) Math.pow(storey, 2);
        int left = storey == 0 ? 0 : total - max * 2 + 1;
        ArrayList<String> temp = new ArrayList<>();
        for (int i = 1; i <= storey; i++) {
            String text = "";
            String a = "";
            for (int k = 0; k < ((storey - i + 1) * 2 - 1) / 2; k++) {
                a += " ";
            }
            for (int j = 0; j < i * 2 - 1; j++) {
                text += op;
            }
            temp.add(a + text);
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.println(temp.get(i));
        }
        for (int i = 0; i < temp.size(); i++) {
            if (i != 0){
                System.out.println(temp.get(i));
            }
        }
        System.out.println(left);
    }
}
