package org.telran.prof.com.homework29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirewallEventListenerTest {

    EventCreator eventCreator = new EventCreator(2);
    Logger logger = new Logger();
    FirewallEventListener firewallEventListener = new FirewallEventListener("Listener", eventCreator.getEventList(), logger);

    @Test
    void run() throws InterruptedException {
        Thread thread = new Thread(eventCreator);
        thread.start();
        Thread.sleep(500);
        eventCreator.stop();
        Thread.sleep(1000);
        Thread thread1 = new Thread(firewallEventListener);
        thread1.start();
        Thread.sleep(1000);
        Assertions.assertFalse(logger.getBuffer().isEmpty());
    }
}