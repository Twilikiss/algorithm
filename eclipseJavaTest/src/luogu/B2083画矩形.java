package luogu;

import java.util.Scanner;

public class B2083画矩形 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String values = scanner.nextLine();
		scanner.close();
		String[] strings = values.split(" ");
		if (strings.length < 4) {
			return;
		}
		int a = Integer.valueOf(strings[0]); // 高
		int b = Integer.valueOf(strings[1]); // 宽
		String inOpString = strings[2]; // 插入的字符
		int isFlag = Integer.valueOf(strings[3]); // 是否空心
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				if (i != 0 && i != a - 1 && j != 0 && j != b - 1 && isFlag == 0) {
					System.out.printf("%s"," ");
				} else {
					System.out.printf("%s",inOpString);
				}
			}
			System.out.print("\n");
		}
	}
}
