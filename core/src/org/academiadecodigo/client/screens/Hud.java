package org.academiadecodigo.client.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by codecadet on 24/11/17.
 */
public class Hud implements Disposable {

    private int p2_score = 0;
    private int p1_score = 0;

    //Scene2D.ui Stage and its own Viewport for HUD
    public Stage stage;
    private Viewport viewport;

    //Mario money/time Tracking Variables
    private Integer worldTimer;
    private float timeCount;
    private static Integer money;
    private int dopeLevel;
    private SpriteBatch sb;


    //Scene2D widgets
    private Label p2_scoreLabel;
    private Label p1_scoreLabel;
    private Label player2;
    private Label timer;
    private Label TIME;
    private Label player1;

    public Hud(SpriteBatch sb) {
        //define our tracking variables

        this.stage = new Stage();

        worldTimer = 300;
        timeCount = 0;

        money = 0;
        this.sb = sb;


        //setup the HUD viewport using a new camera seperate from our gamecam
        //define our stage using that viewport and our games spritebatch
        //viewport = new FitViewport(MarioBros.V_WIDTH, MarioBros.V_HEIGHT, new OrthographicCamera());
        //stage = new Stage(viewport, sb);

        //define a table used to organize our hud's labels
        Table table = new Table();
        //Top-Align table
        table.top();
        //make the table fill the entire stage
        table.setFillParent(true);

        //define our labels using the String, and a Label style consisting of a font and color
        p2_scoreLabel = new Label(String.format("%01d", p1_score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        p1_scoreLabel = new Label(String.format("%01d", p2_score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player2 = new Label("PLAYER 2", new Label.LabelStyle(new BitmapFont().getData().setScale(1f, 1f), Color.WHITE));
        timer = new Label(String.format("%03d",worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        TIME = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        player1 = new Label("PLAYER 1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        //add our labels to our table, padding the top, and giving them all equal width with expandX
        table.add(player1).expandX().padTop(10);
        table.add(TIME).expandX().padTop(10);
        table.add(player2).expandX().padTop(10);

        //add a second row to our table
        table.row();
        table.add(p1_scoreLabel).expandX();
        table.add(timer).expandX();
        table.add(p2_scoreLabel).expandX();

        //add our table to the stage
        stage.addActor(table);

    }


        public void update(float dt){
            timeCount += dt;
            if(timeCount >= 1){
                if (worldTimer > 0) {
                    worldTimer--;
                } else {
                    boolean timeUp = true;
                }
                timer.setText(String.format("%03d", worldTimer));
                timeCount = 0;
            }
        }
/*
        public static void addScore(int value){
            money += value;
            p1_scoreLabel.setText(String.format("%06d", money));
        }
  */
    @Override
    public void dispose() {
        stage.dispose();
    }

    public void draw() {

    }

}
