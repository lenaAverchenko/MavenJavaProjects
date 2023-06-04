package org.telran.prof.com.homework29;

public class EventApp {
    public static void main(String[] args) throws InterruptedException {
        EventCreator eventCreator = new EventCreator(10);
        Thread threadEvent = new Thread(eventCreator);
        threadEvent.start();
        Thread.sleep(450);
        // Можно сделать через прервание потока и встроенный индикатор
        eventCreator.stop();
        Thread.sleep(1000);
        //Просто для проверки
        System.out.println(eventCreator.getEventList());
        System.out.println("_______________________________");
        Logger logger = new Logger();
        FirewallEventListener listener1 = new FirewallEventListener("ListenerOne", eventCreator.getEventList(), logger);
        FirewallEventListener listener2 = new FirewallEventListener("ListenerTwo", eventCreator.getEventList(), logger);
        FirewallEventListener listener3 = new FirewallEventListener("ListenerThree", eventCreator.getEventList(), logger);
        FirewallEventListener listener4 = new FirewallEventListener("ListenerFour", eventCreator.getEventList(), logger);

        Thread thread1 = new Thread(listener1);
        Thread thread2 = new Thread(listener2);
        Thread thread3 = new Thread(listener3);
        Thread thread4 = new Thread(listener4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        Thread.sleep(1000);
        Thread loggerThread = new Thread(logger);
        loggerThread.start();
    }
}
