package org.telran.prof.com.classwork32.callable;

import java.util.concurrent.Callable;

public class ExampleCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Hello" + Thread.currentThread().getName();
    }
}
