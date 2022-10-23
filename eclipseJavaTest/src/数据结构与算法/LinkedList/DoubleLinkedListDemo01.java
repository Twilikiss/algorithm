package 数据结构与算法.LinkedList;
/**
 * 双向链表的代码实现
 * @author mlp520
 *
 */
public class DoubleLinkedListDemo01 {
	public static void main(String[] args) {
		DoubleHeroNode heroNode1 = new DoubleHeroNode(1, "陈晓彬", "小兵");
		DoubleHeroNode heroNode2 = new DoubleHeroNode(2, "张春洋", "sb");
		DoubleHeroNode heroNode3 = new DoubleHeroNode(3, "陈中伟", "阿伟");
		DoubleHeroNode heroNode4 = new DoubleHeroNode(4, "钟耀峰", "钟耀b");

		// 创建一个单向链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		
		// 添加数据
		doubleLinkedList.addByOrder(heroNode1);
		doubleLinkedList.addByOrder(heroNode3);
		doubleLinkedList.addByOrder(heroNode2);
		doubleLinkedList.addByOrder(heroNode4);
		
		doubleLinkedList.getLinkedList();
		
		System.out.println("******************修改节点2*********************");
		
		doubleLinkedList.updateData(new HeroNode(2,"cxb","陈晓彬"));
		
		doubleLinkedList.getLinkedList();

		System.out.println("******************删除节点1*********************");
		
		//删除节点
		doubleLinkedList.deleteData(1);

		doubleLinkedList.getLinkedList();
		
	}
	
	
}

class DoubleLinkedList{
	//初始化头节点，保持头节点不动
	private DoubleHeroNode head = new DoubleHeroNode(0,"","");
	
	//返回头节点
	public DoubleHeroNode getHead() {
		return head;
	}
	
	/**
	 * 本方法是添加一个节点到双向链表
	 * @author mlp520
	 */
	public void addByOrder(DoubleHeroNode heroNode) {
		//因为头节点不能动（遍历要从头节点开始），要创建一个辅助指针（temp），temp是位于添加位置的前一个节点，否则插入不了
		//这里的temp是对象引用
		DoubleHeroNode temp = head;
		
		boolean flag = false;//标识
		
		//循环遍历单链表，查找合适的插入点
		while(true) {
			if (temp.getNext() == null) {//说明temp当前处于了链表的最后一个
				break;
			}
			//找到要插入的位置
			if (temp.getNext().getNo() > heroNode.getNo()) {
				break;
			} else if (temp.getNext().getNo() == heroNode.getNo()) {
				//编号存在，退出循环
				flag = true;
				break;
			} 
				temp = temp.getNext();
			
		}
			if (flag) {
				System.out.printf("准备插入的数据已存在，编号为%d，不能加入!\n",heroNode.getNo());
			}else {
				//形成一个双向链表
				heroNode.setNext(temp.getNext());
				
				//当temp是头节点或者是最后一个时
				if (temp.getNext() != null) {
					temp.getNext().setPre(heroNode);
				} 
				if (temp.getNext() == null && temp.getPre() != null) {
					head.getNext().setPre(head);
				}
				
				temp.setNext(heroNode);
				heroNode.setPre(temp);
				
			}
		}
	
	/**
	 * 本方法是修改一个节点信息
	 * 根据编号进行修改修改节点信息
	 * 通过传入的HeroNode来实现修改信息
	 * @author mlp520
	 */
	public void updateData(HeroNode heroNode) {
		if (head.getNext() == null) {
			System.out.println("链表为空！");
			return;
		}
		//找到修改的节点
		//先定义一个辅助变量
		DoubleHeroNode temp = head.getNext();
		boolean flag = true;//表示是否找到
		
		while(flag){
			if (temp == null) {
				break;//已经遍历完链表了
			}
			if (temp.getNo() == heroNode.getNo()) {
				//找到
				flag = false;
				break;
			}
			temp = temp.getNext();
		}
		
		if(flag == false) {
			//修改该节点的数据
		temp.setName(heroNode.getName());
		temp.setNickName(heroNode.getNickName());
		} else {
			System.out.println("没有找到该节点信息！");
		}
	}
	
	
	/**
	  * 根据编号进行删除操作
	 * 传入对应的HeroNode的No值来实现删除
	 * 相较于单向链表的删除，双向链表的删除是可以直接找到该节点进行删除操作
	 * @author mlp520
	 */
	public void deleteData(int No) {
		//判断节点是否为空
		if (head.getNext() == null) {
			System.out.println("当前链表为空！你删nm呢");
			return;
		}
		//head不能动，要借助辅助变量temp来遍历当前的链表，通过它找到待删除的节点的前一个节点
		DoubleHeroNode temp = head;
		boolean flag = true;
		
		while(flag) {
			//遍历到最后一个
			if (temp.getNext() == null) {
				break;
			}
			
			if (temp.getNo() == No) {
				flag = false;
				break;
			}
			
			temp = temp.getNext();//如不满足上面的两个条件，则temp则递增
		}
		
		if (flag == false) {
			//进行删除操作，两步：next部分和pre部分
			temp.getPre().setNext(temp.getNext());
			if(temp.getNext() != null) {
				temp.getNext().setPre(temp.getPre());
			}
			
		} else {
			System.out.println("无法找到要删除的第[" + No + "]元素信息！");
		}
	}
	/**
	 *  遍历链表
	 */
	public void getLinkedList() {
		// 1、因为head不能动，就需要创建一个temp来辅助遍历
		DoubleHeroNode temp = head;

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


/**
  * 关于链表每一个单元的bean
 * @author mlp520
 *
 */
class DoubleHeroNode {
	private int no;
	private String name;
	private String nickName;
	private DoubleHeroNode pre;// 指向前一个节点，默认为null
	private DoubleHeroNode next;// 指向下一个节点，默认为null
	
	public DoubleHeroNode() {
		
	}

	public DoubleHeroNode(int no, String name, String nickName) {
		super();
		this.no = no;
		this.name = name;
		this.nickName = nickName;
	}

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

	public DoubleHeroNode getPre() {
		return pre;
	}

	public void setPre(DoubleHeroNode pre) {
		this.pre = pre;
	}

	public DoubleHeroNode getNext() {
		return next;
	}

	public void setNext(DoubleHeroNode next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "DoubleHeroNode [no=" + no + ", name=" + name + ", nickName=" + nickName + "]";
	}
	
	
}