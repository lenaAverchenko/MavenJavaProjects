package org.telran.prof.com.homework31_32.thread_pool;

import java.util.*;
import java.util.concurrent.Callable;

public class ResultPrinter implements Callable<List<String>> {

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
    public List<String> call() throws Exception {
        while (race.getResultMap().size() < 10) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return race.getResultMap().entrySet().stream()
                .sorted(Comparator.comparingLong(Map.Entry::getValue))
                .map((horse) -> ("The horse " + horse.getKey().getName() + " finished: " + new Date(horse.getValue()) + " in millis: " + horse.getValue()))
                .toList();
    }
}
