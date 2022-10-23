package LeetCode;

import java.util.HashMap;

public class A12整数转罗马数字 {
	public static void main(String[] args) {
//		System.out.println(intToRoman(23));
		System.out.println(intToRoman01(24));
	}
	//方法一：枚举法，因为本题涉及的情况比较简单
	public static String intToRoman(int num) {
		HashMap<Integer, String> operationHashMap = new HashMap<>();
		String answerString = "";
		operationHashMap.put(1, "I");
		operationHashMap.put(5, "V");
		operationHashMap.put(10, "X");
		operationHashMap.put(50, "L");
		operationHashMap.put(100, "C");
		operationHashMap.put(500, "D");
		operationHashMap.put(1000, "M");
		operationHashMap.put(4, "IV");
		operationHashMap.put(9, "IX");
		operationHashMap.put(40, "XL");
		operationHashMap.put(90, "XC");
		operationHashMap.put(400, "CD");
		operationHashMap.put(900, "CM");
		
		int beginindex = String.valueOf(num).length() - 1;
		
		for(int i = beginindex;i >= 0;i--){
			int temp = num % (int)Math.pow(10, i);
			num = num - temp;
			if (operationHashMap.containsKey(num)) {
				answerString = answerString + operationHashMap.get(num);
				num = temp;
				continue;
			}
		}
		return answerString;
    }
	//方法二：对数字转罗马数字这个过程进行模拟
	public static String intToRoman01(int num) {
		int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] op = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
		StringBuffer stringBuffer = new StringBuffer();
		
		//从大到小分别取出符号进行匹配，直到num == 0
		for(int i = 0; i < nums.length;i++) {
			int key = nums[i];
			String value = op[i];
			if (num == 0) {
				break;
			}
			while (num >= key) {
				num = num - key;
				stringBuffer.append(value);
			}
		}
		return stringBuffer.toString();
	}
}
