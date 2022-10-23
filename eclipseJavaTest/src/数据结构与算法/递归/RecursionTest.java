package 数据结构与算法.递归;

/**
 * 关于递归的相关基础学习
 * 递归：方法调用自己，在栈空间内进行操作
 * @author mlp52
 *
 */
public class RecursionTest {
	public static void main(String[] args) {
		addNumber01(4);
		addNumber02(4);
	}
	
	/**
	 * 输出结果是：
		n = 2
		n = 3
		n = 4

	 * @param in
	 */
	public static void addNumber01(int in){
		if (in > 2) {
			addNumber01(in - 1);
		}
		System.out.println("n = " + in);
	}
	
	/**
	 * 输出结果是：
		只有 n = 2
	 * @param in
	 */
	public static void addNumber02(int in){
		if (in > 2) {
			addNumber02(in - 1);
		} else {
			System.out.println("n = " + in);
		}
		
	}
}
