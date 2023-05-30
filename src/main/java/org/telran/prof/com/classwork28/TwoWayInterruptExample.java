package org.telran.prof.com.classwork28;

import java.util.Arrays;
import java.util.List;

public class TwoWayInterruptExample implements Runnable{

    List<Integer> integers = Arrays.asList(2,3,4,5,6,7,8,9,0,7,7,7,6,5,8,9,4,8);

    @Override
    public void run() {
        while (true) {
            //First station
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                System.out.println("Interruption is in sleep state");
            }

            //Second station
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100000000; i++) {
                int sum = i % 2;
                integers.contains(sum);
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interruption is in runnable state");
            }
        }
    }
}
