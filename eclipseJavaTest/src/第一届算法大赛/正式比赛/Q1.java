package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author cxb
 * @ClassName Q1
 * @date 2/4/2023 上午9:01
 */
public class Q1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int c = 0;
        int b = 0;
        Map<Integer, PriorityQueue<Integer>> map = null;
        String[] bg = new String[0];
        String[] type = new String[0];
        try {
            String[] s = reader.readLine().split(" ");
            c = Integer.parseInt(s[2]);
            b = Integer.parseInt(s[1]);
            map = new HashMap<>();
            bg = reader.readLine().split(" ");
            type = reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    }
}
