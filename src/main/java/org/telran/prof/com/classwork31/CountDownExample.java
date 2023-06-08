package org.telran.prof.com.classwork31;

import java.util.concurrent.CountDownLatch;

public class CountDownExample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        String[] personName = {"Roman", "Alena", "Kira", "Anna", "Leo", "Bob","Vlad", "Inna"};

        for (String name : personName){
            new Thread(new PersonInAirport(name, countDownLatch)).start();
            Thread.sleep(700);
        }

    }
}
