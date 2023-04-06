package luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> date = new ArrayList<>();
        while (true){
            String index = bf.readLine();
            if ("0".equals(index)){
                break;
            }
            if (date.contains(index)){
                continue;
            }
            date.add(index);
        }
        String ans = "";
        for (int i = 0;i < date.size();i++){
            ans += date.get(i);
        }
        System.out.println(ans);
    }
}
