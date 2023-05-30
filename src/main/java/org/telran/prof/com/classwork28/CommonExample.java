package org.telran.prof.com.classwork28;

public class CommonExample {

    private static int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                sum++;
                System.out.println("Thread " + Thread.currentThread().getName() + " " + sum);
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        Thread.sleep(100);
        System.out.println(sum);
    }

}
