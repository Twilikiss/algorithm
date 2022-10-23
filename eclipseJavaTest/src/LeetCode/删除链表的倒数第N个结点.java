package LeetCode;
/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]
提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
。
 * @author mlp52
 *
 */
  // Definition for singly-linked list.

public class 删除链表的倒数第N个结点 {
	public static void main(String[] args) {
		ListNode listNode01 = new ListNode();
//		ListNode listNode02 = new ListNode();
//		ListNode listNode03 = new ListNode();
//		ListNode listNode04 = new ListNode();
//		ListNode listNode05 = new ListNode();
		listNode01.next = null;
//		listNode02.next = listNode03;
//		listNode03.next = listNode04;
//		listNode04.next = listNode05;
//		listNode05.next = null;
		listNode01.val = 1;
//		listNode02.val = 2;
//		listNode03.val = 3;
//		listNode04.val = 4;
//		listNode05.val = 5;
		removeNthFromEnd(listNode01, 1);
		System.out.println();
	}
	
	//方法
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		int total = 1;
		ListNode indexListNode = head;
		ListNode tempListNode = head;
		while(true) {
			if (tempListNode.next == null) {
				break;
			}
			tempListNode = tempListNode.next;
			total++;
		}
		//
		for(int i = 1;i < total - n;i++) {
			indexListNode = indexListNode.next;
		}
		if (total == 1) {
			head = null;
			return head;
		} else if (total == 2 && n == 1 ) {
			head.next = null;
			return head;
		} else if (total == 2 && n == 2) {
			head.val = head.next.val;
			return head;
		} else {
			indexListNode.next = indexListNode.next.next;
			return indexListNode;
		}
		
    }
}
