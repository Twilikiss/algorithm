package 第一届算法大赛.热身赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author cxb
 * @ClassName Q10
 * @date 28/3/2023 下午8:48
 */
public class Q10 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] older = new String[100];
        ArrayList<String> young = new ArrayList<>();
        int total = 0;
        try {
             total = Integer.parseInt(reader.readLine());
             for (int i = 0; i < total; i++){
                 String[] s = reader.readLine().split(" ");
                 int old = Integer.parseInt(s[1]);
                 if (old < 60){
                     young.add(s[0]);
                 } else {
                     if (older[old - 60] == null){
                         older[old - 60] = s[0] + " ";
                     } else {
                         older[old - 60] += s[0] + " ";
                     }

                 }
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = older.length - 1;i >= 0;i--){
            String s = older[i];
            if (s == null){
                continue;
            }
            if (s.length() == 4){
                System.out.println(s);
            } else {
                String[] temp = s.split(" ");
                for (String out : temp){
                    System.out.println(out);
                }
            }
        }
        for (int i = 0; i < young.size();i++){
            System.out.println(young.get(i));
        }
    }
}
