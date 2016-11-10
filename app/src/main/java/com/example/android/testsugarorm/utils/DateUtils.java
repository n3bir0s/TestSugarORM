package com.example.android.testsugarorm.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Project: TestSugarORM
 *
 * @package: com.example.android.testsugarorm.utils
 * <p>
 * Created by Sven on 10.11.2016..
 * DwS-Solutions.com - All rights reserved  - Copyright (c) 2016
 */

public class DateUtils {

    private final static String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private final static String SHORT_DATE_FORMAT = "yyyy-MM-dd";
    private final static String TIME_FORMAT = "HH:mm:ss";

    // Day Specific time
    private final static String TIME_START = "00:00:00";
    private final static String TIME_END = "23:59:59";

    private static String mServerTimeZone = "UTC";

    private static int mMonth = Calendar.MONTH;
    private static int mYear = Calendar.YEAR;

    private final static Date mCurrentTime = new Date();

    public static void setServerTimeZone(String serverTimeZone) {
        mServerTimeZone = serverTimeZone;
    }

    /**
     * Get today date in long format ( yyyy-MM-dd HH:mm:ss )
     *
     * @return String formated date in time zone
     */
    public static String getTodayDateLong() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(LONG_DATE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone(mServerTimeZone));
        return dateFormat.format(mCurrentTime);
    }

    public static String getTodayDateShort() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(SHORT_DATE_FORMAT);
        return dateFormat.format(mCurrentTime);
    }

    public static String getCurrentTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(TIME_FORMAT);
        return dateFormat.format(mCurrentTime);
    }

    /**
     * get today start date in format yyyy-MM-dd HH:mm:ss
     *
     * @return String - formated today start of current date
     */
    public static String getTodayStart() {
        //String today = getTodayDateShort();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        df.setTimeZone(TimeZone.getTimeZone(mServerTimeZone));
        return df.format(mCurrentTime);
    }

    /**
     * get today end date in format yyyy-MM-dd HH:mm:ss
     *
     * @return String - formated today end of current date
     */
    public static String getTodayEnd() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        df.setTimeZone(TimeZone.getTimeZone(mServerTimeZone));
        return df.format(mCurrentTime);
    }

    /**
     * get current month start date in format yyyy-MM-dd HH:mm:ss
     *
     * @return String - formated month start of current date
     */

    public static String getMonthStart() {
        Date monthStart = getMonthStart(mCurrentTime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //df.setTimeZone(TimeZone.getTimeZone(mServerTimeZone));
        return df.format(monthStart);
    }

    /**
     * get current month end date in format yyyy-MM-dd HH:mm:ss
     *
     * @return String - formated month end of current date
     */
    public static String getMonthEnd() {
        Date monthEnd = getMonthEnd(mCurrentTime);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //df.setTimeZone(TimeZone.getTimeZone(mServerTimeZone));
        return df.format(monthEnd);
    }

    /**
     * get current month start helper
     *
     * @return Date
     */
    private static Date getMonthStart(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * get current month end helper
     *
     * @return Date
     */
    private static Date getMonthEnd(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        return calendar.getTime();
    }

    public static String getYearStart() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-01-01 00:00:00");
        return df.format(mCurrentTime);
    }
    public static String getYearEnd() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-12-31 23:59:59");
        return df.format(mCurrentTime);
    }


}
