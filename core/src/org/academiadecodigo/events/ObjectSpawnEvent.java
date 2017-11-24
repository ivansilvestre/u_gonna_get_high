package org.academiadecodigo.events;

import org.academiadecodigo.client.ObjectType;

/**
 * Created by codecadet on 23/11/17.
 */
public class ObjectSpawnEvent extends Event{

    private ObjectType objectType;
    private int objectLevel;
    private int x;
    private int y;

    public ObjectSpawnEvent(ObjectType objectType, int objectLevel, int x, int y) {
        super(EventType.OBJECT_SPAWN);
        this.objectType = objectType;
        this.objectLevel = objectLevel;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return super.toString() + " " + objectType.ordinal() + " " + objectLevel + " " + x + " " + String.valueOf(y);
    }
}
