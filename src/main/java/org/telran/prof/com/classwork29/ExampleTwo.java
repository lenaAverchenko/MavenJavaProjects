package org.telran.prof.com.classwork29;

public class ExampleTwo {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {

                int count = 0;
                for (int i = 0; i < 5; i++) {
                    count +=1;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("" + Thread.currentThread().getName() + " : " + count);
                }
            }
        };

        Thread one = new Thread(runnable);
        Thread two = new Thread(runnable);
        Thread three = new Thread(runnable);
        one.start();
        Thread.sleep(1000);
        two.start();
        three.start();
        Thread.sleep(1000);
        System.out.println("State for one thread: " + one.getState());
        System.out.println("State for two thread: " + two.getState());
        System.out.println("State for three thread: " + three.getState());



//        one.join();
//        two.join();
//        three.join();

    }
}
