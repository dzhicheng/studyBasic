package com.dongzhic.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dongzhic
 */
public class App {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {


        String number = "1234567";
        String letter = "ABCDEFG";

        char[] aI = number.toCharArray();
        char[] aC = letter.toCharArray();

        t1 = new Thread( () -> {
            for (char c : aI) {
                System.out.println(c);
                // 叫醒T2
                LockSupport.unpark(t2);
                // T1阻塞，当前线程阻塞
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread( () -> {
            for (char c : aC) {
                // T2挂起
                LockSupport.park();
                System.out.println(c);
                // 叫醒T1
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();

    }

    public static boolean isEmpty(String arg) {
        return (arg == null)
                || (arg.trim().equals("") || arg.trim().equals("null") || arg
                .trim().equals("NULL"));
    }

    public static String getNowDayFormat(String format) {
        String temp_str = "";
        Date dt = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        temp_str = sdf.format(dt);
        return temp_str;
    }

    public static String formartDate(Date date, String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }

    public static int comparePastDate(String oldDate,String nowDate){
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date old;
        int day=0;
        try {
            old = sdf.parse(oldDate);
            calendar.setTime(old);
            Long oTime = calendar.getTimeInMillis();

            Date now = sdf.parse(nowDate);
            calendar.setTime(now);
            Long nTime = calendar.getTimeInMillis();

            day=(int) ((nTime - oTime)/(3600F * 1000 * 24));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return day;
    }

    public static Date dateStrToDate(String dateStr, String patterns){
        SimpleDateFormat sdf = new SimpleDateFormat(patterns);
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }

    public static int getYearMargin(Date date1,Date date2){

        int year1 = getCalendarTime(date1,"year");
        int year2 = getCalendarTime(date2,"year");

        return year1 - year2;
    }

    //返回指定日期的年/月/日/时/分/秒
    public static int getCalendarTime(Date date,String sign){

        Calendar c = Calendar.getInstance();
        c.setTime(date); //将Calendar的时间改成日期的时间
        int result = 0;
        if(sign.equals("year"))
            result = c.get(Calendar.YEAR); //获取年份
        if(sign.equals("month"))
            result = c.get(Calendar.MONTH) + 1;//获取月份
        if(sign.equals("day"))
            result = c.get(Calendar.DAY_OF_MONTH);//获取日期号码
        if(sign.equals("hour"))
            result = c.get(Calendar.HOUR_OF_DAY);//获取小时数
        if(sign.equals("minute"))
            result = c.get(Calendar.MINUTE);//获取分钟数
        if(sign.equals("second"))
            result = c.get(Calendar.SECOND);//获取秒数

        return result;
    }



    public static String test () {

        System.out.println();
        try {
            return "zhicheng";
        } finally {
            System.out.println("=========================");
        }
    }
}
