package org.telran.prof.com.classwork32;

import java.util.concurrent.Callable;

public class ArrCallable implements Callable<Integer> {
    private int[] array;

    public ArrCallable(int[] array) {
        this.array = array;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        int sum = 0;
        for (Integer element:array) {
            sum = sum + element;
        }
        return sum;
    }
}
