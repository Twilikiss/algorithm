package LeetCode;

/**
 * 代码在力扣上通过倒数第三个例子时报错
 * 在输入：
 * [2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
 * [5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
 * 
 *    输出：[7,0,8,4,8,6,4,2,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,1,4,3,9,1]
预期结果：[7,0,8,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,1,4,3,9,1]
 */
import java.math.BigDecimal;


public class 两数相加 {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(2);
		ListNode h2 = new ListNode(4);
		ListNode h3 = new ListNode(3);
		ListNode h4 = new ListNode(2);
		ListNode h5 = new ListNode(4);
		ListNode h6 = new ListNode(3);
		ListNode h7 = new ListNode(2);
		ListNode h8 = new ListNode(4);
		ListNode h9 = new ListNode(3);
		ListNode h10 = new ListNode(2);
		ListNode h11 = new ListNode(4);
		ListNode h12 = new ListNode(3);
		ListNode h13 = new ListNode(2);
		ListNode h14 = new ListNode(4);
		ListNode h15 = new ListNode(3);
		ListNode h16 = new ListNode(2);
		ListNode h17 = new ListNode(4);
		ListNode h18 = new ListNode(3);
		ListNode h19 = new ListNode(2);
		ListNode h20 = new ListNode(4);
		ListNode h21 = new ListNode(3);
		ListNode h22 = new ListNode(2);
		ListNode h23 = new ListNode(4);
		ListNode h24 = new ListNode(3);
		ListNode h25 = new ListNode(2);
		ListNode h26 = new ListNode(4);
		ListNode h27 = new ListNode(3);
		ListNode h28 = new ListNode(2);
		ListNode h29 = new ListNode(4);
		ListNode h30 = new ListNode(3);
		ListNode h31 = new ListNode(2);
		ListNode h32 = new ListNode(4);
		ListNode h33 = new ListNode(3);
		ListNode h34 = new ListNode(2);
		ListNode h35 = new ListNode(4);
		ListNode h36 = new ListNode(3);
		ListNode h37 = new ListNode(2);
		ListNode h38 = new ListNode(4);
		ListNode h39 = new ListNode(3);
		ListNode h40 = new ListNode(2);
		ListNode h41 = new ListNode(4);
		ListNode h42 = new ListNode(3);
		ListNode h43 = new ListNode(2);
		ListNode h44 = new ListNode(4);
		ListNode h45 = new ListNode(3);
		ListNode h46 = new ListNode(2);
		ListNode h47 = new ListNode(4);
		ListNode h48 = new ListNode(3);
		ListNode h49 = new ListNode(2);
		ListNode h50 = new ListNode(4);
		ListNode h51 = new ListNode(3);
		ListNode h52 = new ListNode(2);
		ListNode h53 = new ListNode(4);
		ListNode h54 = new ListNode(3);
		ListNode h55 = new ListNode(2);
		ListNode h56 = new ListNode(4);
		ListNode h57 = new ListNode(3);
		ListNode h58 = new ListNode(2);
		ListNode h59 = new ListNode(4);
		ListNode h60 = new ListNode(3);
		ListNode h61 = new ListNode(9);
		
		
		
		    h1.next = h2;
	        h2.next = h3;
	        h3.next = h4;
	        h4.next = h5;
	        h5.next = h6;
	        h6.next = h7;
	        h7.next = h8;
	        h8.next = h9;
	        h9.next = h10;
	        h10.next = h11;
	        h11.next = h12;
	        h12.next = h13;
	        h13.next = h14;
	        h14.next = h15;
	        h15.next = h16;
	        h16.next = h17;
	        h17.next = h18;
	        h18.next = h19;
	        h19.next = h20;
	        h20.next = h21;
	        h21.next = h22;
	        h22.next = h23;
	        h23.next = h24;
	        h24.next = h25;
	        h25.next = h26;
	        h26.next = h27;
	        h27.next = h28;
	        h28.next = h29;
	        h29.next = h30;
	        h30.next = h31;
	        h31.next = h32;
	        h32.next = h33;
	        h33.next = h34;
	        h34.next = h35;
	        h35.next = h36;
	        h36.next = h37;
	        h37.next = h38;
	        h38.next = h39;
	        h39.next = h40;
	        h40.next = h41;
	        h41.next = h42;
	        h42.next = h43;
	        h43.next = h44;
	        h44.next = h45;
	        h45.next = h46;
	        h46.next = h47;
	        h47.next = h48;
	        h48.next = h49;
	        h49.next = h50;
	        h50.next = h51;
	        h51.next = h52;
	        h52.next = h53;
	        h53.next = h54;
	        h54.next = h55;
	        h55.next = h56;
	        h56.next = h57;
	        h57.next = h58;
	        h58.next = h59;
	        h59.next = h60;
	        h61.next = null;
	
		
		h1.next = null;
		
		//[2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
		//[5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(2);
		ListNode l8 = new ListNode(4);
		ListNode l9 = new ListNode(3);
		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);
		ListNode l13 = new ListNode(2);
		ListNode l14 = new ListNode(4);
		ListNode l15 = new ListNode(3);
		ListNode l16 = new ListNode(2);
		ListNode l17 = new ListNode(4);
		ListNode l18 = new ListNode(3);
		ListNode l19 = new ListNode(2);
		ListNode l20 = new ListNode(4);
		ListNode l21 = new ListNode(3);
		ListNode l22 = new ListNode(2);
		ListNode l23 = new ListNode(4);
		ListNode l24 = new ListNode(3);
		ListNode l25 = new ListNode(2);
		ListNode l26 = new ListNode(4);
		ListNode l27 = new ListNode(3);
		ListNode l28 = new ListNode(2);
		ListNode l29 = new ListNode(4);
		ListNode l30 = new ListNode(3);
		ListNode l31 = new ListNode(2);
		ListNode l32 = new ListNode(4);
		ListNode l33 = new ListNode(3);
		ListNode l34 = new ListNode(2);
		ListNode l35 = new ListNode(4);
		ListNode l36 = new ListNode(3);
		ListNode l37 = new ListNode(2);
		ListNode l38 = new ListNode(4);
		ListNode l39 = new ListNode(3);
		ListNode l40 = new ListNode(2);
		ListNode l41 = new ListNode(4);
		ListNode l42 = new ListNode(3);
		ListNode l43 = new ListNode(2);
		ListNode l44 = new ListNode(4);
		ListNode l45 = new ListNode(3);
		ListNode l46 = new ListNode(2);
		ListNode l47 = new ListNode(4);
		ListNode l48 = new ListNode(3);
		ListNode l49 = new ListNode(2);
		ListNode l50 = new ListNode(4);
		ListNode l51 = new ListNode(3);
		ListNode l52 = new ListNode(2);
		ListNode l53 = new ListNode(4);
		ListNode l54 = new ListNode(3);
		ListNode l55 = new ListNode(2);
		ListNode l56 = new ListNode(4);
		ListNode l57 = new ListNode(3);
		ListNode l58 = new ListNode(2);
		ListNode l59 = new ListNode(4);
		ListNode l60 = new ListNode(3);
		ListNode l61 = new ListNode(9);
		
		
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = l10;
		l10.next = l11;
		l11.next = l12;
		l12.next = l13;
		l13.next = l14;
		l14.next = l15;
		l15.next = l16;
		l16.next = l17;
		l17.next = l18;
		l18.next = l19;
		l19.next = l20;
		l20.next = l21;
		l21.next = l22;
		l22.next = l23;
		l23.next = l24;
		l24.next = l25;
		l25.next = l26;
		l26.next = l27;
		l27.next = l28;
		l28.next = l29;
		l29.next = l30;
		l30.next = l31;
		l31.next = l32;
		l32.next = l33;
		l33.next = l34;
		l34.next = l35;
		l35.next = l36;
		l36.next = l37;
		l37.next = l38;
		l38.next = l39;
		l39.next = l40;
		l40.next = l41;
		l41.next = l42;
		l42.next = l43;
		l43.next = l44;
		l44.next = l45;
		l45.next = l46;
		l46.next = l47;
		l47.next = l48;
		l48.next = l49;
		l49.next = l50;
		l50.next = l51;
		l51.next = l52;
		l52.next = l53;
		l53.next = l54;
		l54.next = l55;
		l55.next = l56;
		l56.next = l57;
		l57.next = l58;
		l58.next = l59;
		l59.next = l60;
		l61.next = null;
		
		ListNode o1 = addTwoNumbers(h1, l1);
		
		System.out.println(o1.val);
		
		System.out.println(o1.next.val);
		
		System.out.println(o1.next.next.val);
		
		System.out.println(o1.next.next.next.val);
		
		System.out.println(o1.next.next.next.next.next.next.next.next.val);
		
	}
	  //Definition for singly-linked list.
	 
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		  ListNode tempListNode01 = l1;
		  
		  ListNode tempListNode02 = l2;
		  
		  int total01 = 1;
		  
		  int total02 = 1;
		  
		  BigDecimal number01 = BigDecimal.ZERO;
		  
		  BigDecimal number02 = BigDecimal.ZERO;
		  while(tempListNode01.next != null) {
			  tempListNode01 = tempListNode01.next;
			  total01 ++;
		  }
		  
		  while(tempListNode02.next != null) {
			  tempListNode02 = tempListNode02.next;
			  total02 ++;
		  }
		 
		  for(int i = 0;i < total01;i++) { 
			  int row =  total01 - i - 1;
			  tempListNode01 = l1;
			  for(int k = total01 - i - 1;k > 0;k--) {
				 tempListNode01 = tempListNode01.next; 
			  }
			  number01 = number01.add(BigDecimal.valueOf(tempListNode01.val).multiply(BigDecimal.valueOf(Math.pow(10, row)))) ;
		  }

		  for(int i = 0;i < total02;i++) { 
			  int row = total02 - i - 1;
			  tempListNode02 = l2;
			  for(int k = total02 - i - 1;k > 0;k--) {
				 tempListNode02 = tempListNode02.next; 
			  }
			  number02 = number02.add(BigDecimal.valueOf(tempListNode02.val).multiply(BigDecimal.valueOf(Math.pow(10, row)))) ;
		  }
		  
		  	BigDecimal anwer = number01.add(number02);
		  
		  String string = anwer.toString().substring(0,anwer.toString().length() - 2);
		  
		  System.out.println(string);
		  
		  int values = Integer.parseInt(String.valueOf(string.charAt(string.length() - 1)));
		  
		  ListNode listNode = new ListNode(values);
		  
		  ListNode temp = listNode;
		  
		 for(int i = string.length() -  2;i >= 0;i--) {
			
				ListNode xListNode =new ListNode(Integer.parseInt(String.valueOf(string.charAt(i))));
				temp.next = xListNode;
				
				temp = xListNode;
			if (i == string.length()) {
				temp.next = null;	 
			}
			 
		 }
		 
		 return listNode;
		 
	   
	}
	  
}
class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }