package org.academiadecodigo.client.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Someone who is not me on 24/11/17.
 */
public class Enemy extends Character {


    public Enemy() {
        super(new Sprite(new Texture(Gdx.files.internal("PlayerOne.png"))));

        initialPositioning();
    }

    private void initialPositioning() {

        getSprite().setPosition(940, 100);
    }

    @Override
    void move() {

    }

    @Override
    void dispose() {

    }
}
