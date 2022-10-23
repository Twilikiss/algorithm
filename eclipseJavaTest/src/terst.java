
import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.junit.Test;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

public class terst {
	public static void main(String[] args) throws IOException{
//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer ts = new StringTokenizer("");
//		 while ( ! ts.hasMoreTokens() ) {
//             ts = new StringTokenizer(reader.readLine());
//         }
//		String inString = ts.nextToken();
//		PrintWriter outPrintWriter = new PrintWriter(new OutputStreamWriter(System.out));
//		outPrintWriter.print(inString);
//		outPrintWriter.flush();
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String string = read.readLine();
		System.out.println(string);
	}
	@Test
	public void test01() {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		try {
			i = bf.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
	}
	
	@Test
	public void test02() throws IOException {
		student s = new student(10);
		student s1 = s;
		s = null;
		System.out.println(s1);
		
	}	
	
	@Test
	public void test03() {
		int[] nums2 = {1,3,2,4,6,5};
		Integer[] idx = new Integer[nums2.length];
		for (int i = 0; i < nums2.length; i++) {
			idx[i] = i;
		}
		Arrays.sort(idx, (i,j) -> nums2[i] - nums2[j]);
		System.out.println(Arrays.toString(idx));
	}
	
}
class student{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public student(int age) {
		super();
		this.age = age;
	}

	@Override
	public String toString() {
		return "student [age=" + age + "]";
	}
	
}