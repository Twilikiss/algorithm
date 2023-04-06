package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q4
 * @date 2/4/2023 上午9:31
 */
public class Q4 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = null;
        try {
            data = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int length = data.length();
        long N = Long.parseLong(data);

        if (length < 4){
            System.out.println(0);
        }

    }
}
