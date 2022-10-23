package 数据结构与算法.stack栈;


/**
 * 下面是关于模拟栈来实现综合计算器的第一步改进方案操作
 * 注意的是：
 * 		当我们输入的表达式出现“-”是第一个运算符的时候会出现后面直接计算而不进行变号的情况，会导致结果出问题
 * @author mlp52
 *
 */
public class 栈实现综合计算器_改进1 {
	public static void main(String[] args) {
		String expressionString = "723+2*2-2";
		ArrayStack03 numStack = new ArrayStack03(10);
		ArrayStack03 operStack = new ArrayStack03(10);
		// 扫描索引
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char eachOp = ' ';
		String keepString = "";
		while(true) {
			if(index == expressionString.length()) {
				break;
			}
			eachOp = expressionString.charAt(index);
			
			//判断eachOp是什么，然后再做相应的处理
			if(operStack.isOper(eachOp)) {
				//判断符号栈是否为空
				if(!operStack.isEmpty()) {
					//栈不为空，判断优先级来进行下一步操作
					if(operStack.priority(eachOp) <= operStack.priority(operStack.peek())) {
						//优先级小于或等于
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = operStack.total(num1, num2, oper);
						//结果入数栈
						numStack.push(res);
						//符号入符号栈
						operStack.push(eachOp);
					} else {
						//优先级大于，直接入栈
						operStack.push(eachOp);
					}
				} else {
					//当前栈为空，直接入栈
					operStack.push(eachOp);	
				}
			} else {
				//如果是数则直接入栈会导致多位数计算会出现结果有误的现象
//				numStack.push(eachOp - '0');
				keepString += eachOp;
				//判断下一个是不是数字
				if(index == expressionString.length() - 1) {
					numStack.push(Integer.parseInt(keepString));
				} else {
					if(operStack.isOper(expressionString.charAt(index + 1))) {
					numStack.push(Integer.parseInt(keepString));
					keepString = "";
				}
			 }
				
			}
			index ++;
		}
		//当表达式扫描完毕，就顺序得将符号和数字分别从符号栈和数栈中取出
		while(true) {
			//当符号栈为空的时候，则计算到了最后的结果，数栈中只有一个数字（即为结果）
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.total(num1, num2, oper);
			numStack.push(res);
		}
		System.out.println("计算结果为" + numStack.pop());
	}
	
}

/**
 * 创建出来的栈结构，利用数组来实现，需要扩展功能——符号判断、优先级判断等功能
 * @author mlp52
 *
 */
class ArrayStack03{
	private int maxSize;
	private int top = -1;
	private int[] stack;
	
	//maxSize的有参构造器
	public ArrayStack03(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//查看当前栈顶的值，但不会出栈
	public int peek() {
		return stack[top];
	}
	
	//判断是否栈满
	public boolean isFull() {
//		if (top >= maxSize -1){
//			return true; 
//		}else {
//			return false;
//		}
		return top >= maxSize -1;
	}
	
	//判断是否栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//入栈操作
	public void push(int value) {
		if(isFull()) {
			System.out.println("当前栈满！");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//出栈操作
	public int pop() {
		if (isEmpty()) {
			//因为该方法有返回值，这里建议使用抛出异常的方式
			throw new RuntimeException("当前栈内无数据！无法取出数据");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//遍历栈内的数据
	public void all() {
		if (isEmpty()) {
			System.out.println("当前数据为空！无法进行遍历操作");
			return;
		}
		for(int i = top;i >=0;i--) {
			System.out.printf("srack[%d] = %d\n", i, stack[i]);
		}
	}
	
	//返回运算符的优先级，优先级使用数字表示，数字越大优先级越高
	public int priority(int op) {
		if (op == '*' || op == '/') {
			return 1;
		} else if (op == '+' || op == '-') {
			return 0;
		} else {
			return -1; //这里要注意是假定计算式是只包含“+ - * /”这四个运算
		}
	}
	
	//判断是否为一个操作符
	public boolean isOper(char value) {
		if (value == '+' || value == '-' || value == '*' || value == '/') {
			return true;
		}else {
			return false;
		}
	}
	
	//设置计算方法
	public int total(int num1,int num2,int op) {
		int res = 0;
		switch (op) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		}
		return res;
	}
}