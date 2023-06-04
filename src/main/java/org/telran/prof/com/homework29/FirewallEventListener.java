package org.telran.prof.com.homework29;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class FirewallEventListener implements Runnable {
    private List<Event> events;
    private Logger logger;
    private int counter;

    private String nameOfListener;

    public FirewallEventListener(String nameOfListener, List<Event> events, Logger logger) {
        this.nameOfListener = nameOfListener;
        this.events = events;
        this.logger = logger;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        while (logger.getCounter().get() < events.size()) {
            AtomicInteger currentIndex = logger.getCounter();
            //нельзя, чтобы несколько потоков имели доступ к одному и тому же элементу списка с событиями
            // в целом, этого и не произойдет, если будет синхронизирована перезапись счетчика
            synchronized (events.get(currentIndex.get())) {
                // нельзя, чтобы несколько потоков добавляли одновременно данные в 1 буфер, тогда будет по 4 записи
                // от одного события, добавленные каждым отдельным потоком
                synchronized (logger.getBuffer()) {
                    //убирая тут проверку, какие-то потоки все равно доходят до текущего места
                    if (currentIndex.get() >= events.size()) {
                        break;
                    }
                    logger.log("Обработчик " + nameOfListener + " " + events.get(currentIndex.get()).getEventId() + " " + events.get(currentIndex.get()).getUser().getUserName());
                    logger.log("Обработчик " + nameOfListener + " " + events.get(currentIndex.get()).getEventId() + " " + events.get(currentIndex.get()).getUser().getUserIp());
                    logger.log("Обработчик " + nameOfListener + " " + events.get(currentIndex.get()).getEventId() + " " + events.get(currentIndex.get()).getEventDate());
                    logger.log("Обработчик " + nameOfListener + " " + events.get(currentIndex.get()).getEventId() + " " + events.get(currentIndex.get()).getEventState());
                    // не уверена, что так можно сделать, но если другие потоки будут знать, что
                    logger.getCounter().getAndIncrement();
                }
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
