package 数据结构与算法练习.queue;

/**
 * 模拟环形数列，解决原来模拟队列存在的弊端
 * 对于不太理解的，结合环形队列的示意图来去理解
 * 
 * @author mlp52
 *
 */
public class ArrayQueueWithAnnular {
	public static void main(String[] args) {
		QueueWithAnnular queueWithAnnular = new QueueWithAnnular(10);
		
		queueWithAnnular.addData(10);
		queueWithAnnular.addData(11);
		queueWithAnnular.addData(12);
		queueWithAnnular.addData(13);
		queueWithAnnular.addData(14);
		
		System.out.println(queueWithAnnular.getData());
		
		queueWithAnnular.showArr();
	}
}

class QueueWithAnnular {
	private int front = 0;// 这里的front不再是数组的第一项的前一个位置，而是指向数组的第一个位置
	private int rear = 0;// 这里的rear的值是数组最后一个的元素的后一位，我们把它留作保留空间，不存放数值，即rear的最大值为maxSize-1
	private int arrMaxSize;
	private int[] arr;

	public QueueWithAnnular(int maxSize) {
		arrMaxSize = maxSize;
		arr = new int[arrMaxSize];
	}

	public boolean isFull() {
		// 通过取模的方式来模拟环形数组来确定是否是满的
		return (rear + 1) % arrMaxSize == front;
	}

	public boolean isEmpty() {
		// 如果rear指向预留空间，那么就是满的，如果指向预留空间的下一位，在环形数组里就是rear=front，即数组为空
		return rear == front;
	}

	public void addData(int inData) {
		if (isFull()) {
			System.out.println("队列已满！");
			return;
		}

		arr[rear] = inData;

		// 此时rear要往后移，但是不能简单的rear++，这样会导致角标越界，因此这里加上取模来实现
		rear = (rear + 1) % arrMaxSize;
	}

	// 删除数据（数据拿出队列）
	public int getData() {
		// 判断队列是否为空
		if (isEmpty()) {
			// 抛出异常
			throw new RuntimeException("队列为空，很蓝的啦");
		}

		// 这里的front的值是队列的第一个元素
		int value = arr[front];

		// 此时front要往后移，但是不能简单的front++，这样会导致角标越界，因此这里加上取模来实现
		front = (front + 1) % arrMaxSize;

		return value;
	}
	
	public void showArr() {
		if (isEmpty()) {
			System.out.println("队列为空");
			return;
		} 
		
		//值得注意的是数据的个数=(rear-front+arrMaxSize) % arrMaxSize
		int total = (rear - front + arrMaxSize) % arrMaxSize;
		for(int i = front;i < front + total;i++) {
			System.out.printf("arr[%d] = %d\n",i % arrMaxSize,arr[i % arrMaxSize]);
		}
	}
	
	//求当前的数组的有效数据的个数
	public int getTotal() {
		return (rear - front + arrMaxSize) % arrMaxSize;
	}
}
