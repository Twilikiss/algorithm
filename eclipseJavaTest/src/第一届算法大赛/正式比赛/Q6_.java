package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q6_
 * @date 2/4/2023 上午11:50
 */
public class Q6_ {
    public static void main(String[] args) {
        int[] D = new int[]{0,31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] data = new String[0];
        try {
            data = reader.readLine().split("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int p1 = Integer.parseInt(data[0]);
        int p2 = Integer.parseInt(data[1]);
        int p3 = Integer.parseInt(data[2]);
        if (p1 <= 12 && p2 <= 12){
            System.out.println("BOTH");
        } else if (p1 > 12 && p2 <= 12){
            if (p2 == 2){
                if (p3 % 4 == 0){
                    D[p2] = 29;
                } else {
                    D[p2] = 28;
                }
            }
            if (D[p2] >= p1){
                System.out.println("DDMMYY");
            } else {
                System.out.println("NOTHING");
            }
        } else if (p1 <= 12){
            if (p1 == 2){
                if (p3 % 4 == 0){
                    D[p1] = 29;
                } else {
                    D[p1] = 28;
                }
            }
            if (D[p1] >= p2){
                System.out.println("MMDDYY");
            } else {
                System.out.println("NOTHING");
            }
        } else {
            System.out.println("NOTHING");
        }
    }
}
