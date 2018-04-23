package com.tz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/***
 * 时间工具类
 * 用于创建自定义时间
 * 格式化时间
 * 把字符串时间转成java.util.Date
 * "yyyy MM dd HH MM SS LL"
 * 接受来自键盘输入
 * @author Administrato
 *
 */
public class TimeTool {

	public static Calendar create(int year,int month,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		return calendar;
	}
	
	/**
	 * 根据年 月  日 创建一个 时间
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date createDate(int year,int month,int day) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.set(year, month - 1, day);
		return create(year, month, day).getTime();
	}
	
	public static Date createDate(int year,int month,int day,int hour,int minute,int second) {
		Calendar calendar = create(year, month, day);
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);
		
		return calendar.getTime();
	}
	
	/****
	 * 把Date类型时间转成时间字符串
	 * @param date
	 * @param pattern 时间模板
	 * @return
	 */
	public static String format(Date date,String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		return dateFormat.format(date);
	}
	
	/***
	 * 以默认模板 yyyy-MM-dd 格式化时间
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		
		return format(date, "yyyy-MM-dd");
	}
	
	/***
	 * 把字符串时间重新格式化为java.util.Date类型时间
	 * @param dateStr
	 * @return
	 */
	public static Date parse(String dateStr,String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date d = null;
		try {
			d = dateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * 以默认模板  yyyy-MM-dd 格式化时间字符串
	 * @param dateStr
	 * @return
	 */
	public static Date parse(String dateStr) {
		
		return parse(dateStr, "yyyy-MM-dd");
	}
	
	/***
	 * 使用IO流接受键盘输入
	 * @return
	 */
	public static String getFromConsole() {
		String result = null;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in));
			result = reader.readLine();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
