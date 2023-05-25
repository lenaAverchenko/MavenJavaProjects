package org.telran.prof.com.classwork27;

public class HelloWorldRunnable implements Runnable{
    @Override
    public void run() {
        try{
        Thread.sleep(5000);}
        catch (InterruptedException e){
            e.printStackTrace();
        }
            System.out.println("Hello, world from method run!");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }

