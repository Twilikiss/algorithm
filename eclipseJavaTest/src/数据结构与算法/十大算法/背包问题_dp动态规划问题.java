package 数据结构与算法.十大算法;


/**
 * 动态规划的思想——以背包问题为例
 * 
 * @author mlp52
 *
 */
public class 背包问题_dp动态规划问题 {
	public static void main(String[] args) {
	
		int[] w = {1,4,3}; //物品的重量
		int[] v = {1500,3000,2000};	//物品对应的价值
		
		int maxWeight = 4; // 背包的最大重量
		// maxValuep[i][j]表示前i个商品能装进容量为j的背包的最大值,
		int[][] maxValue = new int[v.length + 1][maxWeight + 1];

		//初始化第一列和第一行
		for (int i = 0; i < v.length; i++) {
			maxValue[i][0] = 0;
		}
		for (int i = 0; i < maxWeight; i++) {
			maxValue[0][i] = 0;
		}
		
		//动态规划
		for (int i = 1; i < maxValue.length; i++) {
			for (int j = 1; j < maxValue[i].length; j++) {
				if (w[i - 1] > j) {
					maxValue[i][j] = maxValue[i - 1][j];
				} else {
//					maxValue[i][j] = Math.max(maxValue[i - 1][j], v[i - 1] + maxValue[i - 1][j - w[i - 1]]);
					if (maxValue[i - 1][j] < v[i - 1] + maxValue[i - 1][j - w[i - 1]]) {
						maxValue[i][j] = v[i - 1] + maxValue[i - 1][j - w[i - 1]];
					} else {
						maxValue[i][j] = maxValue[i - 1][j];
					}
				}
			}
		}
		//查看当前的maxValue的情况
		for (int i = 0; i < maxValue.length; i++) {
			for (int j = 0; j < maxValue[i].length; j++) {
				System.out.print(maxValue[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(maxValue[maxValue.length - 1][maxValue[0].length - 1]);
	}
}
