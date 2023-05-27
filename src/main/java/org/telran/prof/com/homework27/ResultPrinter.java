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
        if (race.getResultMap().size() == 10) {
            Map<Horse, Long> sortedResult = new TreeMap<>(Comparator.comparingDouble(race.getResultMap()::get));
            sortedResult.putAll(race.getResultMap());
            sortedResult.forEach((horse, time) -> System.out.println("The horse " + horse.getName() + " finished: " + new Date(time) + " in millis: " + time));
        }
        while (race.getResultMap().size() < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            run();
        }
    }
}
