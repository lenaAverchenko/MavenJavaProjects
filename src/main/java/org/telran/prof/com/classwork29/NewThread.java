package org.telran.prof.com.classwork29;

public class NewThread extends Thread{
    private  Object monitor;
    private long num;

    public NewThread (long num) {
        this.num = num;
        monitor = new Object();
    }

    public NewThread (long num, Object monitor) {
        this.num = num;
        this.monitor = monitor;
    }

    @Override
    public void run(){
        synchronized (monitor){
            System.out.println("" + num + " Захватил монитор. Ожидание");
            try {
                Thread.sleep(2000);
                System.out.println(num + " Подождал");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
