package org.telran.prof.com.fromhomework27;

import java.util.Date;

public class ResultPrinter implements Runnable{
    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //
            }
            if (HippodromeApp.resultMap.size() == 3){
                HippodromeApp.resultMap.forEach((k,v) -> System.out.println("" + k + " " + new Date(v)));
                Thread.currentThread().interrupt();
            }
        }
    }
}
