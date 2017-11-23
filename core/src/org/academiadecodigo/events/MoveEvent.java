package org.academiadecodigo.events;

/**
 * Created by codecadet on 23/11/17.
 */
public class MoveEvent extends Event {

    private int x;
    private int y;

    public MoveEvent(int x, int y) {
        super(EventType.PLAYER_MOVE);
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.valueOf(x) + " " + String.valueOf(y);
    }
}
