package 数据结构与算法.树的实际应用;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 哈夫曼树代码实现
 * @author mlp52
 *
 */
public class 哈夫曼编码 {
	public static void main(String[] args) {
		String str = "All you can do is learn from your mistakes";
		char[] charArray = str.toCharArray();
		List<Node01> nodes = getNodes(charArray);
		Node01 root = HuffmanTree(nodes);
		getHuffmanCode(root);
		System.out.println("哈夫曼编码为" + huffmanCodeMap);
	}
	/**
	 * 传入char数组类型的数据，转换为哈夫曼编码过后的byte[]
	 * @param inChar 原始数据
	 * @param huffmanMap  哈夫曼编码表
	 * @return	处理后的数据（二进制）
	 */
	public static byte[] zip(char[] inChar,Map<Character, String> huffmanMap) {
		return null;
	}
	/**
	 * 将传入的包含数据内容的char型数组转换为List结构备用
	 * @param inChar
	 * @return
	 */
	public static List<Node01> getNodes(char[] inChar){
		List<Node01> nodesList =  new ArrayList<>();
		Map<Character, Integer> countsMap = new HashMap<>();
		for(char out : inChar) {
			if (countsMap.containsKey(out)) {
				countsMap.put(out, countsMap.get(out) + 1);
			} else {
				countsMap.put(out, 1);
			}
		}
		//接下来将每一个键值对转成Node并加入到List中
		for(Map.Entry<Character, Integer> entry : countsMap.entrySet()) {
			nodesList.add(new Node01(entry.getKey(),entry.getValue()));
		}
		
		return nodesList;
	}
	
	
	//创建哈夫曼树的方法
	public static Node01 HuffmanTree(List<Node01> nodes) {
		while(nodes.size() > 1) {
			//先从小到大排序（取决于node类接口的实现）
			Collections.sort(nodes);
            //System.out.println(nodes);
			Node01 leaf = nodes.get(0);
			Node01 right = nodes.get(1);
			
			Node01 parent = new Node01(null,leaf.getValue() + right.getValue());
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
	
	public static void preOrder(Node01 root) {
		if (root == null) {
			System.out.println("当前是空树！！！");
		} else {
			root.preOrder();
		}
		
	}
	
	/**
	 * 将哈夫曼树转换为哈夫曼编码，转存到Map<Character,String>中
	 * 注意因为生成哈夫曼编码要不断拼接string，因此定义一个StringBuilder来存储
	 */
	static Map<Character, String> huffmanCodeMap = new HashMap<>();
//	static StringBuilder sb = new StringBuilder();
	/**
	* 功能：将传入的 node 结点的所有叶子结点的赫夫曼编码得到，并放入到 huffmanCodeMap 集合
	* @param node	传入结点
	* @param code	路径： 左子结点是 0, 右子结点 1
	* @param stringBuilder 	用于拼接路径
	 */
	public static void getHuffmanCode(Node01 node,String code,StringBuilder s) {
		StringBuilder stringBuilder2 = new StringBuilder(s);
		stringBuilder2.append(code); // 拼接code
		if (node != null) {
			//判断node是叶子节点还是非叶子节点
			if (node.getC() == null) { // 非叶子节点
				//递归处理
				//向左递归
				getHuffmanCode(node.getLeaf(), "0", stringBuilder2);
				//向右递归
				getHuffmanCode(node.getRight(), "1", stringBuilder2);
			} else {//找到叶子节点
				huffmanCodeMap.put(node.getC(), stringBuilder2.toString());
			}
		}
	}
	
	public static Map<Character, String> getHuffmanCode(Node01 root){
		if (root == null) {
			return null;
		}
		getHuffmanCode(root,"",new StringBuilder());
		return huffmanCodeMap;
	}
}

//创建节点类
//为了使节点能够通过Collections工具类进行排序，需要让node类实现Comparable接口
class Node01 implements Comparable<Node01>{
	private int value;// 节点权值（对应字符出现的次数）
	private Character c; // 对应的字符
	private Node01 leaf;// 指向左边的节点
	private Node01 right;// 指向右边的节点
	
	public Node01(Character c,int value) {
		super();
		this.value = value;
		this.c = c;
	}
	
	public Character getC() {
		return c;
	}

	public void setC(Character c) {
		this.c = c;
	}

	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node01 getLeaf() {
		return leaf;
	}
	public void setLeaf(Node01 leaf) {
		this.leaf = leaf;
	}
	public Node01 getRight() {
		return right;
	}
	public void setRight(Node01 right) {
		this.right = right;
	}
	
	
	@Override
	public String toString() {
		return "Node01 [value=" + value + ", c=" + c + "]";
	}

	@Override
	public int compareTo(Node01 o) {
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