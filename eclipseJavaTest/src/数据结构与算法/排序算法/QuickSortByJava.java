package 数据结构与算法.排序算法;

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 *
 */
public class QuickSortByJava {
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static void subSort(int[] data, int start, int end) {
        if (start < end) {
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true) {
                while (low < end && data[++low] - base <= 0) ;
                while (high > start && data[--high] - base >= 0) ;
                if (low < high) {
                    swap(data, low, high);
                } else {
                    break;
                }
            }
            swap(data, start, high); // 这里的high在"data[--high]处减过1了",不会出现角标越界的错误
            subSort(data, start, high - 1);//递归调用
            subSort(data, high + 1, end);
        }
    }

    public static void quickSort(int[] data) {
        subSort(data, 0, data.length - 1);
    }


    public static void main(String[] args) {
    	int[] arrays = new int[80000];
		for(int i = 0; i < 80000;i++) {
			arrays[i] = (int)(Math.random() * 8000000); //生成一个[0, 8000000) 数
			}
        long start = System.currentTimeMillis();
        quickSort(arrays);
        long end = System.currentTimeMillis();
        System.out.println("排序耗时为 ：" + (end - start) + "毫秒");
    }
}
