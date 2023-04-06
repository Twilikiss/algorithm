package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q6
 * @date 2/4/2023 上午9:43
 */
public class Q6 {
    public static void main(String[] args) {
        int[] D = new int[]{31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] data = new String[0];
        try {
            data = reader.readLine().split("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Integer.parseInt(data[1]) > 12) {
            int MM = Integer.parseInt(data[0]);

            if (MM == 2){
                D[MM] = Integer.parseInt(data[2]) % 4 == 0 ? 29 : 28;
            }
            if (Integer.parseInt(data[0]) <= 12 && D[MM] >= Integer.parseInt(data[1])) {
                System.out.println("MMDDYY");
            } else {
                System.out.println("NOTHING");
            }
        } else if (Integer.parseInt(data[0]) > 12) {
            int MM = Integer.parseInt(data[1]);
            if (MM == 2){
                D[MM] = Integer.parseInt(data[2]) % 4 == 0 ? 29 : 28;
            }
            if (Integer.parseInt(data[1]) <= 12 && D[MM] >= Integer.parseInt(data[0])) {
                System.out.println("DDMMYY");
            } else {
                System.out.println("NOTHING");
            }
        } else if (Integer.parseInt(data[0]) <= 12 && Integer.parseInt(data[1]) <= 12) {
            System.out.println("BOTH");
        } else {
            System.out.println("NOTHING");
        }
    }
}
