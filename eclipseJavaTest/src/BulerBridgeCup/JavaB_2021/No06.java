package BulerBridgeCup.JavaB_2021;

import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.Scanner;

/**
 * 【问题描述】
 小蓝要和朋友合作开发一个时间显示的网站。在服务器上，朋友已经获取
 了当前的时间，用一个整数表示，值为从 1970 年 1 月 1 日 00:00:00 到当前时
 刻经过的毫秒数。
 现在，小蓝要在客户端显示出这个时间。小蓝不用显示出年月日，只需要
 显示出时分秒即可，毫秒也不用显示，直接舍去即可。
 给定一个用整数表示的时间，请将这个时间对应的时分秒输出。
 * @author mlp52
 *
 */
public class No06 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String in = scanner.nextLine();
		scanner.close();
		Date date = Date.valueOf(in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
		String outBuffer = simpleDateFormat.format(date);
		System.out.println(outBuffer);
	}
}
