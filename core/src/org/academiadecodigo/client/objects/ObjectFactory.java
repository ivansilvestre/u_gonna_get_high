package org.academiadecodigo.client.objects;

/**
 * Created by codecadet on 23/11/17.
 */
public abstract class ObjectFactory {

    public static Chore createChore(float posX, float posY) {
        Chore chore = null;

        double difficulty = Math.random();

        if (difficulty <= 0.70) {

            int lowDif = (int) (Math.random() * 3 + 1);
            chore = new Chore(ChoreType.values()[lowDif], posX, posY);
        }

        if (difficulty > 0.70) {

            chore = difficulty > 0.90 ?
                    new Chore(ChoreType.CLEAN_TOILET, posX, posY) : new Chore(ChoreType.WASH_DISHES, posX, posY);
        }
        return chore;
    }


    public static Phone createPhone(float posX, float posY) {

        return new Phone(posX, posY);
    }

    public static Weed creatWeed(float posX, float posY) {

        return new Weed(posX, posY);
    }

}
