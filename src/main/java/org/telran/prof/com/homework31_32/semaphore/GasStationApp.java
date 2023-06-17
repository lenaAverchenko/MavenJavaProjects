package org.telran.prof.com.homework31_32.semaphore;

import java.time.LocalDateTime;

import java.util.concurrent.Semaphore;

public class GasStationApp {
    public static void main(String[] args) throws InterruptedException {
        Semaphore petrolStationSemaphore = new Semaphore(4, true);
        LocalDateTime date = LocalDateTime.now();
        boolean[] freeStation = new boolean[4];

        int i = 1;
        while (LocalDateTime.now().isBefore(date.plusMinutes(1L))) {
            new Thread(new Car(("Auto " + i), petrolStationSemaphore, freeStation)).start();
            i++;
            Thread.sleep(1000);
        }
    }
}
