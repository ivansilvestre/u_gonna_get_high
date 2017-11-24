package org.academiadecodigo.client.characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 23/11/17.
 */
public abstract class Character {

    private Sprite sprite;
    private Rectangle bounds;

    public Character(Sprite sprite) {

        this.sprite = sprite;
        bounds = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    abstract void move();


    abstract void draw();



    abstract void dispose();


    public Sprite getSprite() {
        return sprite;
    }

    public Rectangle getBounds() {
        return bounds;
    }
}
