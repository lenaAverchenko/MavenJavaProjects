package org.telran.prof.com.classwork26;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class SelfWork {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2000));
        System.out.println(isLeapYear(2001));
        System.out.println(isLeapYear(2002));
        System.out.println(isLeapYear(2003));
        System.out.println(isLeapYear(2004));

        Locale locale = new Locale("in");
        Date date = new Date();
        String format = String.format(locale, "%tc\n", date);
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yy, K:mm, d, D");
        System.out.println(simpleDateFormat.format(new Date()));

        simpleDateFormat = new SimpleDateFormat("K:mm");
        System.out.println(simpleDateFormat.format(new Date()));
    }

    public static boolean isLeapYear(int year){
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(year);
    }
}
