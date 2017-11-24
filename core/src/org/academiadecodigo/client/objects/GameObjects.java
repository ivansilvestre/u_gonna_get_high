package org.academiadecodigo.client.objects;


import com.badlogic.gdx.graphics.g2d.Sprite;
import org.academiadecodigo.client.characters.Character;

/**
 * Created by codecadet on 23/11/17.
 */
public abstract class GameObjects extends Character{

    private Sprite sprite;


    public GameObjects(Sprite sprite) {
        super(sprite);
    }

    public void collect() {

    }

    public void draw() {

    }


}
