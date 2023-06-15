package org.telran.prof.com.classwork32.executors;

import java.util.concurrent.*;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> stringCallable = () -> "Hello " + Thread.currentThread().getName();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            Future<String> submit = executorService.submit(stringCallable);
            System.out.println(submit.get());
        }
        executorService.shutdown();
    }
}
