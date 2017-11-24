package org.academiadecodigo.client;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Dealer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Enemy;
import org.academiadecodigo.client.characters.Player;
import org.academiadecodigo.client.screens.Hud;
import org.academiadecodigo.client.objects.Weed;
import org.academiadecodigo.client.objects.WeedType;
import org.academiadecodigo.client.screens.PlayScreen;
import org.academiadecodigo.events.MoveEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class GameLogic extends Game {

    PlayScreen playScreen;
    public final static int WIDTH = 800;
    public final static int HEIGHT = 640;

    private SpriteBatch batch;
    private Player player;
    private Dealer dealer;
    private Enemy enemy;
    private int playerId;
    private Hud hud;
    private ServerListener serverListener;

    private List<Weed> weeds;
    private List<Weed> enemyWeeds;

    public GameLogic() {

        weeds = new LinkedList<>();
        enemyWeeds = new LinkedList<>();
    }

    @Override
    public void create() {

        batch = new SpriteBatch();

        hud = new Hud(batch);

        this.player = new Player(this);
        this.dealer = new Dealer();

        enemy = new Enemy();
        playScreen = new PlayScreen(player, enemy, dealer);

        serverListener = new ServerListener(this);

        new Thread(serverListener).start();

        SoundEffects.playMusic();

    }

    private void checkWeedCollisions() {

        ListIterator<Weed> iterator = weeds.listIterator();
        while (iterator.hasNext()) {

            Weed w = iterator.next();

            if (w.getSprite().getX() <= player.getSprite().getX() && w.getSprite().getX() + w.getSprite().getWidth() + 10 >= player.getSprite().getX() + 10 &&
                    w.getSprite().getY() <= player.getSprite().getY() && w.getSprite().getY() + 15 >= player.getSprite().getY()) {

                w.remove();
                SoundEffects.playWeedPickUp();
                iterator.remove();

            }
        }

        iterator = enemyWeeds.listIterator();

        while (iterator.hasNext()) {

            Weed w = iterator.next();

            if (w.getSprite().getX() <= enemy.getSprite().getX() && w.getSprite().getX() + w.getSprite().getWidth() + 10 >= enemy.getSprite().getX() + 10 &&
                    w.getSprite().getY() <= enemy.getSprite().getY() && w.getSprite().getY() + 15 >= enemy.getSprite().getY()) {

                w.remove();
                SoundEffects.playWeedPickUp();
                iterator.remove();

            }
        }

    }

    @Override
    public void render() {

        checkWeedCollisions();

        //updates
        // drawing
        batch.begin();
        playScreen.render(0);
        //////////////////////////////////////////////////updates


        // drawing

        hud.update(0.02f);
        hud.stage.draw();

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


        enemy.getSprite().setX(950 - x);
        enemy.getSprite().setY(y);
    }

    public void spawnWeed(int weedType, int x, int y) {

        Gdx.app.postRunnable(new Runnable() {
            public void run() {
                WeedType type = WeedType.values()[weedType];
                Weed weed = new Weed(type, x, y);
                weeds.add(weed);

                playScreen.addActor(weed);

                Weed enemyWeed = new Weed(type, 980 - x, y);
                enemyWeeds.add(enemyWeed);

                playScreen.addActor(enemyWeed);

            }
        });

    }

    public List<Weed> getWeeds() {
        return weeds;
    }
}
