package org.academiadecodigo.client.characters;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by codecadet on 23/11/17.
 */
public abstract class Character extends Actor {

    private Sprite sprite;
    private Rectangle bounds;
    private float mult;

    public Character(Sprite sprite, float scale) {
        super();
        this.sprite = sprite;
        mult = scale;
    }

    public Character(Sprite sprite) {

        super();
        this.sprite = sprite;
        mult = 0.08f;
    }

    protected abstract void move();


    @Override
    public void draw(Batch batch, float parentAlpha) {

        super.draw(batch, parentAlpha);

        batch.draw(getSprite(), getSprite().getX(), getSprite().getY(), 25, 25, getSprite().getRegionWidth() * mult, getSprite().getRegionHeight() * mult,
                getSprite().getScaleX(), getSprite().getScaleY(), getSprite().getRotation());
    }


    protected abstract void dispose();


    public Sprite getSprite() {
        return sprite;
    }


}
