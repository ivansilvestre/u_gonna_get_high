package org.academiadecodigo.client.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

/**
 * Created by codecadet on 23/11/17.
 */
public class Weed extends GameObjects {

    private WeedType weedType;
    private Rectangle rectangle;


    public Weed(WeedType weedType, float posX, float posY) {

        super(new Sprite(new Texture(Gdx.files.internal("baggreen.png"))));
        this.weedType = weedType;
        getSprite().setX(posX);
        getSprite().setY(posY);

        rectangle = new Rectangle(getSprite().getX(), getSprite().getY(), 25, 25);
    }

    public WeedType getWeedType() {
        return weedType;
    }

    @Override
    protected void move() {

    }

    @Override
    protected void dispose() {
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
