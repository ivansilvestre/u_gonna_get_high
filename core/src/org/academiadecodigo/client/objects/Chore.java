package org.academiadecodigo.client.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 23/11/17.
 */
public class Chore extends GameObjects {

    private ChoreType choreType;


    public Chore(ChoreType choreType, float posX, float posY) {

        super(new Sprite(new Texture(Gdx.files.internal("aspirador.png"))));

        this.choreType = choreType;
        //this.bounds = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
        getSprite().setX(posX);
        getSprite().setY(posY);
    }

    public ChoreType getChoreType() {
        return choreType;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void dispose() {

    }
}
