package org.academiadecodigo.client.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Someone who is not me on 24/11/17.
 */
public class Dealear extends Character {

    private int speed;
    private SpriteBatch batch;

    public Dealear(Sprite sprite) {

        super(new Sprite(new Texture(Gdx.files.internal("dealer.png"))));
        this.batch = batch;
        speed = 2;
    }

    private void initialPositioning() {

        getSprite().setPosition(0, (Gdx.graphics.getHeight() / 2) - getSprite().getHeight() / 2);
    }

    @Override
    public void move() {

    }

    @Override
    public void dispose() {

    }
}
