package 第一届算法大赛.正式比赛;

import java.util.*;

/**
 * @author cxb
 * @ClassName Test
 * @date 2/4/2023 上午9:38
 */
public class Test {
    public static void main(String[] args) {
        ArrayDeque<String> cache = new ArrayDeque<>();
        cache.add("1");
        cache.add("2");
        String s = cache.toString();
        System.out.println(s.substring(1, s.length() - 1).split(","));
        System.out.println();
        ArrayList<Integer> test = new ArrayList<>();
        System.out.println();
    }
}
