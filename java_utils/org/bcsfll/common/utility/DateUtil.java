package org.bcsfll.common.utility;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 时间处理工具类
 * @author tone
 *
 */
public class DateUtil {
	
	private static String LONG_TIME = "yyyy-MM-dd HH:mm:ss";
	private static String SHORT_TIME = "yyyy-MM-dd";
	public static long ONE_DAY_SECONDS = 86400L;
	private static final String[] week={"星期日","星期一","星期日二","星期三","星期四","星期五","星期六"};
	/**
	 * 格式化Date类型 
	 * @param date
	 * @return yyyy-MM-dd HH:mm:ss 格式时间
	 */
	public static String formatLongtime(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat(LONG_TIME);
        return format.format(date);
    }
	/**
	 * 格式化Date类型 
	 * @param date
	 * @return yyyy-MM-dd 格式时间
	 */
    public static String formatShortTime(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat(SHORT_TIME);
        return format.format(date);
    }
    /**
     * 返回时间差
     * @param one
     * @param two
     * @return
     */
    public static long getDiffDays(Date one, Date two)
    {
        Calendar sysDate = new GregorianCalendar();
        sysDate.setTime(one);
        Calendar failDate = new GregorianCalendar();
        failDate.setTime(two);
        return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 86400000L;
    }
    /**
     * 计算增加天数
     * @param date
     * @param days
     * @return
     */
    public static Date addDays(Date date, long days)
    {
        return addSeconds(date, days * ONE_DAY_SECONDS);
    }
    /**
     * 增加描述
     * @param date
     * @param secs
     * @return
     */
    public static Date addSeconds(Date date, long secs)
    {
        return new Date(date.getTime() + secs * 1000L);
    }
    /**
     * 字符串实例化为date对象
     * @param p_date
     * @return
     */
    public static Date parseShortDate(String p_date)
    {
        SimpleDateFormat format = new SimpleDateFormat(SHORT_TIME);
        try {
			return format.parse(p_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
       
       
    }
    /**
     * 字符串实例化为date对象
     * @param p_date
     * @return
     */
    public static Date parseLongDate(String p_date)
    {
        SimpleDateFormat format = new SimpleDateFormat(LONG_TIME);
        try {
			return format.parse(p_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
    }
    /**
     * 格式化为时间戳形式
     * @param p_date
     * @return
     */
    public static String formatLongestDate(Date p_date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(p_date);
        
      
    }
    /**
     * 格式化时间戳
     * @param date
     * @return
     */
    public static Timestamp formatTimestamp(Date date){
        return  Timestamp.valueOf(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
      }
    /**
     * 获取当前日期的前一个月
     * @return
     */
    public static String getBeforeMonth(){
	    
	    
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    int month = calendar.get(Calendar.MONTH);
	   
	    calendar.set(Calendar.MONTH, month - 1);

	    return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取制定日期的钱一个月
     * @param date
     * @return
     */
    public static String getBeforeMonth(Date date){
	    
	    
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMM");
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    int month = calendar.get(Calendar.MONTH);
	   
	    calendar.set(Calendar.MONTH, month - 1);

	    return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取当前日期的前一天
     * @return
     */
    public static String getBeforeDay(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    int day = calendar.get(Calendar.DATE);
	   
	    calendar.set(Calendar.DATE, day - 1);

	    return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取制定日期的前一天
     * @param date
     * @return
     */
    public static String getBeforeDay(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    int day = calendar.get(Calendar.DATE);
	   
	    calendar.set(Calendar.DATE, day - 1);
	    
	    return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取当前日期的前一年
     * @return
     */
    public static String getBeforeYear(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    int year = calendar.get(Calendar.YEAR);
	   
	    calendar.set(Calendar.YEAR, year - 1);
	    
	    return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取指定日期的前一年
     * @param date
     * @return
     */
    public static String getBeforeYear(Date date){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    int year = calendar.get(Calendar.YEAR);
	   
	    calendar.set(Calendar.YEAR, year - 1);
	    
	    return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取当前月份
     * @return
     */
    public static String getMonth() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		Calendar calendar = Calendar.getInstance();

		return simpleDateFormat.format(calendar.getTime());
	}
    /**
     * 获取指定日期的月份字符串
     * @param date
     * @return
     */
    public static String getMonth(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		

		return simpleDateFormat.format(date);
	}
    /**
     * 获取本月第一天
     * @return
     */
    public static String getFirstDay() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
	
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return simpleDateFormat.format(calendar.getTime());
	}
    
    /**
     * 获取上个月第一天
     * @return
     */
	public static String getBeforeMonthFirstDay() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		return simpleDateFormat.format(calendar.getTime());
	}
	/**
	 * 获取当前月最后一天
	 * @return
	 */
	public static String getLastDay() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return simpleDateFormat.format(calendar.getTime());
	}
	/**
	 * 获取上一月最后一天
	 * @return
	 */
	public static String getBeforeMonthLastDay() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return simpleDateFormat.format(calendar.getTime());
	}
	/**
	 * 获取制定日期的月份对后一天
	 * @param date
	 * @return
	 */
	public static String getLastDay(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		return simpleDateFormat.format(calendar.getTime());
	}
	/**
	 * 获取指定日期的星期
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int index=calendar.get(Calendar.DAY_OF_WEEK)-1;
		if (index<0) {
			index=0;
		}
		return week[index];
	}
	/**
	 * 今天星期几
	 * @return
	 */
	public static String getWeek(){
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int index=calendar.get(Calendar.DAY_OF_WEEK)-1;
		if (index<0) {
			index=0;
		}
		return week[index];
	}
	/**
	 * 获取某时间的前后某分钟日期
	 * @param dateTime
	 * @param beforeMin
	 * @return
	 */
	public static String getStringBeforeDateHHMM(Date date,int beforeMin){
		String dateString = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			
			
			
			Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE)-beforeMin);
	        dateString = format.format(cal.getTime());			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return dateString;		
	}
	/**
	 * 获取某时间的前后某分钟日期
	 * @param dateTime
	 * @param beforeMin
	 * @return
	 */
	public static String getStringBeforeDateHHMM(String dateTime,int beforeMin){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return getStringBeforeDateHHMM(format.parse(dateTime), beforeMin);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 获取当某时间的前后某小时日期
	 * @param dateTime
	 * @param beforeHour
	 * @return
	 */
	public static String getStringBeforeDateHH(Date date,int beforeHour) {
		String dateString = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
		try {
			Calendar cal = Calendar.getInstance();
	        cal.setTime(date);
	        cal.set(Calendar.HOUR, cal.get(Calendar.HOUR)-beforeHour);
	        dateString = format.format(cal.getTime());			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return dateString;
	}
	/**
	 * 获取某时间的前后某小时日期
	 * @param dateTime
	 * @param beforeHour
	 * @return
	 */
	public static String getStringBeforeDateHH(String dateTime,int beforeHour) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
		try {
			return getStringBeforeDateHH(format.parse(dateTime), beforeHour);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
    
}
