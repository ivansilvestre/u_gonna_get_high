package org.academiadecodigo.client.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import org.academiadecodigo.Constants;
import org.academiadecodigo.client.GameLogic;


public class Player extends Character {

    private float speed;

    private Rectangle rectangle;
    private GameLogic game;

    public Player(GameLogic game) {

        super(new Sprite(new Texture(Gdx.files.internal("PlayerTwo.png"))));

        this.game = game;
        speed = 2f;
        initialPositioning();

        rectangle = new Rectangle(getSprite().getX(), getSprite().getY(), 50, 50);

    }

    private void initialPositioning() {

        getSprite().setPosition(10, 100);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    @Override
    public void move() {


        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            moveDown();
            getSprite().setRotation(0);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            moveUp();
            getSprite().setRotation(180);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
           moveLeft();
            getSprite().setRotation(-90);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            moveRight();
            getSprite().setRotation(90);
        }

    }

    private void moveUp() {

        if (boundarieCollision(getSprite().getX(), getSprite().getY() + speed)) {
            return;
        }

        translate(0, speed);
        sendPosition();
    }

    private void moveDown() {

        if (boundarieCollision(getSprite().getX(), getSprite().getY() - speed)) {
            return;
        }

        translate(0, -speed);
        sendPosition();
    }


    private void moveLeft() {
        if (boundarieCollision(getSprite().getX() - speed, getSprite().getY())) {
            return;
        }

        translate(-speed,0);
        sendPosition();
    }

    private void moveRight() {
        if (boundarieCollision(getSprite().getX() + speed, getSprite().getY())) {
            return;
        }

        translate(speed, 0);
        sendPosition();
    }

    private void sendPosition() {
        game.sendPosition();
    }

    private boolean boundarieCollision(float x, float y) {

        return x <= Constants.LEFT_HOUSE_X || (x >= Constants.LEFT_HOUSE_X + Constants.HOUSE_WIDTH - 25 && x <= 200 && (y <= 330 || y >= 355)) ||
                y <= Constants.HOUSE_Y || y >= Constants.HOUSE_Y + Constants.HOUSE_HEIGHT - 25 || x >= 325;
    }




    @Override
    public void act(float delta) {
        super.act(delta);
        move();
    }

    @Override
    public void dispose() {

    }

    public void translate(float x, float y) {

        getSprite().setPosition(getSprite().getX() + x, getSprite().getY() + y);
        //getBounds().setPosition(getSprite().getX(), getSprite().getY());

    }

}
