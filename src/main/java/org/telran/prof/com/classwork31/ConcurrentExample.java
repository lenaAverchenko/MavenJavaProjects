package org.telran.prof.com.classwork31;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentExample {
    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
    CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
    BlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(10);
}
