package org.telran.prof.com.classwork31;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,new Funicular());
        String[] personName = {"Roman", "Alena", "Kira", "Anna", "Leo", "Bob","Vlad", "Inna"};

        for (String person: personName){
            new Thread(new PersonOnFunicular(person, cyclicBarrier)).start();
            Thread.sleep(300);
        }
    }
}
