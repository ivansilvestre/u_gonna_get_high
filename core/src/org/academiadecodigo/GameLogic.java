package org.academiadecodigo;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Player;

public class GameLogic extends Game {

    private SpriteBatch batch;
    private Player player;

    public GameLogic() {

    }

    @Override
    public void create() {

        batch = new SpriteBatch();
        this.player = new Player(batch);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //////////////////////////////////////////////////updates

        player.move();

        // drawing
        batch.begin();
        player.draw();

        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();
    }
}
