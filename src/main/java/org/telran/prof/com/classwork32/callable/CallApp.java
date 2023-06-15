package org.telran.prof.com.classwork32.callable;

import java.util.concurrent.FutureTask;

public class CallApp {
    public static void main(String[] args) throws Exception {
        FutureTask futureResult = new FutureTask<>(new ExampleCallable());
        new Thread(futureResult).start();
        System.out.println(futureResult.get());
    }
}
