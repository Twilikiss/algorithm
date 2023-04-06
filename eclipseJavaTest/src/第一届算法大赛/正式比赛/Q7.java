package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author cxb
 * @ClassName Q7
 * @date 2/4/2023 上午10:02
 */
public class Q7 {
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
        getPart(map,cache,size,num);
        System.out.println(ans);
    }
    static int ans = 0;
    public static void getPart(String[] map, ArrayList<String> cache, int size, int num){
        if (cache.size() == size){
            String temp = "";
            for (int i = 0;i < size;i++){
                temp += cache.get(i);
            }
            if (Integer.parseInt(temp) <= num && cache.contains("2") && cache.contains("6") && cache.contains("8") && cache.contains("9")){
                ans ++;
            }
            return;
        }
        for (int i = 0;i < map.length;i++){
            cache.add(map[i]);
            getPart(map,cache,size,num);
            cache.remove(cache.size() - 1);
        }
    }
}
