package com.spark.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Title: DateUtil
 * Description: TODO
 *
 * @author xuf
 * @version V1.0
 * @date 2019-11-14
 */
public class DateUtil {
	
	/**
	 * 获取当前时间格式化
	 */
	public static String getNowDateDefault() {
		return getNowDateFormatter("yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 获取当前时间格式化
	 */
	public static String getNowDateFormatter(String formatter) {
		return getDateFormatter(LocalDateTime.now(), formatter);
	}
	
	/**
	 * 获取当前时间格式化
	 */
	public static String getDateFormatter(LocalDateTime date, String formatter) {
		DateTimeFormatter f = DateTimeFormatter.ofPattern(formatter);
		return date.format(f);
	}
}
