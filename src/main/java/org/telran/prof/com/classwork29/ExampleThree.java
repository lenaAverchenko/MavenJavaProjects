package org.telran.prof.com.classwork29;

public class ExampleThree {
    public static void main(String[] args) {
        Object monitor = new Object();

        // одновременно будет выполнен, т.к. синхронизация по разным объектам. И нечего синхронизировать. т.к. работа с разыми объектами
//        NewThread newThread1 = new NewThread(1);
//        NewThread newThread2 = new NewThread(2);
//
//        newThread1.start();
//        newThread2.start();

        // 2 птока выполнятся последовательно, т.к. синхронизация по 1 общему объекту
        NewThread newThread3 = new NewThread(1, monitor);
        NewThread newThread4 = new NewThread(2, monitor);

        newThread3.start();
        newThread4.start();
    }
}
