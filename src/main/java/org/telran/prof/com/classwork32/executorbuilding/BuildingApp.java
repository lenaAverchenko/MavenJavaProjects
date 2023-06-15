package org.telran.prof.com.classwork32.executorbuilding;

import java.util.concurrent.*;

public class BuildingApp {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdOne = new CountDownLatch(4);
        CountDownLatch cdTwo = new CountDownLatch(4);
        CountDownLatch cdThree = new CountDownLatch(4);
        CountDownLatch cdFour = new CountDownLatch(4);

        String[] stages = {"1. Project", "2. Start Building", "3. Finish Building", "4. Check"};
        Building berlin = new Building("Berlin",cdOne,  stages, true);
        Building dortmund = new Building("Dortmund", cdTwo, stages, true);
        Building essen = new Building("Essen", cdThree, stages, true);
        Building bonn = new Building("Bonn", cdFour, stages, true);
        // Пример 1
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
        // Пример 2
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // Пример 3
//        ExecutorService executorService = Executors.newCachedThreadPool();
        //        executorService.submit(berlin);
//        executorService.submit(dortmund);
//        executorService.submit(essen);
//        executorService.submit(bonn);

//        executorService.execute(berlin);
//        executorService.execute(dortmund);
//        executorService.execute(essen);
//        executorService.execute(bonn);
        // Пример 4
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        // for Пример 4
        executorService.schedule(berlin,5, TimeUnit.SECONDS);
        executorService.schedule(dortmund,6, TimeUnit.SECONDS);
        executorService.schedule(essen,7, TimeUnit.SECONDS);
        executorService.schedule(bonn,8, TimeUnit.SECONDS);



        cdOne.await();
        cdTwo.await();
        cdThree.await();
        cdFour.await();

        executorService.shutdown();
        System.out.println("Finish all");


    }
}
