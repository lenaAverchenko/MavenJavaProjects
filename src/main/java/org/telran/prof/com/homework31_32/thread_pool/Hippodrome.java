package org.telran.prof.com.homework31_32.thread_pool;

public class Hippodrome {

    private double length;
    private int treadmill;

    public Hippodrome(double length, int treadmill) {
        this.length = length;
        this.treadmill = treadmill;
    }

    public double getLength() {
        return length;
    }

    public int getTreadmill() {
        return treadmill;
    }

    @Override
    public String toString() {
        return "Hippodrome{" +
                "length=" + length +
                ", treadmill=" + treadmill +
                '}';
    }
}
