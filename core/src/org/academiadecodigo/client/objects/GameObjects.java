package org.academiadecodigo.client.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 23/11/17.
 */
public abstract class GameObjects {

    private float posX;
    private float posY;


    public GameObjects(float posX, float posY) {

        this.posX = posX;
        this.posY = posY;
    }

    public void collect(){

    }

    public void draw(){

    }




}
