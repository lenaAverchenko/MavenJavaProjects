package org.telran.prof.com.classwork29;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterAtomic extends  Thread {
    private AtomicInteger counter = new AtomicInteger();

    @Override
    public void run(){
        int max = 1000000;
        for (int i = 0; i < max; i++) {
            counter.addAndGet(1);
        }
    }

    public int getCounter() {
        return counter.get();
    }
}
