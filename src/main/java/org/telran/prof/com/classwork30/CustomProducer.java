package org.telran.prof.com.classwork30;

import java.util.UUID;

public class CustomProducer implements Runnable{
    private  CustomBlockingQueue blockingQueue;

    public CustomProducer(CustomBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        System.out.println("Start Producer");
        while (true){
            try {
                blockingQueue.put("Produce " + UUID.randomUUID());
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
