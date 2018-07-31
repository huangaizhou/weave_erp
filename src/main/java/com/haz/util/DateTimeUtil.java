package com.haz.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间转化工具类
 */
public class DateTimeUtil {

	public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String LONG_FORMAT = "yyyyMMddHHmmssSS";
	public static final String SHORT_FORMAT = "yyyyMMdd";
	public static final String SMALL_FORMAT = "yyMMdd";

	public static Date strToDate(String dateTimeStr, String formatStr) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
		return dateTime.toDate();
	}

	public static String dateToStr(Date date, String formatStr) {
		if (null == date) {
			return StringUtils.EMPTY;
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(formatStr);
	}

	public static Date strToDate(String dateTimeStr) {
		if (StringUtils.isBlank(dateTimeStr)) {
			return null;
		}
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
		DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
		return dateTime.toDate();
	}

	public static String dateToStr(Date date) {
		if (null == date) {
			return StringUtils.EMPTY;
		}
		DateTime dateTime = new DateTime(date);
		return dateTime.toString(STANDARD_FORMAT);
	}

	/**
	 * 计算当日0点
	 *
	 * @param date
	 * @return
	 */
	public static Date getDayStartTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 计算当月第一天0点
	 *
	 * @param date
	 * @return
	 */
	public static Date getMonthStartTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 判断两个Date是否在同一天
	 * 
	 * @Title: inSameDay
	 * @param Date1
	 * @param Date2
	 * @return
	 */
	public static boolean inSameDay(Date Date1, Date Date2) {
		if (Date1 != null && Date2 != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(Date1);
			int year1 = calendar.get(Calendar.YEAR);
			int day1 = calendar.get(Calendar.DAY_OF_YEAR);

			calendar.setTime(Date2);
			int year2 = calendar.get(Calendar.YEAR);
			int day2 = calendar.get(Calendar.DAY_OF_YEAR);

			if ((year1 == year2) && (day1 == day2)) {
				return true;
			}
			return false;
		} else {
			throw new IllegalArgumentException("The date must not be null");
		}
	}

	/**
	 * 指定时间推移前(后)几天
	 * 
	 * @param date
	 *            时间
	 * @param amount
	 *            几天
	 * @return
	 */
	public static Date computeWithDay(Date date, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, amount);
		return cal.getTime();
	}

}
