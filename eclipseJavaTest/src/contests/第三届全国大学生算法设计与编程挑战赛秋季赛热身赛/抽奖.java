package contests.第三届全国大学生算法设计与编程挑战赛秋季赛热身赛;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 抽奖 {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int stone = 0;
		try {
			stone = Integer.valueOf(bf.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = stone / 160;
		int total = 0;
		int start = 0;
		while(a / 10 != 0) {
			a = a - 10;
			start = start + 3;
			total  = total + 10;
			if (start >= 5) {
				a++;
				start = start - 5;
			}
		
		}
		total += a;
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			w.write(String.valueOf(total));
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
