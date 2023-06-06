package org.telran.prof.com.classwork30;

public class CustomQueueApp {
    public static void main(String[] args) {
        CustomBlockingQueue customBlockingQueue = new CustomBlockingQueue(10);
        new Thread(new CustomerConsumer(customBlockingQueue)).start();
//        new Thread(new CustomerConsumer(customBlockingQueue)).start();
//        new Thread(new CustomerConsumer(customBlockingQueue)).start();
        new Thread(new CustomProducer(customBlockingQueue)).start();

    }
}
