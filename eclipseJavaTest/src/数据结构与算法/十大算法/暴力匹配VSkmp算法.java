package 数据结构与算法.十大算法;

import java.util.Arrays;

/**
 * 本节我们重点介绍一种优雅的算法——KMP算法
 * @author mlp52
 *
 */
public class 暴力匹配VSkmp算法 {
	public static void main(String[] args) {
//		System.out.println(ViolentMatch("abcdefg", "de"));
		System.out.println(Arrays.toString(KMPNext("AABCAAAD")));
	}
	//模拟暴力匹配法
	public static int ViolentMatch(String source,String target){
		int index = 0;
		int i = 0;
		while (index < source.length()){
			char a = target.charAt(i);
			char b = source.charAt(index);
			if (a != b){
				index++;
				i = 0;
			} else {
				if (i == target.length() - 1){
					return index - target.length() + 1;
				} else {
					index++;
					i++;
				}
			}
		}
		return -1;
	}

	public static int KMP(String source,String target){
		return -1;
	}
	public static int[] KMPNext(String target){
		int[] next = new int[target.length()];
		for (int i = 1, j = 0;i < target.length();i++){
			if (j > 0 && target.charAt(i) != target.charAt(j)){
				j = next[j - 1];
			}
			if (target.charAt(i) == target.charAt(j)){
				j++;
			}
			next[i] = j;
		}
		return next;
	}
}
