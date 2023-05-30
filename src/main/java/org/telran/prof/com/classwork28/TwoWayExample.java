package org.telran.prof.com.classwork28;

public class TwoWayExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new TwoWayInterruptExample());
        thread.start();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(20);
            if (thread.getState() == Thread.State.TIMED_WAITING) {
                thread.interrupt();
            }
        }
    }
}
