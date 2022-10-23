package 数据结构与算法.树的实际应用;
/**
 * avl平衡二叉树的代码实现
 * @author mlp52
 *
 */
public class 平衡二叉树AVL {
	public static void main(String[] args) {
//		int[] arr = {4,3,6,5,7,8};
//		int[] arr = {10,12,8,9,7,6};
		int[] arr = {10,11,7,6,8,9};
		AVLTree avlTree = new AVLTree();
		
		for (int i = 0; i < arr.length; i++) {
			avlTree.add(new Node02(arr[i]));
		}
		avlTree.infixOrder();
		
		System.out.println("******************平衡二叉树后*******************");
		
		System.out.println("树高为 " + avlTree.getHeight());
		System.out.println("左子树高为 " + avlTree.getLeftHeight());
		System.out.println("右子树的高度为 " + avlTree.getRightHeight());
		System.out.println(avlTree.getRoot().getLeft()  + " : " + avlTree.getRoot().getRight());
		
	}
	
}

class AVLTree{
	private Node02 root;


	public Node02 getRoot() {
		return root;
	}
	public void setRoot(Node02 root) {
		this.root = root;
	}
	public void add(Node02 node) {
		if (root == null) {
			root = node;
		} else {
			root.add(node);
		}
	}
	//中序遍历
	public void infixOrder() {
		if (root == null) {
			System.out.println("当前的树为空！！！无法遍历");
		} else {
			System.out.println("当前的树的根节点为" + root);
			root.infixOrder();
		}
	}
	
	//查找待删除节点
	public Node02 serchNode(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}
	
	//查找待删除节点的父节点
	public Node02 searchParentNode(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}
	//找到以传入的节点为根节点的树的最小值回传并删除最小值的节点
	public int deleteTreeMin(Node02 node) {
		Node02 tempNode = node;
		//查找左子节点
		while(tempNode .getLeft() != null) {
			tempNode = tempNode.getLeft();
		}
		//当退出while循环时，此时的tempNode就是指向最小值
		deleteNode(tempNode.getValue());
		return tempNode.getValue();
	}
	//删除节点
	public void deleteNode(int value) {
		if (root == null) {
			return;
		} else {
			Node02 targetNode = serchNode(value);
			//没找到则终止
			if (targetNode == null) {
				return;
			}
			//如果发现targetNode没有父节点
			if (root.getLeft() == null && root.getRight() == null) {
				root = null;
				return;
			}
			//去找待删除的节点的父节点
			Node02 parentNode = searchParentNode(value);
			//如果要删除的是叶子节点(第一种情况)
			if (targetNode.getLeft() == null && targetNode.getRight() == null) {
				//判断target是父节点左子节点还是右子节点
				if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
					parentNode.setLeft(null);
				} else if(parentNode.getRight() != null && parentNode.getRight().getValue() == value){
					parentNode.setRight(null);
				}
			} else if (targetNode.getLeft() != null && targetNode.getRight() != null) { //第三种情况 
				//找到右子节点的最小值
				int min = deleteTreeMin(targetNode.getRight());
				targetNode.setValue(min);
			} else { // 第二种情况
				if (targetNode.getLeft() != null) {
					if (parentNode != null) {
						if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
							parentNode.setLeft(targetNode.getLeft());
						} else {
							parentNode.setRight(targetNode.getLeft());
						}
					} else {
						root = targetNode.getLeft();
					}

				} else {
					if (parentNode != null) {
						if (parentNode.getLeft() != null && parentNode.getLeft().getValue() == value) {
							parentNode.setLeft(targetNode.getRight());
						} else {
							parentNode.setRight(targetNode.getRight());
						}
					} else {
						root = targetNode.getRight();
					}

				}
			}
		}
	}
	
	// 获得当前该树的高度
	public int getHeight() {
		if (root == null) {
			return 0;
		}
		return root.getHeight();
	}

	// 获得当前该树左子树的高度
	public int getLeftHeight() {
		if (root == null) {
			return 0;
		}
		return root.getLeftHeight();
	}

	// 获得当前该树的高度
	public int getRightHeight() {
		if (root == null) {
			return 0;
		}
		return root.getRightHeight();
	}
}
/**
 * 创建Node节点
 * @author mlp52
 *
 */
class Node02{
	private int value;
	private Node02 left;
	private Node02 right;
	public Node02(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node02 getLeft() {
		return left;
	}
	public void setLeft(Node02 left) {
		this.left = left;
	}
	public Node02 getRight() {
		return right;
	}
	public void setRight(Node02 right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Node02 [value=" + value + "]";
	}
	
	//添加节点
	public void add(Node02 node) {
		if (node == null) {
			return;
		}
		//传入的节点的值和当前子树的根节点的值的关系
		if (node.getValue() < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				//如果不为null，则递归的向左添加
				this.left.add(node);
			}
		} else {// 当传入的节点大于或等于当前子树的根节点的值
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.add(node);
			}
		}
		
		//当添加完成过后，如果右子树的高度- 左子树的高度 > 1就执行左旋左旋转操作
		if (getRightHeight() - getLeftHeight() > 1) {
			//左旋
			if (right != null && right.getLeftHeight() > right.getRightHeight()) {
				right.leftRotate();
				this.leftRotate();
			}else {
				this.leftRotate();
			}
			return;
		}
		if (getLeftHeight() - getRightHeight() > 1) {
			//右旋
			//在对根节点旋转之前先进行判断根节点的左子树的高度和根节点的右子树的高度的关系
			if (left != null && left.getRightHeight() > left.getLeftHeight()) {
				//先对根节点的左子树进行左旋转
				left.leftRotate();
				//再对当前节点进行右旋
				this.rightRoate();
			} else {
				this.rightRoate();
			}
			return;
		}
	}
	
	//中序遍历的方法
	public void infixOrder() {
		
		if (this.left != null) {
			this.left.infixOrder();
		}
		System.out.println(this);
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	//查找要删除的节点
	public Node02 search(int value) {
		if (value == this.value) {
			return this;
		} else if (value < this.value) {
			if (this.left == null) {
				return null;
			}
			return this.left.search(value);
		} else {
			if (this.right == null) {
				return null;
			}
			return this.right.search(value);
		}
	}
	
	//找到被删除节点的父节点(注意：如果查找的是根节点就找不到父节点)
	public Node02 searchParent(int value) {
		if ((this.left != null && this.left.value == value) || (this.right != null && this.right.value == value)) {
			return this;
		} else {
			//查找的值小于当前节点的值
			if (value < this.value && this.left != null) {
				return this.left.searchParent(value);
			} else if(value >= this.value && this.right != null){
				return this.right.searchParent(value); // 向右子树递归查找
			} else {
				return null;
			}
		}
	}
	
	//返回左子树的高度
	public int getLeftHeight() {
		if (left == null) {
			return 0;
		}
		return left.getHeight();
	}

	// 返回右子树的高度
	public int getRightHeight() {
		if (right == null) {
			return 0;
		}
		return right.getHeight();
	}
	
	//返回当前节点为根节点的树的高度
	public int getHeight() {
		return Math.max(left == null ? 0 : left.getHeight(), right == null ? 0 : right.getHeight()) + 1;
	}
	//左旋转的方法
	private void leftRotate() {
		//创建新的节点
		Node02 newNode = new Node02(value);
		//把新的结点的左子树设置成当前结点的左子树
		newNode.setLeft(this.left);
		//把新的结点的右子树设置成当前结点的右子树的左子树
		newNode.setRight(this.getRight().getLeft());
		//把当前结点的值替换成右子结点的值
		this.value = right.getValue();
		//把当前结点的右子树设置成当前结点右子树的右子树
		this.right = this.right.right;
		//把当前结点的左子树(左子结点)设置成新的结点
		left = newNode;
	}
	
	//向右旋转(注意观察，左旋和右旋的操作是刚好相反的)
	private void rightRoate() {
		Node02 newNode = new Node02(this.value);
		newNode.setRight(this.right);
		newNode.setLeft(this.left.right);
		this.value = this.left.value;
		this.setLeft(this.left.left);
		this.right = newNode;
	}
}