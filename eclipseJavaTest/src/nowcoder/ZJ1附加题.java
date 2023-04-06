package nowcoder;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int total = Integer.parseInt(in.nextLine());
        String[] data = in.nextLine().split(" ");
        int[] map = new int[total + 1];
        for (int i = 1;i < total + 1;i++){
            map[i] = 1;
        }
        int position = 1;
        int aws = 0;
        while (true){
            if (position == total){
                System.out.println(aws);
                return;
            }
            if (map[position] % 2 != 0){
                map[position] ++;
                position = Integer.parseInt(data[position - 1]);
                aws = Math.floorMod(aws + 1,1000000007);
            } else {
                map[position] ++;
                position ++;
                aws = Math.floorMod(aws + 1,1000000007);
            }
        }
    }
}
