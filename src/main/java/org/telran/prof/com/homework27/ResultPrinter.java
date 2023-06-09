package org.telran.prof.com.homework27;

import java.util.*;

public class ResultPrinter implements Runnable {

    private Race race;

    public ResultPrinter(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }

    @Override
    public String toString() {
        return "ResultPrinter{" +
                "race=" + race +
                '}';
    }

    @Override
    public void run() {
        while (race.getResultMap().size() < 10) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        race.getResultMap().entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .forEach((horse) -> System.out.println("The horse " + horse.getKey().getName() + " finished: " + new Date(horse.getValue()) + " in millis: " + horse.getValue()));
    }
}
