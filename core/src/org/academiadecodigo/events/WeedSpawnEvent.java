package org.academiadecodigo.events;

import org.academiadecodigo.client.ObjectType;

/**
 * Created by codecadet on 24/11/17.
 */
public class WeedSpawnEvent extends Event {

    private ObjectType objectType;
    private int objectLevel;
    private int x;
    private int y;

    public WeedSpawnEvent(int objectLevel, int x , int y) {
        super(EventType.WEED_SPAWN);
        this.objectType = objectType;
        this.objectLevel = objectLevel;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString() + " " + objectLevel + " " + String.valueOf(x) + " " + String.valueOf(y);
    }
}
