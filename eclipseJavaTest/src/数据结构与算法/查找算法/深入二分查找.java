package 数据结构与算法.查找算法;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回大于目标元素的第一个元素的值！
 */
public class 深入二分查找 {
    public static void main(String[] args) {
        List<Integer> date = new ArrayList<>();
        date.add(1);
        date.add(2);
        date.add(3);
        date.add(4);
        date.add(5);
        System.out.println(binarySearch01(date, 5));
    }

    public static int binarySearch01(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return list.get(left);
    }
}
