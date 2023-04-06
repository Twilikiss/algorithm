package 数据结构与算法.other;

import java.util.Scanner;

public class 最小公倍数与最大公约数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int m = a;
        int n = b;
        int c = -1;
        while (c != 0){
            c = a % b;
            a = b;
            b = c;
        }
        System.out.println("最大公约数：" + a);
        System.out.println("最小公倍数：" + m * n / a);
    }
}
