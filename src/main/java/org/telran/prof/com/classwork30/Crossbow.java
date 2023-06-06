package org.telran.prof.com.classwork30;

public class Crossbow {
    private int arrows = 10;

    synchronized public void fire() {
        while(!Thread.currentThread().isInterrupted()) {
                if (arrows != 0) {
                    System.out.println("" + Thread.currentThread().getName() + " The arrow " + (arrows) + " it is ok");
                    arrows--;
                } else {
                    System.out.println("" + Thread.currentThread().getName() + " The arrows are over");
                    System.out.println("" + Thread.currentThread().getName() + " Number of arrows is " + arrows);
                    try {
                        notify();
                        wait();
                    } catch (InterruptedException e) {
                        break;
                    }
                    System.out.println("" + Thread.currentThread().getName() + " Has brought new arrows!");
                }
        }
    }

    synchronized public void reload() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
            System.out.println("" + Thread.currentThread().getName() + " New arrows on the way");
            arrows = 10;
            System.out.println("" + Thread.currentThread().getName() + " Number of arrows is " + arrows);
            System.out.println();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                break;
            }
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
