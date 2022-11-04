package 数据结构与算法.十大算法;

import java.util.*;

/**
 * 贪心算法的典例——集合覆盖
 */
public class 贪心算法 {
    public static void main(String[] args) {
        //创建电台的map
        Map<String, HashSet<String>> items = new HashMap<>();
        HashSet<String> hashSet01 = new HashSet<>();
        hashSet01.add("北京");
        hashSet01.add("上海");
        hashSet01.add("天津");

        HashSet<String> hashSet02 = new HashSet<>();
        hashSet02.add("广州");
        hashSet02.add("北京");
        hashSet02.add("深圳");

        HashSet<String> hashSet03 = new HashSet<>();
        hashSet03.add("成都");
        hashSet03.add("上海");
        hashSet03.add("深圳");

        HashSet<String> hashSet04 = new HashSet<>();
        hashSet04.add("上海");
        hashSet04.add("天津");

        HashSet<String> hashSet05 = new HashSet<>();
        hashSet05.add("杭州");
        hashSet05.add("大连");

        items.put("k1",hashSet01);
        items.put("k2",hashSet02);
        items.put("k3",hashSet03);
        items.put("k4",hashSet04);
        items.put("k5",hashSet05);

        Set<String> AllAreas = new HashSet<>();
        AllAreas.addAll(hashSet01);
        AllAreas.addAll(hashSet02);
        AllAreas.addAll(hashSet03);
        AllAreas.addAll(hashSet04);
        AllAreas.addAll(hashSet05);

        //存放选择的电台集合
        ArrayList<String> select = new ArrayList<>();

    }
}
