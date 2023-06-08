package org.telran.prof.com.classwork31;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class PersonOnFunicular implements Runnable{

    private String personName;
    private CyclicBarrier cyclicBarrier;

    public PersonOnFunicular(String personName, CyclicBarrier cyclicBarrier) {
        this.personName = personName;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("-> " + personName + " has come to the funicular");
        try {
            cyclicBarrier.await();
            System.out.println("<- " + personName + " is on the top");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
