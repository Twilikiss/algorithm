package 数据结构与算法.递归;

public class 简单迷宫回溯问题 {
	public static void main(String[] args) {
		// 先创建一个二维数组来模拟迷宫
		int[][] map = new int[8][7];
		// 使用“1”表示墙
		// 先设置初始墙
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}

		// 设置左右的墙
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}

		// 设置挡板
		map[3][1] = 1;
		map[3][2] = 1;
		map[3][3] = 1;

		for (int i = 2; i < 7; i++) {
			map[5][i] = 1;
		}

		// 查看地图情况
		System.out.println("当前的地图情况：");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

		// 使用递归函数找路
		FindWayOtherWay(map, 1, 1);

		// 查看地图情况
		System.out.println("当前的地图情况：");
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	/**
	 * 使用递归的形式来给小球找路
	 * 约定：
	 * 当小球到达[6][5]则找到路
	 * map[i][j]为0表示尚未走过的地方，1表示墙，2表示道路可走，3表示该点已经走过，但走不通
	 * 在走迷宫时要确定一个策略（方法）下->右->上->左，走不通，再回溯
	 * @param map-传入二维数组模拟的地图
	 * @param (i,j)-起始位置坐标
	 * @return 找到路返回true，否则为false
	 */
	public static boolean FindWay(int[][] map,int i,int j) {
		//已经找到通路
		if(map[6][5] == 2) {
			return true;
		} 
			
		//当前这个点还没有走过
		if (map[i][j] == 0) {
			
			map[i][j] = 2; //先假定当前位置可以走通
			
			//先尝试向下走
			if (FindWay(map, i + 1, j)) {
				return true;
			} else if(FindWay(map, i, j + 1)) {//向下不通则向右走
				return true;
			} else if(FindWay(map, i - 1, j)) {//仍不通，向上走
				return true;
			} else if (FindWay(map, i, j - 1)) {
				return true;
			}else {
				map[i][j] = 3;
				return false;
			} 
		} else {//这里的map[i][j]不为0，有以下几种情况：1：墙  2；已经走过，不用反复走  3：死路，更不要走
			return false;
		}
	}
	/**
	 * 修改找路的策略（上->右 —>下->左）
	 * @param map
	 * @param i
	 * @param j
	 * @return
	 */
	public static boolean FindWayOtherWay(int[][] map,int i,int j) {
		//已经找到通路
		if(map[6][5] == 2) {
			return true;
		} 
			
		//当前这个点还没有走过
		if (map[i][j] == 0) {
			
			map[i][j] = 2; //先假定当前位置可以走通
			
			//先尝试向下走
			if (FindWay(map, i - 1, j)) {
				return true;
			} else if(FindWayOtherWay(map, i, j + 1)) {//向下不通则向右走
				return true;
			} else if(FindWayOtherWay(map, i + 1, j)) {//仍不通，向上走
				return true;
			} else if (FindWayOtherWay(map, i, j - 1)) {
				return true;
			}else {
				map[i][j] = 3;
				return false;
			} 
		} else {//这里的map[i][j]不为0，有以下几种情况：1：墙  2；已经走过，不用反复走  3：死路，更不要走
			return false;
		}
	}
}
