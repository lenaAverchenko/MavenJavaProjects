package org.telran.prof.com.homework26;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ZonedDateTimeApp {
    public static <LocalDayTime> void main(String[] args) {
        Calendar dateOfMyBirth = new GregorianCalendar(1989, 11, 11);
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println(sdf.format(dateOfMyBirth.getTime()));

        LocalDate date = LocalDate.of(1989, 12, 11);
        System.out.println(date.getDayOfWeek());
        System.out.println(date.getDayOfWeek().equals(DayOfWeek.FRIDAY));

        System.out.println(date.minusYears(10L));

        LocalDateTime dateTime = LocalDateTime.of(1989, 12, 11, 21, 15);
        ZoneId zone = ZoneId.of("Europe/Paris");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zone);
        System.out.println(zonedDateTime);
        LocalDateTime dateTime1 = LocalDateTime.now();
        ZoneId zone1 = ZoneId.of("Pacific/Midway");
        ZonedDateTime zonedDateTime1 = ZonedDateTime.of(dateTime1, zone1);
        System.out.println(zonedDateTime1);
    }
}
