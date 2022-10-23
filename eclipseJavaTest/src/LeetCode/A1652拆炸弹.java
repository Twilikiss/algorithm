package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。

为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。

如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
如果 k == 0 ，将第 i 个数字用 0 替换。
由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！

示例 1：
输入：code = [5,7,1,4], k = 3
输出：[12,10,16,13]
解释：每个数字都被接下来 3 个数字之和替换。解密后的密码为 [7+1+4, 1+4+5, 4+5+7, 5+7+1]。注意到数组是循环连接的。

示例 2：
输入：code = [1,2,3,4], k = 0
输出：[0,0,0,0]
解释：当 k 为 0 时，所有数字都被 0 替换。

示例 3：
输入：code = [2,4,9,3], k = -2
输出：[12,5,6,13]
解释：解密后的密码为 [3+9, 2+3, 4+2, 9+4] 。注意到数组是循环连接的。如果 k 是负数，那么和为 之前 的数字。
 
提示：
n == code.length
1 <= n <= 100
1 <= code[i] <= 100
-(n - 1) <= k <= n - 1
 * @author mlp52
 *
 */
public class A1652拆炸弹 {
	public static void main(String[] args) {
		int[] test = {2,4,9,3};
		int k = -2;
		int[] is = decrypt01(test, k);
		System.out.println(Arrays.toString(is));
	}
	public static int[] decrypt(int[] code, int k) {
		// k=0的情况
		if (k == 0) {
//			for (int i = 0; i < code.length; i++) {
//				code[i] = 0;
//			}
			int[] temp = new int[code.length];
			return temp;
		}
		// k < 0的情况
		if (k > 0) {
			int total = 0;
			int[] answer = new int[code.length];
			for (int i = 0; i < code.length; i++) {
				for (int j = i + 1; j < i + 1 + k; j++) {
					int index = j % code.length;
					total += code[index];
				}
				answer[i] = total;
				total = 0;
			}
			return answer;
		}

		// k < 0的情况
		if (k < 0) {
			List<Integer> codeList = Arrays.stream(code).boxed().collect(Collectors.toList());
			Collections.reverse(codeList);
			int total = 0;
			int[] answer = new int[code.length];
			k = -k;
			for (int i = 0; i < code.length; i++) {
				for (int j = i + 1; j < i + 1 + k; j++) {
					int index = j % code.length;
					total += codeList.get(index);
				}
				answer[i] = total;
				total = 0;
			}
			List<Integer> anwlisList = Arrays.stream(answer).boxed().collect(Collectors.toList());
			Collections.reverse(anwlisList);
			int[] temp = new int[anwlisList.size()];
			for (int i = 0; i < answer.length; i++) {
				temp[i] = anwlisList.get(i);
			}
			return temp;
		}
		return null;
	}
	
	//官方题解
	public static int[] decrypt01(int[] code, int k) {
		int n = code.length;
        if (k == 0) {
            return new int[n];
        }
        int[] res = new int[n];
        int[] newCode = new int[n * 2];
        System.arraycopy(code, 0, newCode, 0, n);
        System.arraycopy(code, 0, newCode, n, n);
        code = newCode;
        int l = k > 0 ? 1 : n + k;
        int r = k > 0 ? k : n - 1;
        int w = 0;
        for (int i = l; i <= r; i++) {
            w += code[i];
        }
        for (int i = 0; i < n; i++) {
            res[i] = w;
            w -= code[l];
            w += code[r + 1];
            l++;
            r++;
        }
        return res;
	}
}

