package 第一届算法大赛.热身赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q1
 * @date 28/3/2023 下午7:17
 */
public class Q1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int num = Integer.parseInt(s);
        if (num % 3 == 0 && num % 5 == 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
