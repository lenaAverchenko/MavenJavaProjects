package org.telran.prof.com.classwork27;

public class MyThreadAppThree {
    public static void main(String[] args) throws InterruptedException {
        Runnable example = () -> {
            try{
                Thread.sleep(5000);}
            catch (InterruptedException e){
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(example);
        System.out.println("Thread with name " + thread.getName() + " is" + thread.getState()); // перед стартом NEW
        thread.start();
        System.out.println("Thread with name " + thread.getName() + " is" + thread.getState());// после стартом RUNNABLE - запущен, но не успел уснуть
        Thread.sleep(2000);
        System.out.println("Thread with name " + thread.getName() + " is" + thread.getState());// TIMED_WAITED - поток уже уснул
        Thread.sleep(10000);
        System.out.println("Thread with name " + thread.getName() + " is" + thread.getState()); // TERMINATED - когда уже поток закончил работу через 10 сек, задержка у потока 5 сек, успеет закончиться

    }
}
