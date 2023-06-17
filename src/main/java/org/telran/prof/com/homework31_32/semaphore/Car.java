package org.telran.prof.com.homework31_32.semaphore;

import java.util.concurrent.Semaphore;

public class Car implements Runnable {

    private String carName;
    private Semaphore semaphore;
    private final boolean[] engagedPetrolStation;

    public Car(String carName, Semaphore semaphore, boolean[] freePetrolStation) {
        this.carName = carName;
        this.semaphore = semaphore;
        this.engagedPetrolStation = freePetrolStation;
    }

    @Override
    public void run() {
        System.out.printf("The car %s has come to the Gas Station\n", carName);
        int tempStationIdx = 0;
        try {
            semaphore.acquire();
            synchronized (engagedPetrolStation) {
                for (int i = 0; i < engagedPetrolStation.length; i++) {
                    if (!engagedPetrolStation[i]) {
                        engagedPetrolStation[i] = true;
                        System.out.printf("The car %s is filling up the petrol at the %d station.\n", carName, (i + 1));
                        tempStationIdx = i;
                        System.out.println("");
                        break;
                    }
                }
            }
            Thread.sleep(5000);
            synchronized (engagedPetrolStation) {
                engagedPetrolStation[tempStationIdx] = false;
                semaphore.release();
                System.out.printf("The car %s has left the station %d.\n", carName, (tempStationIdx + 1));
                System.out.printf("The station %d is free.\n", (tempStationIdx + 1));
                System.out.println("______________________________________________________________________");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
