package org.telran.prof.com.classwork29;

public class CounterClassic extends Thread{
    private  int counter = 0;

    @Override
    public void run(){
        int max = 1000000;
        for (int i = 0; i < max; i++) {
            counter ++;
        }
    }

    public int getCounter() {
        return counter;
    }
}
