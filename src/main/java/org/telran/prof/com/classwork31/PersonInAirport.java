package org.telran.prof.com.classwork31;

import java.util.concurrent.CountDownLatch;

public class PersonInAirport implements Runnable {

    private String personName;
    private CountDownLatch countDownLatch;

    public PersonInAirport(String personName, CountDownLatch countDownLatch) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
        System.out.println("-> " + personName + " has arrived to the Airport");
        System.out.println("..." + personName + " passed the customs");
        System.out.println("..." + personName + " has a breakfast");
        countDownLatch.countDown();
        System.out.println();
            countDownLatch.await();
            System.out.println("    " + personName + "flew to vacation with others");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
