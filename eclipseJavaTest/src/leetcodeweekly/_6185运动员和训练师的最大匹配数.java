package leetcodeweekly;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 players ，其中 players[i] 表示第 i 名运动员的 能力 值，同时给你一个下标从 0 开始的整数数组 trainers ,
 * 其中 trainers[j] 表示第 j 名训练师的 训练能力值 。

如果第 i 名运动员的能力值 小于等于 第 j 名训练师的能力值，那么第 i 名运动员可以 匹配 第 j 名训练师。
除此以外，每名运动员至多可以匹配一位训练师，每位训练师最多可以匹配一位运动员。

请你返回满足上述要求 players 和 trainers 的 最大 匹配数。

示例 1：
输入：players = [4,7,9], trainers = [8,2,5,8]
输出：2
解释：
得到两个匹配的一种方案是：
- players[0] 与 trainers[0] 匹配，因为 4 <= 8 。
- players[1] 与 trainers[3] 匹配，因为 7 <= 8 。
可以证明 2 是可以形成的最大匹配数。

示例 2：
输入：players = [1,1,1], trainers = [10]
输出：1
解释：
训练师可以匹配所有 3 个运动员
每个运动员至多只能匹配一个训练师，所以最大答案是 1 。
 

提示：
1 <= players.length, trainers.length <= 105
1 <= players[i], trainers[j] <= 109

 * @author mlp52
 *
 */
public class _6185运动员和训练师的最大匹配数 {
	public static void main(String[] args) {
		//players = [4,7,9], trainers = [8,2,5,8]
		int i = matchPlayersAndTrainers(new int[]{1,10000},new int[]{10000,1});
		int j = matchPlayersAndTrainersPro(new int[]{4,7,9},new int[]{9,9,9});
		System.out.println(i);
		System.out.println(j);
	}
	public static ArrayList<Integer> doArrays(int[] in) {
		ArrayList<Integer> outArrayList = new ArrayList<>();
		for (int i = 0; i < in.length; i++) {
			outArrayList.add(in[i]);
		}
		return outArrayList;
	}
	//第一次采用的ArraysList的相关API来实现，先排序后进行枚举判断
	//执行用时: 1078 ms 超过1秒，容易出现超时
	//内存消耗: 61 MB
	public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		ArrayList<Integer> p = doArrays(players);
		ArrayList<Integer> t = doArrays(trainers);
		int count = 0;
		for(int i = 0;i < p.size();i++) {
			for (int j = 0; j < t.size(); j++) {
				if (p.get(i) <= t.get(j)) {
					t.remove(j);
					count++;
					break;
				}
			}
		}
		return count;
	}
	//改进后的代码，放弃使用ArraysList这一多余的操作
	//执行用时: 31 ms
	//内存消耗: 58.9 MB
	public static int matchPlayersAndTrainersPro(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		int count = 0;
		int index = -1;
		for (int i = 0; i < players.length;i++) {
			for (int j = index + 1; j < trainers.length; j++) {
				if (players[i] <= trainers[j]) {
					count++;
					index = j;
					break;
				}
			}
		}
		return count;
	}
}
