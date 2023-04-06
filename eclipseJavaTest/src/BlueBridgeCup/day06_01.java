package BlueBridgeCup;

import java.util.Scanner;

/**
 * 题1：小白上楼梯(递归设计)
     小白正在上楼梯，楼梯有n阶台阶，小白一次可以上1阶，2阶或者3阶，
     实现一个方法，计算小白有多少种走完楼梯的方式。
 * @author mlp52
 *
 */
public class day06_01 {
	public static void main(String[] args) {
		System.out.print("请输入台阶数：");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		int out = UpFloor(n);
		System.out.print("走完楼梯的方式为" + " " + out + " " + "种");
	}
	
	public static int UpFloor(int n) {
		if (n == 0) {
			return 1;
		}
		if(n == 1 ) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return UpFloor(n - 1) + UpFloor(n - 2) + UpFloor(n - 3);
	}
}
