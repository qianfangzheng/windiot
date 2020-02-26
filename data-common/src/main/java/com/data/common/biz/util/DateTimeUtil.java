package com.data.common.biz.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;


/**
 * 本类使用了joda-time包做时间转换功能
 * @author xzp
 *
 */
public class DateTimeUtil {

	private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";


	/**
	 * 将String转化为Date(自定义时间格式)
	 * @param str
	 * @return
	 */
	public static Date strToDate(String str,String formatStr) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(formatStr);
		return formatter.parseDateTime(str).toDate();
	}


	/**
	 * 将String转化为Date(默认时间格式)
	 * @param str
	 * @return
	 */
	public static Date strToDate(String str) {
		DateTimeFormatter formatter = DateTimeFormat.forPattern(DEFAULT_FORMAT);
		return formatter.parseDateTime(str).toDate();
	}

	/**
	 * 从Date转换为String(自定义格式)
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateTostr(Date date,String formatStr) {
		if (date == null) {
			return StringUtils.EMPTY;
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(formatStr);
	}


	/**
	 * 从Date转换为String(默认时间格式)
	 * @param date
	 * @param formatStr
	 * @return
	 */
	public static String DateTostr(Date date) {
		if (date == null) {
			return StringUtils.EMPTY;
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(DEFAULT_FORMAT);
	}
}
