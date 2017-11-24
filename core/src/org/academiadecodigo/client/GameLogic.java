package org.academiadecodigo.client;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Enemy;
import org.academiadecodigo.client.characters.Player;
import org.academiadecodigo.client.screens.PlayScreen;
import org.academiadecodigo.events.MoveEvent;

public class GameLogic extends Game {

    PlayScreen playScreen;
    public final static int WIDTH = 800;
    public final static int HEIGHT = 640;

    private SpriteBatch batch;
    private Player player;
    private Enemy enemy;
    private int playerId;
    private ServerListener serverListener;

    public GameLogic() {

    }

    @Override
    public void create() {

        batch = new SpriteBatch();

        this.player = new Player(this);
        enemy = new Enemy();
        playScreen = new PlayScreen(player, enemy);

        serverListener = new ServerListener(this);

        new Thread(serverListener).start();

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

    public void sendPosition() {
        int x = (int) player.getSprite().getX();
        int y = (int) player.getSprite().getY();

        serverListener.sendMessage(new MoveEvent(playerId, x, y));
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void movePlayer(int playerId, int x, int y) {

        if (playerId == this.playerId) {
            return;
        }


        // TODO move second player
        enemy.getSprite().setX(950 - x);
        enemy.getSprite().setY(y);
    }
}
