package 数据结构与算法.递归;

/**
 * 递归的应用实例——八皇后问题，是回溯算法的经典案例
 * 注意本题目的摆放顺序是一行一行进行摆的，而不是一列一列
 * 本次求解八皇后问题使用的是一维数组
 * @author mlp52
 */
public class 八皇后问题 {
	//统计摆放方法的次数
	private int count = 0;
	
	//统计判断次数
	private long judgeCount = 0;
	
	//定义一个max表示有多少个皇后
	private int max = 8;
	//定义数组 array, 保存皇后放置位置的结果,最多放max，比如 arr = {0 , 4, 7, 5, 2, 6, 1, 3}
	private int[] array = new int[max];
	
	public static void main(String[] args) {
		八皇后问题 queeen = new 八皇后问题();
		queeen.check(0);
		System.out.println("************结果统计***************");
		System.out.println("一共有 ：" + queeen.count + " 种解法");
		System.out.println("一共判断了 ：" + queeen.judgeCount + " 次");
	}
	
	//编写一个方法来放置第n个皇后
	private void check(int n) {
		if (n == max) {//完成所有的放置
			showQueen();
			return;
		}
		//依次放入皇后并防止冲突
		for(int i = 0;i < max;i++) {
			//先把当前这个皇后n放到该行的第i列
			array[n] = i;
			//判断当放置第n个皇后到第i列时，是否冲突
			if (judge(n)) {// true为不冲突,false则为冲突，会回到array[n] = i的这个地方
				//接着放第n + 1个皇后（此处开始递归）
				check(n + 1);
			}
		}
	}
	
	//查看当我们放置了第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
	//这里的n代表第n个皇后
	private boolean judge(int n) {
		judgeCount ++;
		for(int i = 0;i < n;i++) {
			//如果两者处于同一列或者同一斜线(通过行差【n-i】=列差【array[i] - array[n]】来判断)
			//同一行这种情况在一维数组中不存在（n在递增）
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[i] - array[n])) {
				return false;
			}
		}
		return true;
	}
	
	//定义一个方法，可以将皇后摆放的位置输出
	private void showQueen() {
		count ++;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
