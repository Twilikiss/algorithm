package 第一届算法大赛.正式比赛;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int[] year = new int[]{31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split("/");
        int p1 = Integer.parseInt(data[0]);
        int p2 = Integer.parseInt(data[1]);
        int p3 = Integer.parseInt(data[2]);
        if (p1 <= 12 && p2 <= 12){
            System.out.println("BOTH");
        } else if (p1 > 12 && p2 <= 12){
            if (p2 == 2){
                if (p3 % 4 == 0){
                    year[p2] = 29;
                } else {
                    year[p2] = 28;
                }
            }
            if (year[p2] >= p1){
                System.out.println("DDMMYY");
            } else {
                System.out.println("NOTHING");
            }
        } else if (p1 <= 12){
            if (p1 == 2){
                if (p3 % 4 == 0){
                    year[p1] = 29;
                } else {
                    year[p1] = 28;
                }
            }
            if (year[p1] >= p2){
                System.out.println("MMDDYY");
            } else {
                System.out.println("NOTHING");
            }
        } else {
            System.out.println("NOTHING");
        }
    }
}
