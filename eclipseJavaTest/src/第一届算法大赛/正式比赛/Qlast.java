package 第一届算法大赛.正式比赛;

import java.io.*;
import java.util.Arrays;

/**
 * @author cxb
 * @ClassName Qlast
 * @date 2/4/2023 上午10:11
 */
public class Qlast {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = new String[0];
        String[] nums = new String[0];
        try {
            NM = reader.readLine().split(" ");
            nums = reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int[] data = new int[nums.length];
        for (int i = 0;i < nums.length;i++){
            data[i] = Integer.parseInt(nums[i]);
        }
        Arrays.sort(data);
        int M = Integer.parseInt(NM[1]);
        int total = nums.length - M;
        long ans = 0;
        for (int i = 0;i < total;i++){
            ans += data[i + 1] - data[i];
        }
        System.out.println(ans);
    }
}
