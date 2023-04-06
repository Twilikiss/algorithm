package PAT;

import java.io.*;
import java.util.HashMap;

class Main5 {
    public static void main(String[] args) throws IOException {
        //部分用例超时！！！！
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(bf.readLine());
//        Map<String, String[]> date = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            String s = bf.readLine();
//            String[] s1 = s.split(" ");
//            date.put(s1[1],new String[]{s1[0],s1[2]});
//        }
//        int m = Integer.parseInt(bf.readLine());
//        String[] s2 = bf.readLine().split(" ");
//        for (int i = 0; i < m; i++) {
//            String[] ans = date.get(s2[i]);
//            writer.write(ans[0] + " " + ans[1] + "\n");
//            writer.flush();
//        }
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        HashMap<String, String[]> date = new HashMap<>();
        while (n > 0) {
            String s = bf.readLine();
            String[] s1 = s.split(" ");
            date.put(s1[1], s1);
            n--;
        }
        int m = Integer.parseInt(bf.readLine());
        String index = bf.readLine();
        bf.close();
        String[] s = index.split(" ");
        for (int i = 0; i < m; i++) {
            String[] strings = date.get(s[i]);
            System.out.println(strings[0] + " " + strings[2]);
        }
    }
}
