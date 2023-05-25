package org.telran.prof.com.classwork26;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarApp {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        Calendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar);

        Date time = gregorianCalendar.getTime();
        System.out.println(time);

        int i = gregorianCalendar.get(Calendar.MONTH);
        System.out.println("Month is: " + i);

        i = gregorianCalendar.get(Calendar.DAY_OF_MONTH);
        System.out.println("Day of month is: " + i);

        i = gregorianCalendar.get(5);
        System.out.println("Day of month is: " + i);

        GregorianCalendar gregorianCalendar1 = new GregorianCalendar(1925, Calendar.DECEMBER, 31);
        System.out.println(gregorianCalendar1.getTime());

        gregorianCalendar1.set(1925,Calendar.NOVEMBER, 30);
        System.out.println(gregorianCalendar1.getTime());


        gregorianCalendar1 = new GregorianCalendar(1925, Calendar.DECEMBER, 31);
        gregorianCalendar1.add(Calendar.MONTH, 2);
        System.out.println(gregorianCalendar1.getTime());

        gregorianCalendar1 = new GregorianCalendar(1925, Calendar.DECEMBER, 31);
        gregorianCalendar1.roll(Calendar.MONTH, 2);
        System.out.println(gregorianCalendar1.getTime());

        gregorianCalendar1 = new GregorianCalendar(1925, Calendar.DECEMBER, 31);
        gregorianCalendar1.roll(Calendar.MONTH, -22);
        System.out.println(gregorianCalendar1.getTime());

        gregorianCalendar1 = new GregorianCalendar(1925, Calendar.DECEMBER, 31);
        gregorianCalendar1.set(Calendar.YEAR, 1950);
        gregorianCalendar1.set(Calendar.MONTH, 00);
        gregorianCalendar1.set(Calendar.DAY_OF_MONTH, 10);
        gregorianCalendar1.set(Calendar.HOUR_OF_DAY, 23);

        System.out.println(gregorianCalendar1.getTime());

        long l = System.currentTimeMillis();
        Date date = new Date(l);
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println("Format date: " + format);

        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        format = simpleDateFormat.format(date);
        System.out.println("Format date: " + format);

        simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        format = simpleDateFormat.format(new Date());
        System.out.println("Format date: " + format);

    }


 }