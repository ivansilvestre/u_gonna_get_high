package org.academiadecodigo.client.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import org.academiadecodigo.client.characters.Player;

public class Placard {

    private BitmapFont scoreBitmapFontName;
    private int score;
    private String scoreString;


    public Placard() {

        score = 0;
        scoreString = "Score: 0";
        scoreBitmapFontName = new BitmapFont(Gdx.files.internal("text.fnt"));
        scoreBitmapFontName.getData().setScale(0.5f, 0.5f);

    }


    public void setScore(int score) {
        this.score += score;
    }

    public void showScore() {
        scoreString = "Score: " + score;
    }

    public int getScore() {
        return this.score;
    }


    public void draw(SpriteBatch batch) {

        scoreBitmapFontName.setColor(0, 0, 0, 1);
        scoreBitmapFontName.draw(batch, scoreString, 200,200);

    }

}
