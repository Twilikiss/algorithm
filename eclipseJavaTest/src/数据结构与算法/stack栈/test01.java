package 数据结构与算法.stack栈;

public class test01 {
	public static void main(String[] args) {
		ArrayStack01 arrayStack = new ArrayStack01(10);
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		arrayStack.push(4);
		arrayStack.push(5);
		arrayStack.push(6);
		arrayStack.push(7);
		arrayStack.push(8);
		arrayStack.push(9);
		arrayStack.push(10);
//		arrayStack.push(11);
		System.out.println(arrayStack.pop());
//		arrayStack.all();
  }
}
class ArrayStack01{
	private int maxSize;
	private int top = -1;
	private int[] stack;
	
	//maxSize的有参构造器
	public ArrayStack01(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
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
}
