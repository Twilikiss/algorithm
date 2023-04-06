package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName 小强
 * @date 2/4/2023 下午1:53
 */
public class 小强 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = "";
        try {
            data = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int ans = Integer.parseInt(data);
    }
}
