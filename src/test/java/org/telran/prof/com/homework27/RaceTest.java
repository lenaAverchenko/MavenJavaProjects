package org.telran.prof.com.homework27;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RaceTest {
    public static Race race;
    public static Hippodrome hippodrome;
    public static List<Horse> horses;
    public static ResultPrinter resultPrinter;
    public static Thread thread;

    @BeforeAll
    static void init() {
        hippodrome = new Hippodrome(1000, 10);
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
        horses = Arrays.asList(horse1, horse2, horse3, horse4, horse5, horse6, horse7, horse8, horse9, horse10);
        race = new Race(horses, hippodrome);
        horses.stream().forEach(h -> h.setRace(race));
        thread = new Thread(resultPrinter);
    }

    @Test
    void startRace() {
        thread.start();
        Assertions.assertEquals(10, race.startRace());
    }

}