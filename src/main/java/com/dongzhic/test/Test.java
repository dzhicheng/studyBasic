package com.dongzhic.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        // 计算用户注册天数

        String raiseEnddate = "2019-07-13 00:00:00";
        raiseEnddate = raiseEnddate.substring(0,10);//截止时间
        System.out.println(raiseEnddate);



        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
//        String createTime = "2018-08-15 18:17:38".split(" ")[0];
        String createTime = "2018-04-15 18:17:38".split(" ")[0];
//        Date date1 = null;
//        Date date2 = null;
//        try {
//            date1 = formater.parse(createTime);
//            date2 = formater.parse(formater.format(new Date()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        int registerDay = differentDays(date1, date2);
//        System.out.println(registerDay);


        int days = daysBetween(createTime, formater.format(new Date()));
        System.out.println(days);
    }

    public static int differentDays (Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        int day1= calendar1.get(Calendar.DAY_OF_YEAR);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);

        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);

        if (year1 != year2) {
            // 不同年
            int timeDistance = 0;
            for (int i = year1; i < year2; i ++) {
                // 闰年
                boolean leapYear = i % 4 == 0 && i % 100 != 0 || i % 400 == 0;
                if (leapYear) {
                    timeDistance += 366;
                } else {
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {
            // 同一年
            return day2 - day1;
        }
    }

    public static int daysBetween(String timeStr, String sdf)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;;
        try {
            date1 = format.parse(timeStr);
            date2 = format.parse(sdf);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        long time1 = cal.getTimeInMillis();
        cal.setTime(date2);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);

        return Integer.parseInt(String.valueOf(between_days));
    }
}
