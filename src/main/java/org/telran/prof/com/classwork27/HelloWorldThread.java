package org.telran.prof.com.classwork27;

public class HelloWorldThread extends Thread{
    @Override
    public void run() {
        System.out.println("Hello, world!");
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }
}
