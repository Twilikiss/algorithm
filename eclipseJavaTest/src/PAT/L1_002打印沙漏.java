package PAT;

import java.io.*;

/**
 * 本题要求你写个程序把给定的符号打印成沙漏的形状。例如给定17个“*”，要求按下列格式打印
 *
 * *****
 *  ***
 *   *
 *  ***
 * *****
 * 所谓“沙漏形状”，是指每行输出奇数个符号；各行符号中心对齐；相邻两行符号数差2；符号数先从大到小顺序递减到1，再从小到大顺序递增；首尾符号数相等。
 *
 * 给定任意N个符号，不一定能正好组成一个沙漏。要求打印出的沙漏能用掉尽可能多的符号。
 *
 * 输入格式:
 * 输入在一行给出1个正整数N（≤1000）和一个符号，中间以空格分隔。
 *
 * 输出格式:
 * 首先打印出由给定符号组成的最大的沙漏形状，最后在一行中输出剩下没用掉的符号数。
 *
 * 输入样例:
 * 19 *
 * 输出样例:
 * *****
 *  ***
 *   *
 *  ***
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
        int count = 1;
        int index = 1;
        while (true){
            if (count > total){
                break;
            }
            count += (1 + 2 * index) * 2;
            index++;
        }
        int cen = 0;
        for (int i = index - 2;i >= 0;i--){
            StringBuilder ans = new StringBuilder();
            for (int j = 0;j < cen;j++){
                ans.append(" ");
            }
            for (int j = 0;j < i * 2 + 1;j++){
                ans.append(op);
            }
            writer.write(ans.toString() + "\n");
            writer.flush();
            cen++;
        }
        for (int i = 1;i <= index - 2;i++){
            StringBuilder ans = new StringBuilder();
            for (int j = cen - 2;j > 0 ;j--){
                ans.append(" ");
            }
            for (int j = 0;j < i * 2 + 1;j++){
                ans.append(op);
            }
            writer.write(ans.toString() + "\n");
            writer.flush();
            cen--;
        }
        writer.write(String.valueOf(total - 8 * (index - 2) - 1) + "\n");
        writer.flush();
    }
}
