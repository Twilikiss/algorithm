package 数据结构与算法.动态规划;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 梳理解决01背包
 * @author cxb
 * @ClassName Q1_01背包问题
 * @date 24/3/2023 下午5:06
 */
public class Q1_01背包问题 {
	public static void main(String[] args) {
		Q1_01背包问题 q1 = new Q1_01背包问题();
		List<Integer> weight = new ArrayList<>();
		weight.add(1);
		weight.add(4);
		weight.add(3);
		List<Integer> values = new ArrayList<>();
		values.add(1500);
		values.add(3000);
		values.add(2000);
		int result = q1.zero_one_knapsackPlus(4, weight, values);
		System.out.println(result);
	}
	/**
	 * 
	 * @param capactity 背包容量
	 * @param weight weight[i] 第i个物品的重量
	 * @param values  values[i] 第i个物品的价值
	 * @return 最大价值
	 */
	public int zero_one_knapsack(int capactity, List<Integer> weight, List<Integer> values) {
		int n = weight.size();
		Map<String, Integer> cache = new HashMap<>();
		// 从最后一个物品开始
		return domain01(n - 1, capactity, weight, values, cache);
	}
	/**
	 * 普通版——思路分析！
	 * 回溯算法
	 */
	public int domain(int i, int c, List<Integer> weight, List<Integer> values) {
		if (i < 0) {
		return 0;
		}
		if (c < weight.get(i)) {
			// 当我们的背包装不下那么多东西时，只能选择【不选】
			return domain(i - 1, c, weight, values);
		} else {
			return Math.max(domain(i - 1, c, weight, values), domain(i - 1, c - weight.get(i), weight, values) + values.get(i));
		}
	}
	
	/**
	 * 添加了Map集合cache作为计算结果的保存
	 * 记忆化搜索版——添加cache，显著降低时间复杂度！！！！
	 */
	public int domain01(int i, int c, List<Integer> weight, List<Integer> values, Map<String, Integer> cache) {
		if (i < 0) {
			return 0;
		}
		String key = i + ":" + c;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		int data = 0;
		if (c < weight.get(i)) {
			// 当我们的背包装不下那么多东西时，只能选择【不选】
			data = domain01(i - 1, c, weight, values, cache);
		} else {
			data = Math.max(domain01(i - 1, c, weight, values, cache), domain01(i - 1, c - weight.get(i), weight, values, cache) + values.get(i));
		}
		cache.put(key, data);
		return data;
	}
	
	/**
	 * 递推版——降低空间复杂度
	 * 要仔细思考清楚相关的初始化的设置和相关边界检查的设置
	 */
	public int zero_one_knapsackPlus(int capactity, List<Integer> weight, List<Integer> values) {
		int n = weight.size();
		// 从最后一个物品开始
		// 这里注意由于我们在做递归的时候，常常是 i 减去某个值，这样会导致负数的下标，需要对i统一向后移动一位
		int[][] data = new int[n + 1][capactity + 1];
		for (int i = 0; i < weight.size(); i++) {
			for (int w = 0; w < capactity + 1; w++) {
				if (w < weight.get(i)) {
					data[i + 1][w] = data[i][w];
				} else {
					data[i + 1][w] = Math.max(data[i][w], data[i][w - weight.get(i)] + values.get(i));
				}
			}
		}
		return data[n][capactity];
	}
}
