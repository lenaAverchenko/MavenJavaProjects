package org.telran.prof.com.classwork30;

import java.util.LinkedList;
import java.util.List;

public class CustomBlockingQueue {

    private  List<String> queue = new LinkedList();
    private int size;

    public CustomBlockingQueue(int size) {
        this.size = size;
    }

    synchronized void put (String inputData) throws InterruptedException {
        while (queue.size() == size){
            System.out.println("Queue is full. Please wait");
            wait();
        }
        if (queue.size() == 0){
            System.out.println("Queue was empty. Will notify");
            notifyAll();
        }
        System.out.println("Queue is ready.");
        queue.add(inputData);
    }

    synchronized String take () throws InterruptedException {
        while (queue.size() == 0){
            System.out.println("Queue is empty. Please wait");
            wait();
        }
        if (queue.size() == size){
            System.out.println("Queue was full. Will notify");
            notifyAll();
        }
        System.out.println("Queue has an element");
        return queue.remove(0);
    }
}
