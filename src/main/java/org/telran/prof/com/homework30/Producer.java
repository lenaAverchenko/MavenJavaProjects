package org.telran.prof.com.homework30;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // produce messages
        for (int idx = 0; idx < 50; idx++) {
            Message msg = new Message("" + idx);
            try {
                Thread.sleep(idx * 100);
                queue.put(msg);
                System.out.println("Produced " + msg.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
            System.out.println("Produced " + msg.getMsg());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
