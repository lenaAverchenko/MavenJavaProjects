package org.telran.prof.com.homework29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventCreatorTest {
    private EventCreator eventCreator = new EventCreator(2);

    @BeforeEach
    void init() {
        eventCreator.setStopIndicator(false);
    }

    @Test
    void stop() {
        Assertions.assertEquals(true, eventCreator.stop());
    }

    @Test
    void run() throws InterruptedException {
        Thread thread = new Thread(eventCreator);
        thread.start();
        Thread.sleep(500);
        eventCreator.stop();
        Thread.sleep(1000);
        boolean isEmpty = eventCreator.getEventList().isEmpty();
        Assertions.assertEquals(false, isEmpty);
    }
}