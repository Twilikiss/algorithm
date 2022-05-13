package LeetCode;

import java.math.BigDecimal;


public class 两数相加 {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(9);
	
		
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