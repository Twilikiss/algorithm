package 数据结构与算法.查找算法;
//线性查找
public class SeqSearch {
	public static void main(String[] args) {
		int[] arrays = new int[] {1,28,20,77,6,3,45,69,27};
		int index = Search(arrays, 20);
		if (index == -1) {
			System.out.println("找不到对应的值！");
		}else {
			System.out.println("所要找的值的位置为 ： " + index);
		}
	}
	
	public static int Search(int[] inNumbers,int value) {
		for (int i = 0; i < inNumbers.length; i++) {
			if (value == inNumbers[i]) {
				return i;
			}
		}
		return -1;
	}
}
