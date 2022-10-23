package LeetCode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class 两数相加答案 {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(4);
		ListNode h3 = new ListNode(3);
		
		h1.next = h2;
	    h2.next = h3;
	    h3.next = null;
	     
	    ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(6);
		ListNode l3 = new ListNode(4);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
        ListNode o1 = addTwoNumbers(h1, l1);
		
		System.out.println(o1.val);
		
		System.out.println(o1.next.val);
		
		System.out.println(o1.next.next.val);
	}
	    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	         ListNode head = null;
	         ListNode end = null;
	         int carry = 0;
	         while(l1 != null || l2 != null){
	             int n1 = l1 != null ? l1.val : 0;
	             int n2 = l2 != null ? l2.val : 0;
	             int total = n1 + n2 + carry;

	             if(head == null){
	                 head = end = new ListNode(total % 10);
	             } else {
	                 end.next = new ListNode(total % 10);
	                 end = end.next;
	             }
	             carry = total / 10;

	             if(l1 != null){
	                 l1 = l1.next;
	             }
	             if(l2 != null){
	                 l2 = l2.next;
	             }
	         }

	        //判断进位情况，在输出的链表的最后面加上进位的值
	         if(carry > 0) {
	             end.next = new ListNode(carry);
	         }
			 
			 return head;	 
			 
	    }
	}


