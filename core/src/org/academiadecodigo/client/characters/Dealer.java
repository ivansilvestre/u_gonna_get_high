package org.academiadecodigo.client.characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Someone who is not me on 24/11/17.
 */
public class Dealer extends Character{

    private int speed;
    private volatile boolean stopMovement = false;
    private int rotation = 0;
    public Dealer() {

        super(new Sprite(new Texture(Gdx.files.internal("gorro.png"))));
        speed = 2;
        initialPositioning();

    }

    private void initialPositioning() {

        getSprite().setPosition( 500 - 25 , Gdx.graphics.getHeight() );

    }

    @Override
    public void move() {



    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        super.draw(batch, parentAlpha);
        if (stopMovement) {
            return;
        }

        if(getSprite().getY() > Gdx.graphics.getHeight() || getSprite().getY()  < 0) {

            speed = speed * -1;
            stopMovement = true;

            rotation = 180;
            getSprite().setRotation(rotation);

            new Timer().schedule(new TimerTask() {

                @Override
                public void run() {

                    stopMovement = false;
                }
            }, 10000);

        }
        if(speed > 0){
            rotation = 0;
        }
        getSprite().setRotation(rotation);

    }

    @Override
    public void act(float delta) {

        super.act(delta);
        translate(speed);
    }

    @Override
    public void dispose() {

    }
    public void translate(float y) {

        getSprite().setPosition(getSprite().getX(), getSprite().getY() - y);

    }
}
