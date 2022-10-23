package 数据结构与算法.树的实际应用;
/**
 * 二叉排序树的代码实现——创建、遍历和删除
 * @author mlp52
 *
 */
public class 二叉排序树BST {
	public static void main(String[] args) {
		int[] arr = {7,3,10,12,5,1,9,2};
		BST bst = new BST();
		for (int i = 0; i < arr.length; i++) {
			bst.add(new Node(arr[i]));
		}
		
		bst.infixOrder();
		
		bst.deleteNode(2);
		bst.deleteNode(5);
		bst.deleteNode(9);
		bst.deleteNode(12);
		bst.deleteNode(7);
		bst.deleteNode(3);
		bst.deleteNode(10);
		bst.deleteNode(1);
		
		bst.infixOrder();
	}
	
}
/**
 * 创建一个二叉排序树
 * @author mlp52
 *
 */
class BST{
	private Node root;
	
	public void add(Node node) {
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
	public Node serchNode(int value) {
		if (root == null) {
			return null;
		} else {
			return root.search(value);
		}
	}
	
	//查找待删除节点的父节点
	public Node searchParentNode(int value) {
		if (root == null) {
			return null;
		} else {
			return root.searchParent(value);
		}
	}
	//找到以传入的节点为根节点的树的最小值回传并删除最小值的节点
	public int deleteTreeMin(Node node) {
		Node tempNode = node;
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
			Node targetNode = serchNode(value);
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
			Node parentNode = searchParentNode(value);
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
}
/**
 * 创建Node节点
 * @author mlp52
 *
 */
class Node{
	private int value;
	private Node left;
	private Node right;
	public Node(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	//添加节点
	public void add(Node node) {
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
	public Node search(int value) {
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
	public Node searchParent(int value) {
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
}