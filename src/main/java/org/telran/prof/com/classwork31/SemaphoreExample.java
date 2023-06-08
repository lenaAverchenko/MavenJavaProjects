package org.telran.prof.com.classwork31;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5, true);

        boolean[] freeTables = new boolean[5];
        String[] personName = {"Roman", "Alena", "Kira", "Anna", "Leo", "Bob","Vlad", "Inna"};

        for (int i = 0; i < personName.length; i++){
            new Thread(new Person(personName[i], semaphore, freeTables)).start();
            Thread.sleep(700);
        }
    }
}
