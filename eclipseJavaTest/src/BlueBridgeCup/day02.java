package BlueBridgeCup;

public class day02 {
	public static void main(String[] args) {
		
	         //二分法查找：(熟悉)
			//前提：所要查找的数组必须有序。
			int[] arr2 = new int[]{-98,-34,2,34,54,66,79,105,210,333};
			
			int dest1 = -34;
			//dest1 = 35;
			int head = 0;//初始的首索引
			int end = arr2.length - 1;//初始的末索引
			boolean isFlag1 = true;
			while(head <= end){
				
				int middle = (head + end)/2;
				
				if(dest1 == arr2[middle]){
					System.out.println("找到了指定的元素，位置为：" + middle);
					isFlag1 = false;
					break;
				}else if(arr2[middle] > dest1){
					end = middle - 1;
				}else{//arr2[middle] < dest1
					head = middle + 1;
				}
				
			}
			if(isFlag1){
				System.out.println("很遗憾，没有找到的啦！");
			}
			
			
		}

}
