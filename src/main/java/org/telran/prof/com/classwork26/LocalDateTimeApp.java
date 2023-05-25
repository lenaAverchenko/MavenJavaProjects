package org.telran.prof.com.classwork26;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeApp {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime dayTime = LocalDateTime.of(2015,05,10,0,0,10);
        System.out.println(dayTime);

        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime of = LocalDateTime.of(date, time);
        System.out.println("Current is: " + of);
        
        LocalDate localDate = of.toLocalDate();
        LocalTime localTime = of.toLocalTime();
        
        boolean after = localDateTime.isAfter(of);
        boolean before = localDateTime.isBefore(of);
        boolean equals = localDateTime.isEqual(of);






    }
}
