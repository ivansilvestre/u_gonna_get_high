package org.academiadecodigo.client;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Dealer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Enemy;
import org.academiadecodigo.client.characters.Player;
import org.academiadecodigo.client.objects.Chore;
import org.academiadecodigo.client.objects.ChoreType;
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

    private List<Chore> chores;
    private List<Chore> enemyChores;

    public static boolean started;

    public GameLogic() {

        chores = new LinkedList<Chore>();
        enemyChores = new LinkedList<Chore>();

        started = false;
        weeds = new LinkedList<Weed>();
        enemyWeeds = new LinkedList<Weed>();
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

    public void start() {
        started = true;
    }

    public static boolean isStarted() {
        return started;
    }

    private void checkCollisions() {

        ListIterator<Weed> iterator = weeds.listIterator();
        while (iterator.hasNext()) {

            Weed w = iterator.next();

            if (w.getSprite().getX() <= player.getSprite().getX() && w.getSprite().getX() + w.getSprite().getWidth() + 10 >= player.getSprite().getX() + 10 &&
                    w.getSprite().getY() <= player.getSprite().getY() && w.getSprite().getY() + 15 >= player.getSprite().getY()) {

                if (hud.getP1_score() - 10 < 0) {
                    continue;
                }

                hud.setP1_dope(hud.getP1_dope() + w.getWeedType().getIntensity() * 10);
                hud.setP1_score(hud.getP1_score() - 10);

                w.remove();
                SoundEffects.playWeedPickUp();
                iterator.remove();

            }
        }

        ListIterator<Chore> choreIterator = chores.listIterator();
        while (choreIterator.hasNext()) {

            Chore w = choreIterator.next();

            if (w.getSprite().getX() <= player.getSprite().getX() && w.getSprite().getX() + 25 >= player.getSprite().getX() + 10 &&
                    w.getSprite().getY() <= player.getSprite().getY() && w.getSprite().getY() + 15 >= player.getSprite().getY()) {

                w.remove();
                hud.setP1_score(hud.getP1_score() + w.getChoreType().getValue() * 10);

                choreIterator.remove();

            }
        }
        /*iterator = enemyWeeds.listIterator();

        while (iterator.hasNext()) {

            Weed w = iterator.next();

            if ( 975 - w.getSprite().getX() <= enemy.getSprite().getX() && 975 - w.getSprite().getX() + w.getSprite().getWidth() + 10 >= enemy.getSprite().getX() + 10 &&
                    w.getSprite().getY() <= enemy.getSprite().getY() && w.getSprite().getY() + 15 >= enemy.getSprite().getY()) {

<<<<<<< HEAD
                System.out.println();
=======
                hud.setP2_dope(hud.getP2_dope()+w.getWeedType().getIntensity());

>>>>>>> 714bebc688218482e9ac99f34b8d0fdfcbe44481
                w.remove();
                SoundEffects.playWeedPickUp();
                iterator.remove();

            }
        }*/

    }

    @Override
    public void render() {

        checkCollisions();

        //updates
        // drawing
        batch.begin();
        playScreen.render(0);
        //////////////////////////////////////////////////updates


        // drawing

        hud.update(0.02f);
        hud.updateDope( 0.000001f);
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

    public void spawnWeed(final int weedType, final int x, final int y) {

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

    public void spawnObject(Integer taskType, Integer x, Integer y) {

        Gdx.app.postRunnable(new Runnable() {
            public void run() {
                ChoreType type = ChoreType.values()[taskType];
                Chore chore = new Chore(type, x, y);
                chores.add(chore);

                playScreen.addActor(chore);

                Chore enemyChore = new Chore(type, 980 - x, y);
                enemyChores.add(enemyChore);

                playScreen.addActor(enemyChore);

            }
        });
    }

}
