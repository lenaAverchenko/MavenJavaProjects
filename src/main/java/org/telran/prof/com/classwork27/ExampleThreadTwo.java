package org.telran.prof.com.classwork27;

public class ExampleThreadTwo implements Runnable{
    @Override
    public void run() {
        System.out.println("Current thread name = " + Thread.currentThread().getName() + ". State: " + Thread.currentThread().getState());
    }
}
