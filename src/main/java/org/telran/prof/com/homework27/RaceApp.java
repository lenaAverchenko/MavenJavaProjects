package org.telran.prof.com.homework27;

import java.util.Arrays;
import java.util.List;

public class RaceApp {

    public static void main(String[] args) throws InterruptedException {
        Hippodrome hippodrome = new Hippodrome(100, 10);
        Horse horse1 = new Horse("Bethany");
        Horse horse2 = new Horse("Ken");
        Horse horse3 = new Horse("Bruno");
        Horse horse4 = new Horse("Lucky");
        Horse horse5 = new Horse("Spot");
        Horse horse6 = new Horse("Lovely");
        Horse horse7 = new Horse("Tony");
        Horse horse8 = new Horse("Lightning");
        Horse horse9 = new Horse("Sunny");
        Horse horse10 = new Horse("Power");
        List<Horse> horses = Arrays.asList(horse1, horse2, horse3, horse4, horse5, horse6, horse7, horse8, horse9, horse10);
        Race race = new Race(horses, hippodrome);
        horses.stream().forEach(h -> h.setRace(race));

        ResultPrinter resultPrinter = new ResultPrinter(race);
        Thread threadOfResults = new Thread(resultPrinter);
        threadOfResults.start();
        race.startRace();
    }
}
