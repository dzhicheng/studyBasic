package com.dongzhic.java;

import org.openjdk.jol.info.ClassLayout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;

/**
 * @author dongzhic
 */
public class App {


    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {

        String a = null;
        String b = String.valueOf(a);
        System.out.println(b);

//        Integer a = 1;
//        if (a > 0) {
//            System.out.println(1111111111);
//        }
//
//        String a = null;
//        // 三元表达式对于不可互转一个常量，一个变量的情况，会默认泛型为变量类型
//        System.out.println(false ? 0 : a);
//
//        Integer b = null;
//        // 类型不同，但可互转，会拆箱，执行b.intValue()抛空指针异常
//        System.out.println(false ? 0 : b);
//
//        List<Integer> list1 = new ArrayList<>();


//        LocalDate localDate = LocalDate.of(2021, 10, 25);
//        System.out.println(localDate.getYear());
//        System.out.println(localDate.getMonth());
//        System.out.println(localDate.getDayOfMonth());

//        SimpleDateFormat



//        String a = "a";
//        String b = "b";
//        String c = a + b;
//        String d = new String("a") + new String("b");
//        System.out.println(c == "ab");

//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        // 1.无锁(匿名偏向锁)
//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());
//
//        // 2.偏向锁
//        synchronized (o) {
//            System.out.println(ClassLayout.parseInstance(o).toPrintable());
//        }
//
//        // 3.轻量级锁
//        new Thread(() -> {
//            synchronized (o) {
//                System.out.println(ClassLayout.parseInstance(o).toPrintable());
//            }
//        }).start();
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(() -> {
//            synchronized (o) {
//                System.out.println(ClassLayout.parseInstance(o).toPrintable());
//            }
//        }).start();
//
//        // 4.重量级锁
//        Thread t1 = new Thread(() -> {
//            synchronized (o) {
//                System.out.println("thread1 locking");
//                System.out.println(ClassLayout.parseInstance(o).toPrintable());
//                // 线程晚点死亡，造成锁竞争
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            synchronized (o) {
//                System.out.println("thread2 locking");
//                System.out.println(ClassLayout.parseInstance(o).toPrintable());
//                // 线程晚点死亡，造成锁竞争
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        t1.start();
//        t2.start();

//        Integer[] nums = new Integer[2];
//        nums[0] = 0;
//        nums[1] = 1;
//        numberTest(nums);
    }

    public static void numberTest (Number[] numbers) {


        for (Number num : numbers) {
            System.out.println(num);
        }
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
