package org.telran.prof.com.classwork32.executorbuilding;

import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class Building implements Runnable{
    private  String city;
    private CountDownLatch latch;
    private String[] stages;
    private boolean printDateWithSeconds;

    public Building(String city, CountDownLatch latch, String[] stages, boolean printDateWithSeconds) {
        this.city = city;
        this.latch = latch;
        this.stages = stages;
        this.printDateWithSeconds = printDateWithSeconds;
    }

    @Override
    public void run() {
        for (int i = 0; i < stages.length; i++) {
            String result = "Work in " + city +
                    " : stage = " + stages[i] + ", " + Thread.currentThread().getName() + " ";
            if (printDateWithSeconds) {
                result = result + new Date();
            }
                System.out.println(result);
                latch.countDown();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
            }
        }
    }
}
