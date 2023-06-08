package org.telran.prof.com.classwork31;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        //груз первого грузовика
        String[] p1 = {"A->D", "A->C"};
        //груз второго грузовика
        String[] p2 = {"B->C", "B->D"};

        new Thread(new Track(1, "A", "D", p1, exchanger)).start();
        Thread.sleep(300);
        new Thread(new Track(2, "B", "C", p2, exchanger)).start();


    }
}
