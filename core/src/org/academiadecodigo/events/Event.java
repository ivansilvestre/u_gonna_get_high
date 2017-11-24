package org.academiadecodigo.events;

/**
 * Created by codecadet on 23/11/17.
 */
public abstract class Event {

    private EventType eventType;

    public Event(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return String.valueOf(eventType.ordinal());
    }
}
