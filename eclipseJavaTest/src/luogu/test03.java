package luogu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class test03 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        String[] prices = bf.readLine().split(" ");
        int money = Integer.parseInt(bf.readLine());
        Arrays.sort(prices);
        for (int i = prices.length - 1;i >= 0;i++){
            if (money >= Integer.parseInt(prices[i])){
                
            }
        }
    }
}
