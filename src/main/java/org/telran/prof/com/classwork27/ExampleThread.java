package org.telran.prof.com.classwork27;

public class ExampleThread implements Runnable{

    private  int count;

    public ExampleThread(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println("Count = " + count);
    }
}
