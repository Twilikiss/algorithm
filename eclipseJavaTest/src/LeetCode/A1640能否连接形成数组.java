package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。

如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。

示例 1：
输入：arr = [15,88], pieces = [[88],[15]]
输出：true
解释：依次连接 [15] 和 [88]

示例 2：
输入：arr = [49,18,16], pieces = [[16,18,49]]
输出：false
解释：即便数字相符，也不能重新排列 pieces[0]

示例 3：
输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
输出：true
解释：依次连接 [91]、[4,64] 和 [78]
 
提示：
1 <= pieces.length <= arr.length <= 100
sum(pieces[i].length) == arr.length
1 <= pieces[i].length <= arr.length
1 <= arr[i], pieces[i][j] <= 100
arr 中的整数 互不相同
pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * @author mlp52
 *
 */
public class A1640能否连接形成数组 {
	public static void main(String[] args) {
		//arr = [15,88], pieces = [[88],[15]]
		//[91,4,64,78]
//		[[78],[4,64],[91]]
		int[] arr01 = {91,4,64,78};
		int[][] arr02 = new int[3][2];
		arr02[0][0] = 78;
		arr02[1][0] = 4;
		arr02[1][1] = 64;
		arr02[2][0] = 91;
		boolean canFormArray = canFormArray(arr01, arr02);
		System.out.println(canFormArray);
	}
	public static boolean canFormArray(int[] arr, int[][] pieces) {
		int arrLength = arr.length;
		int piecesLength = pieces.length;
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < piecesLength; i++) {
			hashMap.put(pieces[i][0],i);
		}
		for(int i = 0; i < arrLength;) {
			if (!hashMap.containsKey(arr[i])) {
				return false;
			}
			int j = hashMap.get(arr[i]);
			int len = pieces[j].length;
			for(int k = 0;k < len;k++) {
				if (arr[i + k] != pieces[j][k]) {
					return false;
				}
			}
			i = i + len;
		}
		return true;
    }
}
