package 数据结构与算法.树;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 模拟二叉树的结构学习二叉树的相关操作
 * @author mlp52
 *
 */
public class BinaryTree {
	public static void main(String[] args) throws IOException {
		BrinaryTree brinaryTree = new BrinaryTree();
//		HeroNode root = new HeroNode(1, "爱莉希雅");
//		HeroNode heroNode02 = new HeroNode(2, "凯文");
//		HeroNode heroNode03 = new HeroNode(3, "苏");
//		HeroNode heroNode04 = new HeroNode(4, "樱");
//		HeroNode heroNode05 = new HeroNode(5, "华");
//		HeroNode heroNode06 = new HeroNode(6, "梅比乌斯");
//		HeroNode heroNode07 = new HeroNode(7, "帕朵·菲莉斯");
//
//		//先手动创建二叉树，后面将通过递归来创建二叉树
//		root.setLeft(heroNode02);
//		heroNode02.setLeft(heroNode03);
//		heroNode02.setRight(heroNode07);
//		root.setRight(heroNode04);
//		heroNode04.setRight(heroNode05);
//		heroNode04.setLeft(heroNode06);

		HeroNode A = new HeroNode(1,"A");
		HeroNode B = new HeroNode(2,"B");
		HeroNode C = new HeroNode(3,"C");
		HeroNode D = new HeroNode(4,"D");
		HeroNode E = new HeroNode(5,"E");
		HeroNode F = new HeroNode(6,"F");
		HeroNode G = new HeroNode(7,"G");
		HeroNode H = new HeroNode(8,"H");
		HeroNode I = new HeroNode(9,"I");
		HeroNode J = new HeroNode(10,"J");
		HeroNode K = new HeroNode(11,"K");
		HeroNode L = new HeroNode(12,"L");
		HeroNode M = new HeroNode(13,"M");

		A.setLeft(B);
		A.setRight(C);
		B.setRight(D);
		C.setRight(E);
		D.setLeft(F);
		D.setRight(G);
		E.setLeft(H);
		E.setRight(I);
		F.setRight(J);
		G.setRight(K);
		I.setLeft(L);
		I.setRight(M);

		System.out.println("前序遍历");
		brinaryTree.setRoot(A);
		brinaryTree.infixcOrder();
		
//		System.out.println("中序遍历");
//		brinaryTree.infixcOrder();
//		
//		System.out.println("后序遍历");
//		brinaryTree.postOrder();
		
//		System.out.println("*****************下面是查找操作******************");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String no = reader.readLine();
//		System.out.println(brinaryTree.postSearch(Integer.valueOf(no)));
		
		
		
		System.out.println("*****************下面是删除操作******************");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String no = reader.readLine();
		brinaryTree.delHeroNode(Integer.valueOf(no));
		System.out.println("操作完毕");
		brinaryTree.preOrder();
	}
}
//定义二叉树
class BrinaryTree{
	private HeroNode root;

	public void setRoot(HeroNode root) {
		this.root = root;
	}
	
	//遍历二叉树
	public void preOrder() {
		if (this.root != null) {
			this.root.preOrder();
		} else {
			System.out.println("当前二叉树为空！");
		}
	}
	public void infixcOrder() {
		if (this.root != null) {
			this.root.infixOrder();
		} else {
			System.out.println("当前二叉树为空！");
		}
	}
	public void postOrder() {
		if (this.root != null) {
			this.root.postOrder();
		} else {
			System.out.println("当前二叉树为空！");
		}
	}
	
	//前序遍历搜索
	public HeroNode preSearch(int no) {
		if (root != null) {
			return root.preOrderSearch(no);
		} else {
			return null;
		}
	}
	
	//中序遍历搜索
	public HeroNode infixSearch(int no) {
		if (root != null) {
			return root.infixOrderSearch(no);
		} else {
			return null;
		}
	}
	
	//后序遍历搜索
	public HeroNode postSearch(int no) {
		if (root != null) {
			return root.postOrderSearch(no);
		} else {
			return null;
		}
	}
	
	// 递归删除节点
	// 注意：这里的树是没有规则建立起来的树，之后写的有规则的树进行删除时有另一套自己的规则
	// 这里定义删除的规则：
	// 1.如果删除的节点是叶子节点，则删除该节点
	// 2.如果删除的节点是非叶子节点，则删除该子树
	public void delHeroNode(int no) {
		//root为空
		if (root == null) {
			System.out.println("当前root为空！");
			return;
		}
		//root是否就是要删除的节点
		if (root.getNo() == no) {
			root = null;
			return;
		}
		root.del(no,root);
	}
}
//创建节点bean
class HeroNode{
	private int no;
	private String name;
	private HeroNode left;//默认为null
	private HeroNode right;//默认为null
	boolean isFound = false;//记录删除时是否已经完成删除操作
	public HeroNode(int no, String name) {
		super();
		this.no = no;
		this.name = name;
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
	public HeroNode getLeft() {
		return left;
	}
	public void setLeft(HeroNode left) {
		this.left = left;
	}
	public HeroNode getRight() {
		return right;
	}
	public void setRight(HeroNode right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + "]";
	}
	/**
	 * 
	 * @param no  传入需要删除的员工id
	 * @param root	用于记录是否找到并删除待删除的员工（关于root的判断已经在树类中判断了）
	 */
	public void del(int no,HeroNode root) {
		//判断当前的左子节点
		if (this.left != null && this.left.no == no) {
			isFound = true;
			this.left = null;
		}
		//判断当前右子节点
		if (this.right != null && this.right.no == no) {
			this.right = null;
			root.isFound = true;
		}
			// 向左子树递归删除
			if (this.left != null && !root.isFound) {
				this.left.del(no,root);
			}
			// 向右子树递归删除
			if (this.right != null && !root.isFound) {
				this.right.del(no,root);
			}
		
	}
	//编写前序遍历的方法
	public void preOrder() {
		//先输出父节点
		System.out.println(this);
		//向左子树遍历
		if (this.left != null) {
			this.left.preOrder();
		}
		//向右子树遍历
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	//中序遍历
	public void infixOrder() {
		// 向左子树遍历
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	//后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		if (this.right != null) {
			this.right.postOrder();
		}
		System.out.println(this);
	}
	
	
	/**
	 *  前序查找
	 * @param no  所要查找的员工id
	 * @return  返回对应员工节点
	 */
	public HeroNode preOrderSearch(int no) {
		System.out.println("进入前序查找！");
		//判断当前节点是否为目标节点
		if(this.getNo() == no) {
			return this;
		}
		//先要判断左节点是否为空
		//要注意这里不能直接return this.left.preOrderSearch(no)，因为在左节点未能找到是，会返回null，
		//从而使得递归结束，不能执行右节点的递归
		HeroNode tempHeroNode = null;
		//向左递归查找
		if (this.getLeft() != null) {
			tempHeroNode = this.left.preOrderSearch(no);
		}
		if (tempHeroNode != null) {
			return tempHeroNode;
		}
		//向右递归查找
		if (this.getRight() != null) {
			tempHeroNode = this.right.preOrderSearch(no);
		}
		//这一步无需再进行判断，因为无论找到与否都将返回
		return tempHeroNode;
	}
	/**
	 * 中序查找
	 * @param no	所要查找的员工id
	 * @return	返回对应员工节点
	 */
	public HeroNode infixOrderSearch(int no) {
		System.out.println("进入中序查找！");
		HeroNode temHeroNode = null;
		if (this.left != null) {
			temHeroNode = this.left.infixOrderSearch(no);
		}
		if (temHeroNode != null) {
			return temHeroNode;
		}
		if (this.getNo() == no) {
			return this;
		}
		if (this.right != null) {
			temHeroNode = this.right.infixOrderSearch(no);
		}
		return temHeroNode;
	}
	/**
	 * 后序查找
	 * @param no
	 * @return
	 */
	public HeroNode postOrderSearch(int no) {
		System.out.println("进入后序查找！");
		HeroNode temHeroNode = null;
		if (this.left != null) {
			temHeroNode = this.left.postOrderSearch(no);
		}
		if (temHeroNode != null) {
			return temHeroNode;
		}
		if (this.right != null) {
			temHeroNode = this.right.postOrderSearch(no);
		}
		if (this.getNo() == no) {
			return this;
		}
		return temHeroNode;
	}
}
