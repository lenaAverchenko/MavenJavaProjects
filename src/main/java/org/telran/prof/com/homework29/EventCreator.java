package org.telran.prof.com.homework29;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class EventCreator implements Runnable {

    private List<Event> eventList = new ArrayList<>();
    private int numberOfUsers;
    private int counterIndex;
    private boolean stopIndicator = false;

    public List<Event> getEventList() {
        return eventList;
    }

    public EventCreator(int numberOfUsers) {
        this.numberOfUsers = numberOfUsers;
    }

    public void setStopIndicator(boolean stopIndicator) {
        this.stopIndicator = stopIndicator;
    }

    public boolean stop() {
        stopIndicator = true;
        return stopIndicator;
    }

    @Override
    public String toString() {
        return "EventCreator{" +
                "eventList=" + eventList +
                '}';
    }

    //Я не поняла, что должен делать каждый пользователь в данном случае, поэтому предположила, что он совершает некие
    // действия, в связи с чем меняется состояние события. Рандомный пользователь получает рандомный досуп к чему-то, например
    @Override
    public void run() {
        String userName = "";
        String userIp = "";
        Random random = new Random();
        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberOfUsers; i++) {
            userName = "User" + i;
            userIp = "192.1.0." + i;
            users.add(new User(userName, userIp));
        }
        while (!stopIndicator) {
            int pickedUser = random.nextInt(0, numberOfUsers);
            LocalDate date = LocalDate.now();
            int pickedState = random.nextInt(0, 3);
            synchronized (eventList) {
                eventList.add(new Event(counterIndex, users.get(pickedUser), date, EventState.values()[pickedState]));
                counterIndex++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
