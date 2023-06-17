package org.telran.prof.com.homework31_32.exchanger;

import java.util.concurrent.Callable;
import java.util.concurrent.Exchanger;

public class InfoTransfer implements Callable<String> {
    private String str;
    private int numberOfInfoTransfer;
    private Exchanger exchanger;

    public InfoTransfer(String str, int numberOfInfoTransfer, Exchanger exchanger) {
        this.str = str;
        this.numberOfInfoTransfer = numberOfInfoTransfer;
        this.exchanger = exchanger;
    }

    public int getNumberOfInfoTransfer() {
        return numberOfInfoTransfer;
    }

    public void setNumberOfInfoTransfer(int numberOfInfoTransfer) {
        this.numberOfInfoTransfer = numberOfInfoTransfer;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Exchanger getExchanger() {
        return exchanger;
    }

    public void setExchanger(Exchanger exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public String call() {
        try {
            System.out.println("Info " + str + " has left the initial point with the "
                    + numberOfInfoTransfer + " transfer " + Thread.currentThread().getName());
            // если время задержки поставить одинаковое, то информационные потоки прибудут в т.обмена большим объемом.
            // они все также поменяются информацией, но уже не в числовой последовательности
            // например, вместо 1->2 и 2->1
            // можем получить: 3->10, 10->3
            // обмен произойдет, но не последовательно
            Thread.sleep(1000L * numberOfInfoTransfer);
            System.out.println("Info " + numberOfInfoTransfer + " is in the point for change");
            str = exchanger.exchange(str).toString();
            System.out.println("Info has been switched");
            Thread.sleep(500);
            System.out.println("" + numberOfInfoTransfer + " transfer " + "has transferred " + str + " info to the final point");
            return ("Info " + str + " has been successfully transferred with the transfer " + numberOfInfoTransfer);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
