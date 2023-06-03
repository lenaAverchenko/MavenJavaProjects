package org.telran.prof.com.classwork29;

public class ExampleFour {
    public static void main(String[] args) throws InterruptedException {
        CounterClassic counterClassic = new CounterClassic();
        Thread thread1 = new Thread(counterClassic);
        Thread thread2 = new Thread(counterClassic);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("CounterClassic = " + counterClassic.getCounter());


        CounterSync counterSync = new CounterSync();
        Thread thread3 = new Thread(counterSync);
        Thread thread4 = new Thread(counterSync);

        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();

        System.out.println("Counter Sync = " + counterSync.getCounter());

        CounterAtomic counterAtomic = new CounterAtomic();
        Thread thread5 = new Thread(counterAtomic);
        Thread thread6 = new Thread(counterAtomic);

        thread5.start();
        thread6.start();
        thread5.join();
        thread6.join();

        System.out.println("Counter Atomic = " + counterAtomic.getCounter());

    }
}
