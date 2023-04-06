package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author cxb
 * @ClassName Q7_
 * @date 2/4/2023 下午1:29
 */
public class Q7_ {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String data = "";
        try {
            data = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int size = data.length();
        int num = Integer.parseInt(data);
        String[] map = new String[]{"2","6","8","9"};
        ArrayList<String> cache = new ArrayList<>();
    }
}
