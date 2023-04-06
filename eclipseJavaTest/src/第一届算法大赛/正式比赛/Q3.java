package 第一届算法大赛.正式比赛;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cxb
 * @ClassName Q3
 * @date 2/4/2023 上午9:20
 */
public class Q3 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        String[] nums = null;
        try {
            N = Integer.parseInt(reader.readLine());
            nums = reader.readLine().split(" ");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int ans = 0;
        for (int i = 0;i < N - 1;i++){
            for (int j = i + 1;j < N;j++){
                if (Integer.parseInt(nums[i]) > Integer.parseInt(nums[j])){
                    ans++;
                }
            }

        }
        System.out.println(ans);
    }
}
