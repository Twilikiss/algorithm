package BulerBridgeCup;
/**
  * 递归求解：汉诺塔(重点掌握递归处理常规问题不能解决的问题的思想)
  * 思路：目标：将1到N从A到B，C为辅助盘<—— ——
  * 一：将1到1-N从A移动C，B为辅助盘                      |(递归回去） 
  * 二：将N从A移动到B                        |                     
  * 三：将1到N-1从C移动到A，B为辅助盘----------
  * 汉诺塔的主要的想法是始终将最后一个之前的盘移动到辅助盘上，将最后一个放置在目标盘（这里的最后一个是相对的，指的是一个部分的最后一个）
 * @author mlp520
 *
 */
public class day02_02 {
	public static void main(String[] args) {
	 test01(3, "A", "B", "C");
	}
	
	public static void test01(int total,String from,String to,String help) {
		if (total == 1) {
			System.out.println("move" + total + "from" + from + "to" + to);
			return;
		}
		
		test01(total - 1, from, help, to);
		System.out.println("move" + total + "from" + from + "to" + to);
		test01(total - 1, help,to , from);
		
	}
}
