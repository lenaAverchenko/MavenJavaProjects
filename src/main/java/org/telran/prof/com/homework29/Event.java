package org.telran.prof.com.homework29;

import java.time.LocalDate;

public class Event {
    private int eventId;
    private User user;
    private LocalDate eventDate;
    private EventState eventState;

    public Event(int eventId, User user, LocalDate eventDate, EventState eventState) {
        this.user = user;
        this.eventDate = eventDate;
        this.eventState = eventState;
        this.eventId = eventId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public EventState getEventState() {
        return eventState;
    }

    public void setEventState(EventState eventState) {
        this.eventState = eventState;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", user=" + user +
                ", eventDate=" + eventDate +
                ", eventState=" + eventState +
                '}';
    }
}
