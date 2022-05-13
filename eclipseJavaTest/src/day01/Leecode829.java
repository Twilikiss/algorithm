package day01;

import org.junit.Test;
/**
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 

示例 1:
输入: n = 5
输出: 2
解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。

示例 2:
输入: n = 9
输出: 3
解释: 9 = 4 + 5 = 2 + 3 + 4

示例 3:
输入: n = 15
输出: 4
解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5

提示:

1 <= n <= 109​​​​​​​

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/consecutive-numbers-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author mlp52
 *
 */
public class Leecode829 {
	
	public static void main(String[] args) {
		Leecode829 leecode829 = new Leecode829();
		
		int back = leecode829.test(5);
		
		System.out.println(back);
	}
	@Test
	public int test(int n) {
		int count = 0;
		for(int start = 1;start <= n;start++) {
			int taget = n;
			int num = start;
			while(taget > 0) {
				taget = taget - num;
				num = num + 1;
				if(taget == 0) {
					count++;
					break;
				}
			}
		}
		return count;
	}
	}
