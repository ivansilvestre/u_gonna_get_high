package org.academiadecodigo.events;

/**
 * Created by codecadet on 24/11/17.
 */
public class IdAssignEvent extends Event {

    private int id;

    public IdAssignEvent(int id) {
        super(EventType.PLAYER_ASSIGN);
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.valueOf(id);
    }
}
