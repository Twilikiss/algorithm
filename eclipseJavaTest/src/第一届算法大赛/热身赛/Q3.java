package 第一届算法大赛.热身赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q3
 * @date 28/3/2023 下午8:36
 */
public class Q3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        StringBuffer stringBuffer = new StringBuffer(s);
        StringBuffer reverse = stringBuffer.reverse();
        System.out.println(reverse.toString());
    }
}
