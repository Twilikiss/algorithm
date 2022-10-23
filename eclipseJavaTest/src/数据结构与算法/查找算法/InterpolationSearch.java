package 数据结构与算法.查找算法;

import java.util.ArrayList;

/**
 * 插值查找算法
 * 是在二分查找上面进行改进，仍然要求数组是有序的，在原来二分查找的基础上，利用如下的数学公式优化mid，使得mid更加接近目标值
 * int mid = left + (right – left) * (findVal – arr[left]) / (arr[right] – arr[left])
 * 适用于数据量大，数据分布比较均匀，不均匀时不一定比二分好
 * @author mlp52
 *
 */
public class InterpolationSearch {
	public static void main(String[] args) {
		int[] arrays = new int[100];
		for(int i = 0;i < 100;i++) {
			arrays[i] = i;
		}
		arrays[2] = 1;
		arrays = new int[]{1,8,10,89,1000,1000,1000,1234};
		ArrayList<Integer> insertSearch = InsertSearch(arrays, 0, arrays.length - 1, 1000);
		
		System.out.println("所要搜索的目标下标为 ： " + insertSearch.toString());
	}
	
	//编写插值查找的方法
	/**
	 * 
	 * @param inNumbers  数组
	 * @param left		左边索引
	 * @param right		右边索引
	 * @param findValue	目标值
	 * @return 返回目标值的数组下标
	 */
	public static ArrayList<Integer> InsertSearch(int[] inNumbers,int left,int right,int findValue) {
		//退出条件不能少，缺一不可，否则会导致数组角标越界！！！
		if(left > right || findValue > inNumbers[inNumbers.length - 1] || findValue < inNumbers[0]) {
			return new ArrayList<>();
		}
		System.out.println("X");
		int mid = left + (right - left) * (findValue - inNumbers[left]) / (inNumbers[right] - inNumbers[left]);
		int midValue = inNumbers[mid];
		if (findValue < midValue) {// 向左递归
			return InsertSearch(inNumbers, left, mid - 1, findValue);
		} else if(findValue > midValue) {
			return InsertSearch(inNumbers, mid + 1, right, findValue);
		} else {
			//当我们找到对应的元素时，其左右均可能存在
			ArrayList<Integer> arrayList = new ArrayList<>();
			//向左遍历
			int temp = mid - 1;
			while(true) {
				if(temp < left || inNumbers[temp] != midValue) {
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
				if(temp > right || inNumbers[temp] != midValue) {
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
