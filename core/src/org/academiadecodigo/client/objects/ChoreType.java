package org.academiadecodigo.client.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by codecadet on 23/11/17.
 */
public enum ChoreType {

    CLEAN_ROOM(3, "clean_room"),
    FIND_BROOM(2, "find_broom"),
    WASH_DISHES(4, "dishes"),
    CLEAN_TABLE(1, "clean_table"),
    CLEAN_TOILET(5, "clean_toilet");

    private int choreValues;
    private Sprite sprite;

    ChoreType(int choreValues, String path) {
        this.choreValues = choreValues;
        //this.sprite = new Sprite(new Texture(Gdx.files.internal(path + ".png")));
    }


    public static ChoreType getRandomChore() {
        return values()[(int) (Math.random() * values().length)];
    }

    public static ChoreType[] getlowChores() {
        return new ChoreType[]{CLEAN_ROOM, FIND_BROOM, CLEAN_TABLE};
    }

    public Sprite getSprite() {
        return sprite;
    }

    public int getValue() {
        return choreValues;
    }
}
