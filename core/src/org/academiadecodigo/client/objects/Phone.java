package org.academiadecodigo.client.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 23/11/17.
 */
public class Phone extends GameObjects {

    private Sprite sprite;
    private Rectangle bounds;


    public Phone(float posX, float posY) {

        super(posX, posY);
        this.sprite = new Sprite(new Texture(Gdx.files.internal("phone.png")));
        this.bounds = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());

    }
}
