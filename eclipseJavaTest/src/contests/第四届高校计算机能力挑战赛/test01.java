package contests.第四届高校计算机能力挑战赛;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split(" ");
        int index = Integer.parseInt(data[1]);
        int number = Integer.parseInt(data[0].substring(0,index));
        double a = number / 10 + number % 10 * 0.1;
        Math.round(a);
        int b = data[0].length() - Integer.parseInt(data[1]);
        System.out.println(a + "E" + "+" + b);
    }
}
