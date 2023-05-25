package org.telran.prof.com.classwork26;

import java.util.Date;
import java.util.Locale;

public class DateApp {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println("Current date is " + date);

        Date date1 = new Date(342333423424l);
        System.out.println("date is " + date1);

        Date date2 = new Date(2023, 01, 15);
        System.out.println("date2: " + date2);
        Date date3 = new Date();
        System.out.println("Current date3: " + date3);
        Date date4 = new Date(2010, 02, 10);
        System.out.println("date4: " + date4);

        boolean after = date2.after(date4);
        System.out.println("After is: " + after);
        boolean before = date2.after(date4);
        System.out.println("Before is: " + before);

        int i = date2.compareTo(date4);
        System.out.println("Compare is: " + i);

        int i1 = date2.compareTo(date3);
        System.out.println("Compare is: " + i1);

        long time = date3.getTime();
        int month = date.getMonth();
        System.out.println("Month: " + month);

        date3.setTime(4569885223656l);
        System.out.println("New date3: " + date3);

//        Date date5 = new Date("2023.12.01");
//        System.out.println(date5);

        Locale locale = new Locale("de");
        Date date5 = new Date();
        String format = String.format(locale, "%tc\n", date5);
        System.out.println(format);
        format = String.format(locale, "%tD\n", date5);
        System.out.println(format);
        format = String.format(locale, "%tF\n", date5);
        System.out.println(format);
        format = String.format(locale, "%tr\n", date5);
        System.out.println(format);
        format = String.format(locale, "%tz\n", date5);
        System.out.println(format);
        format = String.format(locale, "%tZ\n", date5);
        System.out.println(format);

    }
}
