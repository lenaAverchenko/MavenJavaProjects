package org.telran.prof.com.homework30;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

//        Класс Консьюмер - забирает сообщения из очереди
//        Задача - реализовать класс Consumer, который будет монитором сообщений в очереди,
//        при входящем сообщении "exit" заканчивает работу.

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Message message = new Message("");
        int i = 1;
        while (!"exit".equals(message.getMsg())) {
            try {
                Thread.sleep(100*i);
                    message = queue.take();
                    System.out.println("Monitoring the message: " + message.getMsg());
                    i++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
