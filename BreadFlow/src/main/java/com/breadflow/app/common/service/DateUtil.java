package com.breadflow.app.common.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	private static String DATE_FORMAT = "yyyyMMdd";
	private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
	
    /*생성자 사용하지 못하도록*/
	public DateUtil () {}
	
	/*오늘일자*/
	public static String getDay() {
		Calendar cal = Calendar.getInstance();
		return sdf.format(cal.getTime());
	}
	/*내일*/
	public static String getNextDay() {
		return afterDay(getDay(), 1);
	}
	/*일자 더하기*/
	public static String afterDay(String bseDt, int addDay) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, addDay);
		return sdf.format(cal.getTime());
	}
	/*월 더하기*/
	public static String afterMonthDay(String bseDt, int addMonth) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, addMonth);
		return sdf.format(cal.getTime());
	}
	/*월 초일*/
	public static String firstDayOfMonth(String bseDt) {
		Calendar cal = getCalendar(bseDt);
		cal.set(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		
		return sdf.format(cal.getTime());
	}
	/*월 말일*/
	public static String lastDayOfMonth(String bseDt) {
		Calendar cal = getCalendar(bseDt);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return sdf.format(cal.getTime());
	}
	/*전월 말일*/
	public static String beforeMonthLastDay(String bseDt) {
		String beforeMonthBseDt = afterMonthDay(bseDt, -1);
		Calendar cal = getCalendar(beforeMonthBseDt);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return sdf.format(cal.getTime());
	}
	/*다음달 말일*/
	public static String afterMonthLastDay(String bseDt) {
		String afterMonthBseDt = afterMonthDay(bseDt, 1);
		Calendar cal = getCalendar(afterMonthBseDt);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return sdf.format(cal.getTime());
	}
	/*년 초일*/
	public static String firstDayOfYear(String bseDt) {
		Calendar cal = getCalendar(bseDt.substring(0, 4), "01", "01");
		return sdf.format(cal.getTime());
	}
	/*년 말일*/
	public static String LastDayOfYear(String bseDt) {
		Calendar cal = getCalendar(bseDt.substring(0, 4), "12", "31");
		return sdf.format(cal.getTime());
	}
	/*윤년 체크*/
	public static boolean leapYearCheck(String bseDt) {
		Calendar cal = getCalendar(bseDt.substring(0, 4), "02", "01");
		if(cal.getActualMaximum(Calendar.DAY_OF_MONTH) == 29) {
			return true;
		}else {
			return false;
		}
	}
	/*- format*/
	public static String dashFormat(String bseDt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = getCalendar(bseDt);

		return sdf.format(cal.getTime());
	}

	private static Calendar getCalendar(String year, String month, String day) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(year));
		cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(day));
		return cal;
	}
	
	private static Calendar getCalendar(String bseDt) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, Integer.parseInt(bseDt.substring(0, 4)));
		cal.set(Calendar.MONTH, Integer.parseInt(bseDt.substring(4, 6)) - 1);
		cal.set(Calendar.DATE, Integer.parseInt(bseDt.substring(6, 8)));
		return cal;
	}
}
