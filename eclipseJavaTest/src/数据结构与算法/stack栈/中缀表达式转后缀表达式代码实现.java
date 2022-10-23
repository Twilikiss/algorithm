package 数据结构与算法.stack栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 关于中缀表达式转后缀表达式代码实现
 * 思路分析：
	1) 初始化两个栈：运算符栈 s1 和储存中间结果的栈 s2；
	2) 从左至右扫描中缀表达式；
	3) 遇到操作数时，将其压 s2；
	4) 遇到运算符时，比较其与 s1 栈顶运算符的优先级：
		1.如果 s1 为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
		2.否则，若优先级比栈顶运算符的高，也将运算符压入 s1；
		3.否则，将 s1 栈顶的运算符弹出并压入到 s2 中，再次转到(4-1)与 s1 中新的栈顶运算符相比较；
	5) 遇到括号时：
		(1) 如果是左括号“(”，则直接压入 s1
		(2) 如果是右括号“)”，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
	6) 重复步骤 2 至 5，直到表达式的最右边
	7) 将 s1 中剩余的运算符依次弹出并压入 s2
	8) 依次弹出 s2 中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 * @author mlp52
 *
 */
public class 中缀表达式转后缀表达式代码实现 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("请输入表达式:  ");
		
		//中缀表达式
		String expressionString = scanner.nextLine();
		
		//将中缀表达式转换成list集合，方便后续操作
		List<String> outList = getListStrings(expressionString);
		
		//将中缀表达式转换成后缀表达式
		List<String> dataList = pareSuffixExpressionList(outList);
		
		int outPut = calculationForNew(dataList);
		
		System.out.println("计算结果为： " + outPut);
		
		scanner.close();
	}
	
	//将传入的中缀表达式转换成list，方便后续操作（注意对多位数的处理）
	public static List<String> getListStrings(String suffexString){
		List<String> list = new ArrayList<>();
		int index = 0;
		String string;
		while(suffexString.length() > index) {
			//判断为非数字直接入list
			if (suffexString.charAt(index) < 48 || suffexString.charAt(index) > 57) {
				list.add("" + suffexString.charAt(index));
				//加入list后，index要向后移动
				index++;
			} else { //如果是数字
				string = "";//防止存有的字符串信息干扰，先将其清空
				//判断并处理多位数
				while(index < suffexString.length() && suffexString.charAt(index) >=48 && suffexString.charAt(index) <= 57) {
					string += suffexString.charAt(index);
					index++;
				}
				list.add(string);
			}
		}
		return list;
	}
	
	/**
	 * 将中缀表达式转为后缀表达式
	 */
	public static List<String> pareSuffixExpressionList(List<String> ls){
		//初始化栈
		Stack<String> s1 = new Stack<>();
		//因为s2没有pop操作，而且后面还要逆序操作
		//这里使用ArrayList来代替栈结构
		ArrayList<String> s2 = new ArrayList<>();
		
		//遍历ls
		for(String item : ls) {
			//如果遇到是数字，则入s2这个栈
			if (item.matches("\\d+")) {
				s2.add(item);
			}else if (s1.isEmpty() || s1.peek().equals("(")) {
				s1.push(item);
			} else if (item.equals("(")) {
				s1.push(item);	
			} else if (item.equals(")")) {
				//如果是右括号，则依次弹出 s1 栈顶的运算符，并压入 s2，直到遇到左括号为止，此时将这一对括号丢弃
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();// 要记得将s1中的"("弹出
			} else {
				//如果此时s1为空或者s1栈顶的运算符为“（”，则直接将此运算符压入s1
				//当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并压入s2，再次转到（4，1）与s1中新的运算符相比较
				while(!s1.isEmpty() && !s1.peek().equals("(") && Operation.OperationCompare(s1.peek()) >= Operation.OperationCompare(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}
		
		//将s1中剩余的运算符压入到s2中
		while(!s1.isEmpty()) {
			s2.add(s1.pop());
		}
		//当s2是ArrayList时，不需要进行逆序输出
		return s2;
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
	public static int calculationForNew(List<String> itemStrings) {
		//1.从左至右扫描，将 3 和 4 压入堆栈；
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
class Operation{
	//加
	private static final int ADD = 1;
	//减
	private static final int SUB = 1;
	//乘
	private static final int MUL = 2;
	//除
	private static final int DIV = 2;
	
	/**
	 * 处理运算符优先级高低的方法
	 * true为前者大于后者，false为后者大于前者
	 */
	public static int OperationCompare(String Op) {
		int result = 0;
		switch (Op) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "x":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("不存在该运算符！");
		}
		return result;
	}
}
