package org.telran.prof.com.homework31_32.thread_pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RaceApp {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Hippodrome hippodrome = new Hippodrome(100, 10);
        List<Horse> horses = Arrays.asList(
                new Horse("Bethany"),
                new Horse("Ken"),
                new Horse("Bruno"),
                new Horse("Lucky"),
                new Horse("Spot"),
                new Horse("Lovely"),
                new Horse("Tony"),
                new Horse("Lightning"),
                new Horse("Sunny"),
                new Horse("Power"));
        Race race = new Race(horses, hippodrome);
        horses.stream().forEach(h -> h.setRace(race));

        ExecutorService executorService = Executors.newCachedThreadPool();
        ResultPrinter resultPrinter = new ResultPrinter(race);
        Future<List<String>> answer = executorService.submit(resultPrinter);
        for (Horse h : horses) {
            executorService.execute(h);
        }
        answer.get().forEach(System.out::println);
        executorService.shutdown();
    }
}
