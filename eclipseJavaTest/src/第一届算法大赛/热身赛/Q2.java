package 第一届算法大赛.热身赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q2
 * @date 28/3/2023 下午8:02
 */
public class Q2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[0];
        try {
            s = reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        if (month == 4 || month == 6 || month == 9 || month == 11){
            System.out.println("30");
        } else if (month == 2){
            if (year % 4 == 0 && year % 100 != 0){
                System.out.println("29");
            } else {
                System.out.println("28");
            }
        } else {
            System.out.println("31");
        }
    }
}
