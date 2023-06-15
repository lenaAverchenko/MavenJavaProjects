package org.telran.prof.com.classwork32.arr;

import java.util.concurrent.Callable;

public class ArrCallable implements Callable<Integer> {
    private int[] array;
    private int start;
    private int end;

    public ArrCallable(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}
