package org.telran.prof.com.fromhomework27;

public class Horse implements Runnable{
    private String name;
    private double step;

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", step=" + step +
                '}';
    }

    public Horse(String name, double step) {
        this.name = name;
        this.step = step;
    }

    @Override
    public void run() {
        double result = 0;
        while(result <= HippodromeApp.RACE_LENGTH){
            result +=step;
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        HippodromeApp.resultMap.put(this, System.currentTimeMillis());
    }
}
