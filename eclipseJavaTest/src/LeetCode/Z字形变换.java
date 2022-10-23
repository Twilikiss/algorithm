package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 

示例 1：

输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：

输入：s = "A", numRows = 1
输出："A"
 

提示：

1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000


 * @author mlp52
 *
 */
public class Z字形变换 {
	public static void main(String[] args) {
		String teString = convert("PAYPALISHIRING",3);
		System.out.println(teString);
		String teString01 = convert01("PAYPALISHIRING",3);
		System.out.println(teString01);
	}
	//自我求解：这种方式可读性比较差，思路清晰，但是整体代码比较混乱
	 public static String convert(String s, int numRows) {
		 Map<Integer,ArrayList<Character>> map = new HashMap<>();
		 int total = s.length();
		 if(s.length() <= numRows) {
			 return s;
		 }
		 
		 while(true) {
			 //字符串小于和等于“z”形排列的行数的情形
			 if (s.length() <= numRows) {
				 for(int i = 1;i <= s.length();i++) {
					 ArrayList<Character> arrayList = new ArrayList<Character>();
					 arrayList.add(s.charAt(i));
					 map.put(i,arrayList); 
				 }
				 break; 
			}
			//创建对应的键值表和链表	
			 if (total == s.length()) {
				for(int i = 1;i <= numRows;i++) {
					 ArrayList<Character> arrayList = new ArrayList<Character>();
					 map.put(i,arrayList); 
				 }
			} else if(total == 0) {
				break;
			}
			 
			 //total是当前字符串的长度
			 if (total >= (numRows + numRows - 2)) {
					for(int i = 1;i <= numRows ;i++) {
						map.get(i).add(s.charAt(s.length() - total));
						total--;
					}
					for(int i = numRows - 1;i > 1;i--) {
						map.get(i).add(s.charAt(s.length() - total));
						total--;
					}
				} else {
					if (total <= numRows) {
						int index = total;
						for(int i = 1;i <= index ;i++) {
							map.get(i).add(s.charAt(s.length() - total));
							total--;
					}
						break;
				}
					
						for(int i = 1;i <= numRows ;i++) {
							map.get(i).add(s.charAt(s.length() - total));
							total--;
					}
						int index = total;
						for(int i = numRows - 1;i >= numRows - index;i--) {
							map.get(i).add(s.charAt(s.length() - total));
							total--;
						}
					}
					
						if (total == 0 ) {
							break;
						}
					
					
			 }
			 
		 String outString  = "";
			 for(Map.Entry<Integer, ArrayList<Character>> entry : map.entrySet()) {
					for(Character out : entry.getValue()) {
						outString = outString + out.toString();
					}
		 }
		 
		 return outString;
   }
	 
	 //官方解法一：利用二维数组来模拟排列
	 public static String convert01(String s, int numRows) {
		 //字符串长度
		 int total = s.length();
		 int r = numRows;
		 //排除第一种情况：当字符串的长度小于或等于numRows和numRows等于1，这种情况直接返回字符串
		 if (total <= r || r == 1) {
			return s;
		}
		 //确认并创建二维数组
		 //行数=numRows，列数=
		 int t = r * 2 - 2; //一个周期的元素个数
		 int temp = total / (r * 2 - 2);
		 int l = 0;
		 if(total % (r * 2 - 2) == 0) {
			 l = temp * t;
		 } else if(total % (r * 2 - 2) <= r) {
			l = temp * t + 1;
		} else{
			l = temp * t  + 1 + (total % (r * 2 - 2) - r);
		} 
		 //创建好对应二维数组
		 char[][] mat = new char[r][l];
		 //将数据按照题目规定填入到二维数组中
		 int x = 0,y = 0; //二维数组的x和y值
		 for(int i = 0;i < total;i++) {
			 mat[x][y] = s.charAt(i); // 放入到二维数组中
			 if (i % t + 1 < r) {
				x++; // 坐标向下移动
			} else {
				x--;
				y++; // 向着右上方移动
			}
		 }
		 StringBuffer ans = new StringBuffer();
		 for(char[] out : mat) {
			 for(char data : out) {
				 if (data != 0) {
					ans.append(data);
				}
			 }
		 }
		 return ans.toString();
	}
}
