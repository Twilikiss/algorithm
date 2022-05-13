package BulerBridgeCup;

import java.util.Scanner;

/**
  * 用于测试各类方法的使用情况的返回值
 * @author mlp52
 *
 */
public class test {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	
	String inString = scanner.nextLine();
	
	String[] numberStrings = inString.split(" ");
	
	int total = Integer.valueOf(numberStrings[0]) + Integer.valueOf(numberStrings[1]);
	
	System.out.println(total);
	
		
	
}
}
