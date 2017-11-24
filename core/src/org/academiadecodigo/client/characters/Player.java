package org.academiadecodigo.client.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;


public class Player extends Character {

    private float speed;

    public Player() {

        super(new Sprite(new Texture(Gdx.files.internal("afro.png"))));

        speed = 2f;
        initialPositioning();

    }

    private void initialPositioning() {

        getSprite().setPosition(0, (Gdx.graphics.getHeight() / 2) - getSprite().getHeight() / 2);
    }


    @Override
    public void move() {

        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            translate(0, -speed);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            translate(0, speed);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            translate(-speed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            translate(speed, 0);
        }

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        super.draw(batch, parentAlpha);
        batch.draw(getSprite(), getSprite().getX(), getSprite().getY(), getSprite().getRegionWidth() * 0.25f,
                getSprite().getRegionHeight() * 0.25f);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        move();
    }

    @Override
    void dispose() {

    }

    public void translate(float x, float y) {

        getSprite().setPosition(getSprite().getX() + x, getSprite().getY() + y);
        System.out.println(getSprite().getX() + "--" + getSprite().getY());
        getBounds().setPosition(getSprite().getX(), getSprite().getY());

    }
}
