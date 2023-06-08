package org.telran.prof.com.classwork31;

public class Funicular implements  Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("Funicular has took 2 people and now is going to the top of the mountain");
            System.out.println();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
