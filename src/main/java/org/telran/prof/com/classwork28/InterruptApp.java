package org.telran.prof.com.classwork28;

public class InterruptApp {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            for (int i = 0; i < 100000; i++) {
//                System.out.println("Hello! " + i);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
//        thread.sleep(1000);
        System.out.println("Interrupted " + thread.isInterrupted());
        thread.interrupt();
//        thread.sleep(1000);
        System.out.println("Interrupted " + thread.isInterrupted());

    }
}
