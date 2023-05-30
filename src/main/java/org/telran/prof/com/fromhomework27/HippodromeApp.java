package org.telran.prof.com.fromhomework27;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class HippodromeApp {

    public static final int RACE_LENGTH = 100;
    public static Map<Horse, Long> resultMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Horse one = new Horse("One", 0.3);
        Horse two = new Horse("Two", 1.55);
        Horse three = new Horse("Three", 0.75);

        List<Horse> horses = Arrays.asList(one, two, three);
        for(Horse horse: horses){
            new Thread(horse).start();
        }

        Thread thread = new Thread(new ResultPrinter());
        thread.start();
        Thread.sleep(10000);
        System.out.println(resultMap);
    }

}
