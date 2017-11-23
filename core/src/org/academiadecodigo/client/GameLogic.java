package org.academiadecodigo.client;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameLogic extends Game {

    SpriteBatch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //updates

        // drawing
        batch.begin();

        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();
    }
}
