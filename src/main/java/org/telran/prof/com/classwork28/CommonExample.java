package org.telran.prof.com.classwork28;

import java.util.concurrent.atomic.AtomicInteger;

public class CommonExample {

//    private static int sum = 0;

    private static AtomicInteger sum = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                sum++;
                sum.addAndGet(1);
                System.out.println("Thread " + Thread.currentThread().getName() + " " + sum);
            }
        };

        Runnable runnable1 = new Runnable() {
            @Override
            public synchronized void run() {
                for (int i = 0; i < 10000; i++) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
//                    sum++;
                    sum.addAndGet(1);
                    System.out.println("Thread " + Thread.currentThread().getName() + " " + sum);
                }
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    for (int i = 0; i < 10000; i++) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
//                        sum++;
                        sum.addAndGet(1);
                        System.out.println("Thread " + Thread.currentThread().getName() + " " + sum);
                    }
                }
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable1).start();
        Thread.sleep(100);
        System.out.println(sum);
    }

}
