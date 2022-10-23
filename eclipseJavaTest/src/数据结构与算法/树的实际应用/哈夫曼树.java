package 数据结构与算法.树的实际应用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 哈夫曼树代码实现
 * @author mlp52
 *
 */
public class 哈夫曼树 {
	public static void main(String[] args) {
		int[] arr = {13,7,8,3,29,6,1};
		node root = HuffmanTree(arr);
		preOrder(root);
	}
	
	//创建哈夫曼树的方法
	public static node HuffmanTree(int[] numbers) {
		List<node> nodes = new ArrayList<>();
		for(int out : numbers) {
			nodes.add(new node(out));
		}
		
		while(nodes.size() > 1) {
			//先从小到大排序（取决于node类接口的实现）
			Collections.sort(nodes);
            //System.out.println(nodes);
			node leaf = nodes.get(0);
			node right = nodes.get(1);
			
			node parent = new node(leaf.getValue() + right.getValue());
			parent.setLeaf(leaf);
			parent.setRight(right);
			
			//从ArrayList中删除那两个节点
			//注意这里remove不能传入链表的下标，因为删除其中一个下标，整体的下标也会改变
//			nodes.remove(0);<------ X
//			nodes.remove(1);<------ X
			nodes.remove(leaf);
			nodes.remove(right);
			
			//将parent加入到ArraysList
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	public static void preOrder(node root) {
		if (root == null) {
			System.out.println("当前是空树！！！");
		} else {
			root.preOrder();
		}
		
	}
}

//创建节点类
//为了使节点能够通过Collections工具类进行排序，需要让node类实现Comparable接口
class node implements Comparable<node>{
	private int value;// 节点权值
	private node leaf;// 指向左边的节点
	private node right;// 指向右边的节点
	
	public node(int value) {
		super();
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public node getLeaf() {
		return leaf;
	}
	public void setLeaf(node leaf) {
		this.leaf = leaf;
	}
	public node getRight() {
		return right;
	}
	public void setRight(node right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "node [value=" + value + "]";
	}
	
	@Override
	public int compareTo(node o) {
		// TODO Auto-generated method stub
		// 表示从小到大排序
		return this.value - o.value;
	}
	//前序遍历
	public void preOrder() {
		System.out.println(this);
		if (this.leaf != null) {
			this.leaf.preOrder();
		}
		if(this.right != null) {
			this.right.preOrder();
		}
	}
	
}