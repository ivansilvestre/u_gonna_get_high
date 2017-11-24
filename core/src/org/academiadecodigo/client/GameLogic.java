package org.academiadecodigo.client;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Player;
import org.academiadecodigo.client.screens.PlayScreen;

public class GameLogic extends Game {

    PlayScreen playScreen;
    public final static int WIDTH = 800;
    public final static int HEIGHT = 640;

    private SpriteBatch batch;
    private Player player;

    public GameLogic() {

    }

    @Override
    public void create() {

        batch = new SpriteBatch();

        this.player = new Player();
        playScreen = new PlayScreen(player);
    }

    @Override
    public void render() {

        //updates
        // drawing
        batch.begin();
        playScreen.render(0);
        //////////////////////////////////////////////////updates








        // drawing
        batch.end();
    }

    @Override
    public void dispose() {

        batch.dispose();
    }
}
