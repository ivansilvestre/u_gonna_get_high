package org.academiadecodigo.client.objects;

/**
 * Created by codecadet on 24/11/17.
 */
public enum WeedType {

    CINDERELA99(3),
    CRITICAL(2),
    SKUNK(1);

    private int intensity;

    WeedType(int intensity) {
        this.intensity = intensity;

    }

    public static WeedType getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }

    public int getIntensity() {
        return intensity;
    }
}
