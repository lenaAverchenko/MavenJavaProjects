package org.telran.prof.com.classwork27;

public class ThrApp {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        Thread.State state = thread.getState();
        System.out.println(thread);
        System.out.println(thread.getName());
        System.out.println(state);
        printThreadInfo();
    }

    private static void printThreadInfo(){
        Thread thread = Thread.currentThread();
        System.out.println("Info from method " + thread);
    }
}
