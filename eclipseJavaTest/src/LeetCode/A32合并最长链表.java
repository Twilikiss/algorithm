package LeetCode;

import java.util.*;

public class A32合并最长链表 {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> total = new PriorityQueue<>();
        for (ListNode list : lists) {
            ListNode index = list;
            while (index != null){
                total.add(index.val);
                index = index.next;
            }
        }
        if (total.poll() == null){
            return null;
        }
        ListNode asw = new ListNode(total.poll());
        ListNode index = asw;
        while (total.peek() != null){
            ListNode temp = new ListNode(total.poll());
            index.next = temp;
            index = temp;
        }
        return asw;
    }
}
