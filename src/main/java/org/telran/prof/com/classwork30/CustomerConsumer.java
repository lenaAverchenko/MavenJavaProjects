package org.telran.prof.com.classwork30;

public class CustomerConsumer implements Runnable{

    private  CustomBlockingQueue blockingQueue;

    public CustomerConsumer(CustomBlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        System.out.println("Start consumer");
        while(true) {
            try {
                String take = blockingQueue.take();
                System.out.println(Thread.currentThread().getName() + "Consumer get " + take);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
