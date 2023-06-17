package org.telran.prof.com.homework31_32.exchanger;

import java.util.concurrent.*;

public class TestApp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        String[] strings = {"First from str1 ", "Second from str2 ", "Third from str3 ",
                "Fourth from str4 ", "Fifth from str5 ", "Sixth from str6 ", "Seventh from str7 ",
                "Eighth from str8 ", "Ninth from str9 ", "Tenth from str10 "};
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            Future<String> stringFuture = executorService.submit(new InfoTransfer(strings[i], (i + 1), exchanger));
        }
        executorService.shutdown();
    }
}
