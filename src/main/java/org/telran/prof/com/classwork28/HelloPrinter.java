package org.telran.prof.com.classwork28;

public class HelloPrinter implements Runnable{

    //Вывод Хэлло каждые 2 секунды
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("This thread is interrupted, bye!");
                break;
            }
            System.out.println("Hello!" + System.currentTimeMillis());
        }
    }
}
