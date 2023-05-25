package org.telran.prof.com.classwork26;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateApp {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        int year = now.getYear();
        System.out.println(year);
        Month month = now.getMonth();
        System.out.println(month);

        LocalDate of = LocalDate.of(2020,5,15);
        System.out.println(of);
        LocalDate of1 = LocalDate.of(2019,Month.APRIL,10);
        System.out.println(of1);

        LocalDate localDate = of.plusYears(2);
        localDate = of.plusDays(5);
        localDate = of.minusWeeks(2);
        System.out.println(localDate);





    }
}
