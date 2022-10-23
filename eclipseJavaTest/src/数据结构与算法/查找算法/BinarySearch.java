package 数据结构与算法.查找算法;

import java.util.ArrayList;

/**
 * 二分查找——递归实现
 * 要注意递归退出的条件！！！
 * @author mlp52
 *
 */
public class BinarySearch {
	public static void main(String[] args) {
		int[] arrays = new int[] {1,2,3,4,5,6,7,8,9};
		int out = binarySearch(arrays, 0, arrays.length - 1, 1);
		System.out.println(out);
		arrays = new int[]{1,8,10,89,1000,1000,1000,1234};
		ArrayList<Integer> list = binarySearchByMore(arrays, 0, arrays.length - 1, 1000);
		System.out.println(list.toString());
	}
	
	//二分查找
	/**
	 * 
	 * @param inNumbers 原数组
	 * @param left  左指针
	 * @param right 右指针
	 * @param value 要查找的值
	 * @return
	 */
	public static int binarySearch(int[] inNumbers,int left,int right,int value) {
		//设置递归退出条件
		if (left > right) {
			return -1;
		}
		System.out.println("X");
		int mid = (left + right) / 2;
		int midval = inNumbers[mid];
		
		if (value < midval) {// 向左递归
			return binarySearch(inNumbers, left, mid - 1, value);
		} else if(value > midval) {
			return binarySearch(inNumbers, mid + 1, right, value);
		} else {
			return mid;
		}
	}
	
	//如果题目要求找到所有的结果呢？
	//例如int[] arrays = {1,8,10,89,1000,1000,1234};返回所有满足值为1000的数组下标
	public static ArrayList<Integer> binarySearchByMore(int[] inNumbers,int left,int right,int value) {
		//设置递归退出条件
		if (left > right) {
			return new ArrayList<>();
		}
		int mid = (left + right) / 2;
		int midval = inNumbers[mid];
		
		if (value < midval) {// 向左递归
			return binarySearchByMore(inNumbers, left, mid - 1, value);
		} else if(value > midval) {
			return binarySearchByMore(inNumbers, mid + 1, right, value);
		} else {
			//当我们找到对应的元素时，其左右均可能存在
			ArrayList<Integer> arrayList = new ArrayList<>();
			//向左遍历
			int temp = mid - 1;
			while(true) {
				if(temp < left || inNumbers[temp] != midval) {
					break;
				}
				//否则就将temp加入到链表中
				arrayList.add(temp);
				temp--;
			}
			
			arrayList.add(mid); // 不要忘记将mid本身放进ArrayList中
			
			//向右遍历
			temp = mid + 1;
			while(true) {
				if(temp > right || inNumbers[temp] != midval) {
					break;
				}
				//否则就将temp加入到链表中
				arrayList.add(temp);
				temp++;
			}
			return arrayList;
		}
	}
}
