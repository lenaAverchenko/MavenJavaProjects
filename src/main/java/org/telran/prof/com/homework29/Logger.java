package org.telran.prof.com.homework29;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Logger implements Runnable {
    List<String> buffer = new ArrayList<>();
    private AtomicInteger counter = new AtomicInteger();

    public AtomicInteger getCounter() {
        return counter;
    }

    public void setCounter(AtomicInteger counter) {
        this.counter = counter;
    }

    public List<String> getBuffer() {
        return buffer;
    }

    public void log(String str) {
        buffer.add(str);
    }

    //Если размер лога больше не увеличивается, значит, в него ольше ничего не добавляют, и можно вывести результат
    @Override
    public void run() {
        int difference = 1;
        while (difference != 0) {
            int prevSize = buffer.size();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int currSize = buffer.size();
            difference = currSize - prevSize;
        }
        buffer.forEach(System.out::println);
    }
}
