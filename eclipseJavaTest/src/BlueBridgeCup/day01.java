package BlueBridgeCup;

public class day01 {

    public static void main(String[] args) {
          
    	int out = test04(4,3);
    	
    	System.out.println(out);
    }
    /**
     *递归：数组求和
     * @param args
     * @param index
     * @return
     */
    public static int test01(int[] args,int index){
        if (index == args.length - 1){
            return args[0];
        }
        return args[index] + test01(args,index + 1);
    }
    
    /**
     *递归： 字符串反转
     * @param in
     * @param end
     * @return
     */
    public static String test02(String in,int end){
    	if (end == 0) {
			return "" + in.charAt(end);
		}
    	return in.charAt(end) + test02(in, end - 1);
    }
    
    /**
     * 递归：斐波那契数列
     * @return
     */
    public static int  test03(int n) {
    	if (n == 1 || n == 2) {
			return 1;
		}
		return test03(n -1) + test03(n - 2);
	}
    /**
     * 递归：最大公约数
     */
    public static int test04(int m,int n) {
    	if (n == 0) {
			return m;
		}
    	return test04(n, m % n);
    }
}
