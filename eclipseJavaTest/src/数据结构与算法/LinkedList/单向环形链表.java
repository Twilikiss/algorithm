package 数据结构与算法.LinkedList;

/**
 * 此处将探讨单向环形链表的典例——约瑟夫问题
 * 
 * @author mlp52
 *
 */
public class 单向环形链表 {
	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();

		circleSingleLinkedList.addNode(12);

		circleSingleLinkedList.showList();
		
		System.out.println("************************************************************************");
		
		circleSingleLinkedList.countBoy(1, 2, 12);
		
		
	}

}

class CircleSingleLinkedList {
	// 创建初节点first
	private Node firstNode = new Node(-1);

	/**
	 * 创建环形的单向链表
	 */
	public void addNode(int nums) {
		if (nums < 0) {
			System.out.println("输入的数据非法！请重新输入");
			return;
		}
		// 设置辅助指针
		Node tempNode = new Node();

		for (int i = 1; i <= nums; i++) {
			Node inNode = new Node(i);
			if (i == 1) {
				firstNode = inNode;
				firstNode.setNext(firstNode);
				tempNode = firstNode;
			} else {
				tempNode.setNext(inNode);
				inNode.setNext(firstNode);
				tempNode = inNode;
			}
		}
	}

	/**
	 * 遍历当前的单向环形链表
	 */
	public void showList() {
		if (firstNode.getNo() == -1) {
			System.out.println("当前无元素处于单向环形链表内");
			return;
		}

		Node temNode = firstNode;
		while (true) {

			System.out.println("当前遍历到的链表编号为" + temNode.getNo());

			if (temNode.getNext() == firstNode) {
				break;
			}

			temNode = temNode.getNext();
		}

	}
	
	/**
	 * 解决约瑟夫问题
	 * @param start 从第start个开始数
	 * @param countNum 报到第countNum就出圈
	 * @param total 总数
	 */
	public void countBoy(int start,int countNum,int total) {
		if(firstNode.getNo() == -1 || start <= 0 || start > total || total < 0) {
			System.out.println("输入的参数有误！");
			return;
		}
		//辅助指针
		Node helperNode = firstNode;
		Node indexNode = firstNode;
		//移动辅助指针到环形链表的最后一位
		while(true) {
			if (helperNode.getNext() == firstNode) {
				break;
			}
			helperNode = helperNode.getNext();
		}
		//将指针都移动到指定开始的位置(要注意，移动到k这个位置，要进行k - 1次操作)
		for(int i = 0;i < start - 1;i++) {
			helperNode = helperNode.getNext();
			indexNode = indexNode.getNext();
		}
		//开始模拟小孩报数的操作，注意这个操作是循环操作
		while(true) {
			if (indexNode.getNext() == indexNode) {
				System.out.println(indexNode.getNo());
				break;
			}
			for(int i = 0;i < start;i++) {
				indexNode = indexNode.getNext();
				helperNode = helperNode.getNext();
				}
			System.out.println(indexNode.getNo());
			//输出完毕后，要将先将指针移动到新链表的对应的位置，然后将对应的"出圈的"节点拿离链表
			indexNode = indexNode.getNext();
			helperNode.setNext(indexNode);
		}
		System.out.println("最后留在圈中的节点为  ：" + indexNode.getNo());
	}
}

class Node {
	private int no;
	private Node next;// 指向下一个节点

	public Node() {

	}

	public Node(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", next=" + next + "]";
	}

}
