package org.academiadecodigo.client;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.screens.PlayScreen;

public class GameLogic extends Game {

    SpriteBatch batch;
    PlayScreen playScreen;
    public final static int WIDTH = 800;
    public final static int HEIGHT = 640;




    @Override
    public void create() {
        batch = new SpriteBatch();

        playScreen = new PlayScreen(this);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //updates
        playScreen.update(0);
        // drawing
        batch.begin();
        playScreen.render(0);
        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();
    }
}
