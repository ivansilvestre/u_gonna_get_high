package org.academiadecodigo.client.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Player extends Character {

    private int speed;
    private SpriteBatch batch;


    public Player(SpriteBatch batch) {

        super(new Sprite(new Texture(Gdx.files.internal("afro.png"))));

        this.batch = batch;
        speed = 2;
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
    public void draw() {

        this.batch.draw(getSprite(), getSprite().getX(), getSprite().getY());
    }

    @Override
    void dispose() {

    }

    public void translate(float x, float y) {

        getSprite().setPosition(getSprite().getX() + x, getSprite().getY() + y);
        getBounds().setPosition(getSprite().getX(), getSprite().getY());

    }
}
