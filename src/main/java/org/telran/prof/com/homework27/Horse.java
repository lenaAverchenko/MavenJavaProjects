package org.telran.prof.com.homework27;

import java.util.Random;

public class Horse implements Runnable {

    private String name;
    private double step;
    private Race race;
    private double passedLength = 0;

    Random random = new Random();

    public Horse(String name) {
        this.name = name;
        this.step = random.nextDouble(0.1, 2);
    }

    public String getName() {
        return name;
    }

    public double getStep() {
        return step;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", step=" + step +
                '}';
    }

    public void run() {
        while (passedLength < race.getHippodrome().getLength()) {
            passedLength = passedLength + step;
        }
        if (passedLength >= race.getHippodrome().getLength()) {
            race.getResultMap().put(new Horse(name), System.currentTimeMillis());
        }
    }


}
