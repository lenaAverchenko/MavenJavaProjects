package org.telran.prof.com.classwork27;

public class MyThreadAppTwo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ExampleThread exampleThread = new ExampleThread(i);
            Thread thread = new Thread(exampleThread);
            System.out.println("Current thread name = " + thread.getName() + ". State: " + thread.getState());
//            thread.start();
//            new Thread(new ExampleThread(i)).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(new ExampleThreadTwo()).start();
        }
    }
}
