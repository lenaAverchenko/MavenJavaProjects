package org.telran.prof.com.classwork30;

public class WaitNotifyApp {
    public static void main(String[] args) throws InterruptedException {
        Crossbow crossbow = new Crossbow();
        Thread threadOne = new Thread(crossbow::fire);
        threadOne.start();
//        Thread.sleep(3000);
//        System.out.println("" + threadOne.getName() + " " + threadOne.getState());
        Thread threadTwo = new Thread(crossbow::reload);
        threadTwo.start();

        Thread.sleep(15000);
        threadOne.interrupt();
        threadTwo.interrupt();
    }
}
