package 数据结构与算法练习.LinkedList;


import java.util.Stack;

/**
 * 本代码是初代单链表的升级版
 * 能够判断顺序，按照顺序添加，顺序错误则不能够添加
 * @author mlp52
 *
 */
public class SingleLinkedListPlu {
	public static void main(String[] args) {
		HeroNode heroNode1 = new HeroNode(1, "陈晓彬", "小兵");
		HeroNode heroNode2 = new HeroNode(2, "张春洋", "sb");
		HeroNode heroNode3 = new HeroNode(3, "陈中伟", "阿伟");
		HeroNode heroNode4 = new HeroNode(4, "钟耀峰", "钟耀b");

		// 创建一个单向链表
		SingleLinkedPlus singleLinkedPlus = new SingleLinkedPlus();
		
		// 添加数据
		//
		singleLinkedPlus.addByOrder(heroNode1);
		singleLinkedPlus.addByOrder(heroNode3);
		singleLinkedPlus.addByOrder(heroNode2);
		singleLinkedPlus.addByOrder(heroNode4);
		singleLinkedPlus.updateData(new HeroNode(2,"cxb","陈晓彬"));

		System.out.println("******************删除节点1*********************");
		
		//删除节点
		singleLinkedPlus.deleteData(1);

		singleLinkedPlus.getLinkedList();
		
		System.out.println("当前的链表的总数是 " + singleLinkedPlus.getHeroTotal());
		
		System.out.println("取出倒数第1个节点信息为" + singleLinkedPlus.findNodeBackK(1));
		
		System.out.println("**********************以下是反转的单链表*****************************");
		
		singleLinkedPlus.turnAround();
		
		singleLinkedPlus.getLinkedList();
		
		System.out.println("*********************再次反转回来******************************");
		
		singleLinkedPlus.turnAroundByAnswer();
		
		singleLinkedPlus.getLinkedList();
		
		System.out.println("*******************以下是反向输出链表信息，但不影响原链表***************************");
		
		singleLinkedPlus.showLinkedListReversedly();
	}
	
	
}

class SingleLinkedPlus {
	// 先初始化一个头节点，头节点不要动，不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");
	
	/**
	 * 以下是面试题的相关解法
	 */
	/**
	 * 获取节点的个数
	 */
	public int getHeroTotal() {
		HeroNode temp = head;
		
		int HeroTotal = 0;
	
		while(temp.getNext() != null) {
			temp = temp.getNext();
			HeroTotal++;
		}
		
		return HeroTotal;
	}
	
	/**
	 * 查找单链表倒数第k个节点（新浪面试题）
	 */
	public HeroNode findNodeBackK(int k) {
		int  total = getHeroTotal() - k + 1;
		
		int index = 1;
		
		HeroNode tempHeroNode = head.getNext();
		
		boolean flag = true;
		
		if (tempHeroNode == null) {
			System.out.println("当前链表为空！");
			return null;
		}
		
		if (k < 1) {
			System.out.println("输入的数字错误！");
			return null;
		}
		
		while(flag) {
			if (index == total) {
				break;
			}
			
			index++;
			
			if (index > total) {
				flag = false;
				break;
			} else {
				tempHeroNode = tempHeroNode.getNext();
			}
			
		}
		
		
			if (flag == false) {
				System.out.println("无法找到对应节点！");
				return null;
			} else {
				return tempHeroNode;
			}	
	}
	
	
	
	/**
	 * 腾讯面试题：反转链表中节点
	 * 方法一：使用两层for循环来反向遍历链表，逆序取出链表数据放进数组中，再顺序取出节点数据设置上下关系
	 * 拓展想法：①将头节点设置到链表的结尾，尝试实现反向遍历
	 *、               ②设置另外一个头节点，将新链表的next指向原链表的对应节点
	 */
     public void turnAround() {
    	 
    	
    	 int total = getHeroTotal();
    	 
    	 HeroNode[] argsHeroNodes = new HeroNode[total];
    	
    	 for(int i = 0;i < total;i++) { 
    		 HeroNode temp = head;
    		 for(int j = 0;j < total - i;j ++) {
    			 temp = temp.getNext();
    		 }
    		 argsHeroNodes[i] = temp;
    	 }
    	 head.setNext(argsHeroNodes[0]);
    	 for(int i = 0;i < argsHeroNodes.length;i++) {
    		 if (i == argsHeroNodes.length - 1) {
				argsHeroNodes[i].setNext(null);
			} else {
				argsHeroNodes[i].setNext(argsHeroNodes[i + 1]);
			}
    	 }
     }
     
     //标准答案：
     public void turnAroundByAnswer() {
    	 
    	 //判断当前的链表是否为空或者链表内的是否只有一个节点
    	 if (head.getNext() == null ||head.getNext().getNext() == null) {
			return;
		}
    	 
    	 HeroNode nextHeroNode = null;
    	 HeroNode curHeroNode = head.getNext();
    	 //设置一个新的节点
    	 HeroNode tempHeroNode = new HeroNode(0,"","");
    	 
    	 while(curHeroNode != null) {
    		 nextHeroNode = curHeroNode.getNext();
    		 curHeroNode.setNext(tempHeroNode.getNext());
    		 tempHeroNode.setNext(curHeroNode);
    		 curHeroNode = nextHeroNode;
    	 }
    	 head.setNext(tempHeroNode.getNext());
    	 
     }
     

   /**
      * 百度面试题：从尾到头打印链表
      * 思路分析：
      * 方式1.先将单链表反转再遍历（但是会破坏原来的链表，不建议）
      * 方式2.可以利用栈这个数据结构，将各个节点压入栈中，然后利用栈结构的先进后出的特点，就实现了逆序打印链表的效果
      *请于api文档查询Stack的类的使用，关键方法：add()添加,pop()按照栈的特点删除并返回。
   */
    public void showLinkedListReversedly() {
    	HeroNode tempHeroNode = head;
    	
    	if (head.getNext() == null) {
			System.out.println("当前链表为空！");
			return;
		}
    	//创建栈，并压入栈中
    	Stack<HeroNode> stack = new Stack<>();
    	
    	while (tempHeroNode.getNext() != null) {
    		stack.push(tempHeroNode.getNext());
    		tempHeroNode = tempHeroNode.getNext();
		}
    	
    	while(stack.size() != 0) {
    		System.out.println(stack.pop());
    	}
    	
    }
     
     /**
      * 合并两个有序单链表，合并后的单链表依然有序（课后题）
      * 想法：
      */
     public SingleLinkedPlus getTogetHeroNodeFromTwoHeroNode(SingleLinkedPlus hero01,SingleLinkedPlus hero02) {
    	 HeroNode temHeroNode01 = hero01.head;
    	 HeroNode temHeroNode02 = hero02.head;
    	 
    	 if (temHeroNode01.getNext() == null && temHeroNode02.getNext() != null) {
			System.out.println("链表1为空！");
			return hero02;
		} else if (temHeroNode02.getNext() == null && temHeroNode01.getNext() != null) {
			System.out.println("链表2为空！");
			return hero01;
		} else if (temHeroNode01.getNext() == null && temHeroNode02.getNext() == null) {
			System.out.println("当前两个链表为空！");
			return null;
		}
    	 return null;
    	 
     }
     
	/**
	 * 根据编号进行删除操作
	 * 传入对应的HeroNode的No值来实现删除
	 */
	public void deleteData(int No) {
		//判断节点是否为空
		if (head.getNext() == null) {
			System.out.println("当前链表为空！你删nm呢");
			return;
		}
		//head不能动，要借助辅助变量temp来遍历当前的链表，通过它找到待删除的节点的前一个节点
		HeroNode temp = head;
		boolean flag = true;
		
		while(flag) {
			//遍历到最后一个
			if (temp.getNext() == null) {
				
				break;
			}
			
			if (temp.getNext().getNo() == No) {
				flag = false;
				break;
			}
			
			temp = temp.getNext();//如不满足上面的两个条件，则temp则递增
		}
		
		if (flag == false) {
			//进行删除操作
			HeroNode nextHeroNode = temp.getNext().getNext();
			temp.setNext(nextHeroNode);
		} else {
			System.out.println("无法找到要删除的第[" + No + "]元素信息！");
		}
	
		
	}
	
	
	/**
	 * 根据编号进行修改修改节点信息
	 * 通过传入的HeroNode来实现修改信息
	 */

	public void updateData(HeroNode heroNode) {
		if (head.getNext() == null) {
			System.out.println("链表为空！");
			return;
		}
		//找到修改的节点
		//先定义一个辅助变量
		HeroNode temp = head.getNext();
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
		}
		
		
	}
	
	/**
	 * 本方法是升级版的链表添加
	 */
	public void addByOrder(HeroNode heroNode) {
		//因为头节点不能动（遍历要从头节点开始），要创建一个辅助指针（temp），temp是位于添加位置的前一个节点，否则插入不了
		//这里的temp是对象引用
		HeroNode temp = head;
		
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
				//插入到链表中
				heroNode.setNext(temp.getNext());
				temp.setNext(heroNode);
			}
		
	}
	
	/**
	 *  遍历链表
	 */
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
/**
 * 关于链表每一个单元的bean
 * @author mlp52
 *
 */
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
