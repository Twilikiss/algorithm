package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.core.Is;

/**
 * 给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。
返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。

示例 1：

输入: head = [0,1,2,3], nums = [0,1,3]
输出: 2
解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。

示例 2：

输入: head = [0,1,2,3,4], nums = [0,3,1,4]
输出: 2
解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 
提示：
链表中节点数为n
1 <= n <= 104
0 <= Node.val < n
Node.val 中所有值 不同
1 <= nums.length <= n
0 <= nums[i] < n
nums 中所有值 不同
 * @author mlp52
 *
 */
public class A817链表组件 {
	public static void main(String[] args) {
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3, l4);
		ListNode l2 = new ListNode(2,l3);
		ListNode l1 = new ListNode(1, l2);
		ListNode head = new ListNode(0, l1);
		int i = numComponents(head, new int[] {3, 0, 2});
		System.out.println(i);
	}

	public static int numComponents(ListNode head, int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int count = 0;
		boolean isFind = false;
		while (head != null) {
			if (set.contains(head.val)) {
				isFind = true;
				if (head.next == null) {
					count++;
				}
			} else {
				if (isFind) {
					count++;
					isFind = false;
				}
			}
			head = head.next;
		}
		return count;
	}
	
//	public static int numComponents(ListNode head, int[] nums) {
//		ListNode index = head;
//		List<Integer> linkList = new ArrayList<>();
//		while(true) {
//			linkList.add(index.val);
//			if (index.next == null) {
//				break;
//			}
//			index = index.next;
//		}
//		ArrayList<Integer> numsList = turnToArray(nums);
//		Collections.sort(numsList);
//		Collections.sort(linkList);
//		int n1 = 0;
//		for (int i = 0; i < linkList.size(); i++) {
//			if (linkList.get(i) == numsList.get(0)) {
//				n1 = i;
//				break;
//			}
//			if (i == linkList.size() - 1 && linkList.get(linkList.size() - 1) != numsList.get(0)) {
//				return 0;
//			}
//		}
//		int n2 = 0;
//		int count = 0;
//		boolean isIN = false;
//		for(int i = n1;i < linkList.size();i++) {
//			if (n2 < numsList.size() && linkList.get(i) == numsList.get(n2)) {
//				isIN = true;
//				n2++;
//				if (i == linkList.size() - 1) {
//					count++;
//				}
//				continue;
//			}
//			if (isIN) {
//				count++;
//				isIN = false;
//			}
//		}
//		return count;
//		
//	}
//	public static ArrayList<Integer> turnToArray(int[] arr){
//		ArrayList<Integer> answerArrayList = new ArrayList<>();
//		for(int i = 0;i < arr.length;i++) {
//			answerArrayList.add(arr[i]);
//		}
//		return answerArrayList;
//	}
}

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
