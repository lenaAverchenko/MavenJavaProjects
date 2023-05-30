package org.telran.prof.com.classwork28;

public class InterruptExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new HelloPrinter());
        thread.start();
        Thread.sleep(10000); // сам поток не прервется, если поймав исключение, не прервем его break()
        thread.interrupt();
        Thread.sleep(5000); // main ждет

        Thread thread1 = new Thread(new HelloPrinterWithoutSleep());
        thread1.start();
        Thread.sleep(10000);
        thread1.interrupt();
        Thread.sleep(5000);
    }
}
