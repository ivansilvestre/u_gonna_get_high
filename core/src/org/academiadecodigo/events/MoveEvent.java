package org.academiadecodigo.events;

/**
 * Created by codecadet on 23/11/17.
 */
public class MoveEvent extends Event {

    private int x;
    private int y;
    private int playerId;

    public MoveEvent(int playerId, int x, int y) {
        super(EventType.PLAYER_MOVE);
        this.x = x;
        this.y = y;
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return super.toString() + " " + String.valueOf(playerId) + " " + String.valueOf(x) + " " + String.valueOf(y);
    }
}
