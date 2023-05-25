package org.telran.prof.com.classwork27;

public class MyThreadApp {
    public static void main(String[] args) throws InterruptedException {
//        HelloWorldThread helloWorldThread = new HelloWorldThread();
////        helloWorldThread.run();
//        helloWorldThread.start();

        HelloWorldRunnable helloWorldRunnable = new HelloWorldRunnable();
//        helloWorldRunnable.run();
        Thread thread = new Thread(helloWorldRunnable);
        thread.start();
//        Thread.sleep(5000);
        System.out.println("Hello world from method main");

        new Thread((helloWorldRunnable)).start();

        Runnable example = () -> {
            try{
                Thread.sleep(5000);}
            catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Hello, world from method run!");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        };

        new Thread(example).start();
    }
}
