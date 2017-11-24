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
    private Sprite sprite;
    private Rectangle bounds;


    public Chore(ChoreType choreType, float posX, float posY) {

        super();

        this.choreType = choreType;
        // this.sprite = new Sprite(new Texture(Gdx.files.internal("chore.png")));
        //this.bounds = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }

    public ChoreType getChoreType() {
        return choreType;
    }
}
