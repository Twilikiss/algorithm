package 数据结构与算法.queue;


/**
 * 数组实现队列模拟的代码分析
 * 此时的队列仍存在问题：目前数组使用一次就不能用， 没有达到复用的效果
 * 解决方案：改造为环形队列
 * @author mlp52
 *
 */
public class ArraysQueue {
	public static void main(String[] args) {
		queue q = new queue(30);
		
		q.addData(12);
		
		q.addData(12);
		
		q.addData(12);
		
		q.addData(12);
		
		int outNum = q.getData();
		
		System.out.println(outNum);
		
		q.showArr();
	}
}

//使用数组模拟队列---编写queue类
class queue{
	private int maxSize;//数组最大值
	private int front;//数据的头指针
	private int rear;//数据的尾指针
	private int[] arr;//模拟数组，用于存放数据
	
	//创建队列的构造器
	public queue(int arrMaxSize) {
		this.maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;//指向队列头部，分析出front是指向队列头的前一个位置
		rear = -1;//指向队列的尾部，指向队尾的最后一个数据（当前队列无数据，因此为-1）
	}
	
	//判断队列是否是满的
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear == front;//这时候的相当就可以表示队列为空，不一定都为-1
	}
	
	//添加数据到队列
	public void addData(int in) {
		//判读队列是否满
		if (isFull()) {
			System.out.println("队列已满！");
			return;
		} else {
			arr[++rear] = in;
		}
	}
	
	//删除数据（数据拿出队列）
	public int getData() {
		//判断队列是否为空
		if (isEmpty()) {
			//抛出异常
			throw new RuntimeException("队列为空，很蓝的啦");
		} else {
			front++;
			int value = arr[front];
			arr[front] = 0;
			return value;
		}
	}
	
	//显示队列的所有数据
	public void showArr() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		} else if (isFull()) {
			System.out.println("当前队列已满！数据可能不完整");
			for(int i = 0;i < rear + 1;i++) {
				System.out.printf("arr[%d] = %d\n",i,arr[i]);
			}
			return;
		} {
			
		}
		for(int i = 0;i < arr.length;i++) {
			System.out.printf("arr[%d] = %d\n",i,arr[i]);
		}
	}
}