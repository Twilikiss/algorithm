package BlueBridgeCup;

import java.math.BigDecimal;

/**
  * 黄金分割数（数学归纳法得出黄金分割数本质仍然是斐波那契数列的变形）
  * ps:还考查了关于BigDecimal的使用
 * @author mlp52
 *
 */
public class day02_03 {

	public static void main(String[] args) {

		BigDecimal a = new BigDecimal("1");
	    BigDecimal b = new BigDecimal("1");
	    for (int i = 3; i < 10000; i++) {
	    	BigDecimal t = b;
	    	b = a.add(b);
	    	a = t;
		}
	    
	    BigDecimal out = a.divide(b,101,BigDecimal.ROUND_HALF_UP);
	    System.out.println(out);
				
	}

}
