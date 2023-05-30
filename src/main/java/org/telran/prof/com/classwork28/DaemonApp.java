package org.telran.prof.com.classwork28;

public class DaemonApp {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello!" + System.currentTimeMillis());
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        System.out.println(thread.isDaemon());

        Thread.sleep(10000);
    }
}
