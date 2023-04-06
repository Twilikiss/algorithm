package luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int date = Integer.parseInt(bf.readLine());
        int ans = 0;
        for (int i = 0; i < date; i++) {
            int minutes = i % 60;
            String m = "";
            if (minutes < 10) {
                m = "0" + minutes;
            } else {
                m = String.valueOf(minutes);
            }
            int hours = i / 60;
            String total = hours + m;
            int cha = total.charAt(total.length() - 2) - total.charAt(total.length() - 1);
            boolean isTure = true;
            for (int j = 1; j < total.length(); j++) {
                int value = total.charAt(j - 1) - total.charAt(j);
                if (value != cha) {
                    isTure = false;
                    break;
                }
            }
            if (isTure) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
