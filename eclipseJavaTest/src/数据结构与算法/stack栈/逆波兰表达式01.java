package 数据结构与算法.stack栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 逆波兰表达式01 {
	public static void main(String[] args) {
		//先定义一个逆波兰表达式
		//说明
		String suffixEpression = "5 2 6 x - 5 -";
		//1.先将逆波兰表达式的内容放到ArrayList中
		int answer  = calculation(suffixEpression);
		
		System.out.println("计算结果为： " + answer);
//		System.out.println(getListStrings(suffixEpression));
		
		//2.将ArrayList传递给一个方法，配合栈完成计算
	}
	
	/**
	 * 将一个逆波兰表达式的数据和运算符依次放入到一个ArrayList中,方便我们进行后续操作
	 */
	public static List<String> getListStrings(String suffexString){
		//将suffexString分割
		String[] spliStrings = suffexString.split(" ");
		List<String> list = new ArrayList<>();
		
		for(String inString : spliStrings) {
			list.add(inString);
		}
		return list;
	}
	
	/**
	 * 完成对逆波兰表达式的计算：
	 * 1．从左至右扫描，将 3 和 4 压入堆栈；
     * 2．遇到+运算符，因此弹出 4 和 3（4 为栈顶元素，3 为次顶元素），计算出 3+4 的值，得 7，再将 7 入栈；
     * 3．将 5 入栈；
     * 4．接下来是×运算符，因此弹出 5 和 7，计算出 7×5=35，将 35 入栈；
     * 5．将 6 入栈；
     * 6．最后是-运算符，计算出 35-6 的值，即 29，由此得出最终结果
	 */
	public static int calculation(String suffexString) {
		//1.从左至右扫描，将 3 和 4 压入堆栈；
		List<String> itemStrings = getListStrings(suffexString);
		Stack<String> stack = new Stack<>();
		
		for(String indexString : itemStrings) {
			//使用正则表达式来验证是否为数字
			if (indexString.matches("\\d+")) {
				stack.push(indexString);
			} else {
				int num01 = Integer.valueOf(stack.pop());
				int num02 = Integer.valueOf(stack.pop());
				int total = 0;
				if (indexString.equals("+")) {
					total = num01 + num02;
				} else if (indexString.equals("-")) {
					total = num02 - num01;
				} else if (indexString.equals("x")) {
					total = num01 * num02;
				} else if (indexString.equals("/")) {
					total = num02 / num01;
				} else {
					System.out.println("非法计算符！");
				}
				//将得出的结果压入栈中
				stack.push(String.valueOf(total));
			}
		}
		return Integer.parseInt(stack.pop());
	}
}
