package 数据结构与算法.树;
/**
 * 线索化二叉树的代码实现——以线索化和中序遍历线索二叉树为例
 * 本代码是在原来的二叉树的代码进行改进而来
 * @author mlp52
 *
 */
public class ThreadedBinaryTree {
	public static void main(String[] args) {
		HeroNode01 root = new HeroNode01(1, "爱莉希雅");
		HeroNode01 heroNode02 = new HeroNode01(2, "凯文");
		HeroNode01 heroNode03 = new HeroNode01(3, "苏");
		HeroNode01 heroNode04 = new HeroNode01(4, "樱");
		HeroNode01 heroNode05 = new HeroNode01(5, "华");
		HeroNode01 heroNode06 = new HeroNode01(6, "梅比乌斯");
		HeroNode01 heroNode07 = new HeroNode01(7, "帕朵·菲莉斯");
		
		// 先手动创建二叉树，后面将通过递归来创建二叉树
		root.setLeft(heroNode02);
		heroNode02.setLeft(heroNode03);
		heroNode02.setRight(heroNode07);
		root.setRight(heroNode04);
		heroNode04.setRight(heroNode05); 
		heroNode04.setLeft(heroNode06);
		
		//测试线索化
		TBrinaryTree tBrinaryTree = new TBrinaryTree();
		//切记不要忘记设置tree的root节点！！！！！！
		tBrinaryTree.setRoot(root);
		tBrinaryTree.infixThreadedNode(root);
		
		//测试：以帕朵·菲莉丝作为测试节点
		HeroNode01 left = heroNode07.getLeft();
		HeroNode01 right = heroNode07.getRight();
		System.out.println("帕朵·菲莉丝的left是" + left);
		System.out.println("帕朵·菲莉丝的right是" + right);
		
		System.out.println("下面是线性遍历的相关操作");
		tBrinaryTree.threadedinFixList();
		
	}
}
//定义线索化二叉树
class TBrinaryTree{
	private HeroNode01 root;
	
	//设置一个前驱结点,指向当前结点的前驱结点（如果有的话）
	//在递归过程中，这个preHeroNode就是指向
	private HeroNode01 preHeroNode = null;

	public void setRoot(HeroNode01 root) {
		this.root = root;
	}

	//中序[线索化]的方法
	public void infixThreadedNode(HeroNode01 node) {
		if (node == null) {
			return;
		}
		//(一)先线索化左子树
		infixThreadedNode(node.getLeft());
		
		//(二)线索化当前的节点
		//处理前驱节点
		if (node.getLeft() == null) {
			//将指针指向前驱节点
			node.setLeft(preHeroNode);
			//设置该节点的左节点的类型(1:指向前驱;0:指向左节点)
			node.setLeftType(1);
		}
		//处理当前节点的后继节点
		if (preHeroNode != null && preHeroNode.getRight() == null) {
			preHeroNode.setRight(node);
			preHeroNode.setRightType(1);
		}
		
		preHeroNode = node;
		//(三)线索化右节点
		infixThreadedNode(node.getRight());
		
	}
	
	//遍历中序线索化二叉树
	public void threadedinFixList() {
		HeroNode01 node = root;
		while(node != null) {
			while(node.getLeftType() == 0) {
				node = node.getLeft();
			}
			System.out.println(node);
			
			while(node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
}
/**
 * 创建Node节点（结点）
 * @author mlp52
 *
 */
class HeroNode01{
	private int no;
	private String name;
	private HeroNode01 left;//默认为null
	private HeroNode01 right;//默认为null
	boolean isFound = false;//记录删除时是否已经完成删除操作
	//说明
	//1. 如果 leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
	//2. 如果 rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点
	private int leftType;
	private int rightType;
	
	
	public int getLeftType() {
		return leftType;
	}
	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}
	public int getRightType() {
		return rightType;
	}
	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	
	
	public HeroNode01(int no, String name) {
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
	public HeroNode01 getLeft() {
		return left;
	}
	public void setLeft(HeroNode01 left) {
		this.left = left;
	}
	public HeroNode01 getRight() {
		return right;
	}
	public void setRight(HeroNode01 right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "HeroNode01 [no=" + no + ", name=" + name + "]";
	}
	/**
	 * 
	 * @param no  传入需要删除的员工id
	 * @param root	用于记录是否找到并删除待删除的员工（关于root的判断已经在树类中判断了）
	 */
	public void del(int no,HeroNode01 root) {
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
	public HeroNode01 preOrderSearch(int no) {
		System.out.println("进入前序查找！");
		//判断当前节点是否为目标节点
		if(this.getNo() == no) {
			return this;
		}
		//先要判断左节点是否为空
		//要注意这里不能直接return this.left.preOrderSearch(no)，因为在左节点未能找到是，会返回null，
		//从而使得递归结束，不能执行右节点的递归
		HeroNode01 tempHeroNode = null;
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
	public HeroNode01 infixOrderSearch(int no) {
		System.out.println("进入中序查找！");
		HeroNode01 temHeroNode = null;
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
	public HeroNode01 postOrderSearch(int no) {
		System.out.println("进入后序查找！");
		HeroNode01 temHeroNode = null;
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
