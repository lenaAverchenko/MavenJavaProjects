package org.telran.prof.com.classwork28;

public class HelloPrinterWithoutSleep implements Runnable{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Hello!" + System.currentTimeMillis());
        }
    }
}
