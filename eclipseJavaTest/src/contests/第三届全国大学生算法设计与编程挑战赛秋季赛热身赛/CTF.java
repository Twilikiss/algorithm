package contests.第三届全国大学生算法设计与编程挑战赛秋季赛热身赛;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CTF {
	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int day = 0;
		try {
			day = Integer.valueOf(reader.readLine());
		} catch (NumberFormatException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int answer = 0;
		int n = 1;
		while(true) {
			if (Math.pow(2,n + 1) - 2 >= day) {
				break;
			}
			n++;
		}
		int index = day;
		for (int i = 1; i <= n; i++) {
			if (i == n) {
				answer =  answer + index * i;
				break;
			}
			answer += (int) (Math.pow(2, i) * i);
			index =  index - (int)(Math.pow(2, i));
		}
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			w.write(String.valueOf(answer));
			w.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
