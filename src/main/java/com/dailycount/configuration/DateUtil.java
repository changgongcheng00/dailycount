package com.dailycount.configuration;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/**
 * Date utility class.It extends the apache common date utility.
 */
public final class DateUtil extends DateUtils {

    /**
     * DATE_HOUR_MINUTE_SECOND_PATTERN
     */
    public static final String HOUR_MINUTE_PATTERN = "HH:mm";

    /**
     * DATE_HOUR_MINUTE_SECOND_PATTERN
     */
    public static final String DATE_HOUR_MINUTE_SECOND_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * DATE_HOUR_MINUTE_PATTERN_CHN
     */
    public static final String DATE_HOUR_MINUTE_PATTERN_CHN = "yyyy年MM月dd日 HH:mm";

    /**
     * DATE_HOUR_MINUTE_PATTERN
     */
    public static final String DATE_HOUR_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

    /**
     * DATE_PATTERN
     */
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * DATE_PATTERN
     */
    public static final String DATE_PATTERN_DOT = "yyyy.MM.dd";

    /**
     * DATE_PATTERN_DIGIT
     */
    public static final String DATE_PATTERN_DIGIT = "yyyyMMdd";

    /**
     * DATE_PATTERN_CHINESE
     */
    public static final String DATE_PATTERN_CHN = "yyyy年MM月dd日";

    /**
     * YEAR_MONTH_PATTERN
     */
    public static final String YEAR_MONTH_PATTERN = "yyyy年M月";

    /**
     * MONTH_DAY_PATTERN
     */
    public static final String MONTH_DAY_PATTERN = "MM月dd日";

    /**
     * FILE_DATE_HOUR_MINUTE_SECOND_PATTERN
     */
    public static final String FILE_DATE_HOUR_MINUTE_SECOND_PATTERN = "yyyy_MM_dd_HH_mm_ss";

    /**
     * FILE_DATE_HOUR_MINUTE_SECOND_PATTERN
     */
    public static final String WECHAT_DATE_HOUR_MINUTE_SECOND_PATTERN = "yyyyMMddHHmmss";

    /**
     * Private empty constructor.
     */
    private DateUtil() {
        // Hide constructor.
    }

    /**
     * 该方法用于格式化date
     *
     * @param date date
     * @param pattern pattern
     * @return formatted date string
     */
    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    /**
     * 该方法用于根据格式化后的string获取date
     *
     * @param date date
     * @param pattern pattern
     * @return formatted date string
     */
    public static Date parseDate(String date, String pattern) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Illegal Data String Format: " + date, e);
        }
    }

    /**
     * 获取当前小时的开始
     *
     * @param date java.util.Date
     * @return Today yyyy-mm-dd hh:00:00.0
     */
    public static Date getHourBeginTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 0);
        cal.add(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当天的开始时间
     *
     * @param date java.util.Date
     * @return Today yyyy-mm-dd 00:00:00.0
     */
    public static Date getDayBeginTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 当天的结束时间
     *
     * @param date java.util.Date
     * @return Today yyyy-mm-dd 23:59:59
     */
    public static Date getDayEndTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 该方法用于获得传入的时间是一周中的第几天
     *
     * @param date date
     * @return 1到7
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int result = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return result == 0 ? 7 : result;
    }

    /**
     * 该方法用于获得传入的时间是一周中的第几天
     *
     * @param date date
     * @return 一到日
     */
    public static String getDayOfWeekChinese(Date date) {
        String[] days = new String[] { "一", "二", "三", "四", "五", "六", "日" };
        int day = getDayOfWeek(date);
        return days[day - 1];
    }

    /**
     * 获取当月的开始时间
     *
     * @param date java.util.Date
     * @return Today yyyy-mm-dd 00:00:00.0
     */
    public static Date getMonthBeginTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 该方法用于 获取某一周周几的日期
     *
     * @param weekDiff 周差，本周是0
     * @param dayOfWeek 周几，从SUNDAY开始
     * @param date 标准日期
     * @return 日期
     */
    public static Date getPreviousDayOfWeek(int weekDiff, int dayOfWeek, Date date) {
        dayOfWeek = dayOfWeek % 7;
        Iterator<Calendar> itor = DateUtil.iterator(DateUtil.addDays(date, weekDiff * 7), RANGE_WEEK_SUNDAY);
        for (int i = 0; i < dayOfWeek; i++) {
            if (itor.hasNext()) {
                itor.next();
            }
        }
        if (itor.hasNext()) {
            return itor.next().getTime();
        }
        return null;
    }

    /**
     * 该方法用于计算两个date之间的小时数差 <br/>
     * 如果时间为：11:59:59 和 00:00:01的话差值为 0
     *
     * @param date1 date1
     * @param date2 date2
     * @param field Calendar.MILLISECOND SECOND MINUTE HOUR
     * @return date1和date2之间的小时数差
     */
    public static int diff(Date date1, Date date2, int field) {
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long diff = (time1 > time2) ? (time1 - time2) : (time2 - time1);

        switch (field) {
            case Calendar.MILLISECOND:
                return (int) diff;
            case Calendar.SECOND:
                return (int) (diff / DateUtils.MILLIS_PER_SECOND);
            case Calendar.MINUTE:
                return (int) (diff / DateUtils.MILLIS_PER_MINUTE);
            case Calendar.HOUR:
                return (int) (diff / DateUtils.MILLIS_PER_HOUR);
            case Calendar.DATE:
            default:
                return (int) (diff / DateUtils.MILLIS_PER_DAY);
        }
    }

    /**
     * 该方法用于 获得本周一0点时间
     *
     * @return date
     */
    public static Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * 该方法用于 获得本周日24点时间
     *
     * @return date
     */
    public static Date getTimesWeeknight() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getTimesWeekmorning());
        cal.add(Calendar.DAY_OF_WEEK, 7);
        return cal.getTime();
    }

    /**
     * 该方法用于获得年、月、日等的数值
     *
     * @param date date
     * @param field field
     * @return int
     */
    public static int getField(Date date, int field) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(field);
    }

}
