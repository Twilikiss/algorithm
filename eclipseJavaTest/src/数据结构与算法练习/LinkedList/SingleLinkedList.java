package 数据结构与算法练习.LinkedList;



/**
   * 关于单链表的思路及其代码实现
   * 当不考虑编号顺序时：（即输出的顺序是取决于添加顺序的）
 * 
 * @author mlp52
 *
 */
public class SingleLinkedList {
	public static void main(String[] args) {
		HeroNode heroNode1 = new HeroNode(1, "陈晓彬", "小兵");
		HeroNode heroNode2 = new HeroNode(2, "张春洋", "sb");
		HeroNode heroNode3 = new HeroNode(3, "陈中伟", "阿伟");
		HeroNode heroNode4 = new HeroNode(4, "钟耀峰", "钟耀b");

		// 创建一个单向链表
		SingleLinked singleLinked = new SingleLinked();

		// 添加数据
		singleLinked.add(heroNode1);
		singleLinked.add(heroNode2);
		singleLinked.add(heroNode3);
		singleLinked.add(heroNode4);

		singleLinked.getLinkedList();

	}
}


class SingleLinked {
	// 先初始化一个头节点，头节点不要动，不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");

	// 添加节点到单向链表
	// 当不考虑编号顺序时：（即输出的顺序是取决于添加顺序的）
	// 1.找到当前链表的最后一个
	// 2.然后将该节点的的next指向新添加的节点
	public void add(HeroNode heroNode) {
		// 1、因为head不能动，就需要创建一个temp来辅助遍历
		HeroNode temp = head;

		while (true) {
			// 找到链表最后
			if (temp.getNext() == null) {
				break;
			}

			// 如果没有找到最后，将temp后移
			temp = temp.getNext();
		}
		// 当退出循环的时候，表示temp指向最后一个
		temp.setNext(heroNode);
	}

	// 遍历链表
	public void getLinkedList() {
		// 1、因为head不能动，就需要创建一个temp来辅助遍历
		HeroNode temp = head;

		// 找到链表最后
		if (temp.getNext() == null) {
			System.out.println("当前的链表为空");
		}

		// 如果链表不为空，则将temp移动到下一位
		temp = temp.getNext();

		while (true) {
			// 通过判断其是否为null来判断是否遍历到最后一行
			if (temp == null) {
				break;
			}
			// 输出节点信息
			System.out.println(temp);
			// 将节点往后移
			temp = temp.getNext();
		}

	}
}

	class HeroNode {
		private int no;
		private String name;
		private String nickName;
		private HeroNode next;// 指向下一个节点

		public HeroNode() {

		}

		public HeroNode(int heroNo, String name, String nickName) {
			this.no = heroNo;
			this.name = name;
			this.nickName = nickName;
		}
		// 重写显示方法，重写一下toString方法

		public int getNo() {
			return no;
		}

		public void setNo(int no) {
			this.no = no;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getNickName() {
			return nickName;
		}

		public void setNickName(String nickName) {
			this.nickName = nickName;
		}

		public HeroNode getNext() {
			return next;
		}

		public void setNext(HeroNode next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "HeroNode [no=" + no + ", " + "name=" + name + ", " + "nickName=" + nickName + "]";
		}
	}

