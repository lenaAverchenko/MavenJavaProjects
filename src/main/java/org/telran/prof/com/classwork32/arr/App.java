package org.telran.prof.com.classwork32.arr;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] numbers = {1, 5, 4, 7, 8, 9, 2, 3, 6, 5, 4, 78, 51, 21, 63, 13, 20};
//        int[] numbers = {1, 5, 4, 7, 8, 9, 2, 3, 6, 5, 4, 78, 51, 21, 63};
        int sum = 0;
        int div = numbers.length / 3;
        int startIdx = 0;
        int endIdx = div;
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                endIdx = numbers.length - 1;
            }
            FutureTask futureRes = new FutureTask<>(new ArrCallable(numbers, startIdx, endIdx));
            new Thread(futureRes).start();
            sum = sum + (int) futureRes.get();
            startIdx = endIdx + 1;
            endIdx = endIdx + div;
        }
        System.out.println(sum);
    }
}
