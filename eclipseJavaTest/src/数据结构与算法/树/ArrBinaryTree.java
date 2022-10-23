package 数据结构与算法.树;
/**
 * 顺序存储二叉树的代码实现（前序遍历）
 * 应用的案例----->堆排序！！！
 * @author mlp52
 *
 */
public class ArrBinaryTree {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8};
		ArrTree arrTree = new ArrTree(arr);
		arrTree.preOrder();
	}
	//编写顺序二叉树的具体实现方法，实现顺序存储二叉树的遍历	
}
class ArrTree{
	private int[] arr;
	
	public ArrTree(int[] arr) {
		this.arr = arr;
	}
	
	//重载preOrder的方法
	public void preOrder() {
		this.preOrder(0);
	}
	
	/**
	 * 编写一个方法来对二叉树进行顺序遍历
	 * @param index	开始的数组下标
	 */
	public void preOrder(int index) {
		//数组为空 或者 arr.length = 0
		if (arr.length == 0 || arr == null) {
			System.out.println("数组为空，不能按照二叉树的前序遍历！");
			return;
		}
		//输出当前的数据
		System.out.println(arr[index]);
		
		//向左递归
		if (index * 2 + 1 < arr.length) {
			preOrder(index * 2 + 1);
		}
		//向右递归
		if (index * 2 + 2 < arr.length) {
			preOrder(index * 2 + 2);
		}
	}
}
