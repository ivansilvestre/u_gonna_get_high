package org.academiadecodigo.client.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Timer;
import java.util.TimerTask;

public class Score {
    private BitmapFont scoreTextFont;
    private GlyphLayout layout;
    private int score;


    public Score() {

        this.scoreTextFont = new BitmapFont(Gdx.files.internal("myfont.fnt"));
        layout = new GlyphLayout(scoreTextFont, "score ");
    }

    /**
     *
     * @param score
     */
    public void updateScore(int score) {

        layout.setText(scoreTextFont, "score " + score);
        this.score = score;

    }

    /**
     *
     */
    public void drawScore(SpriteBatch batch) {

        this.scoreTextFont.draw(batch, "score " + score,
                (Gdx.graphics.getWidth() - layout.width) / 2,
                Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 15);

    }


    /**
     *
     * @param scoreUpdate
     */
    public void updateSlowly(final int scoreUpdate) {

        if (scoreUpdate <= 0) {

            return;
        }

        updateScore(this.score + 1);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                updateSlowly(scoreUpdate - 1);
            }

        }, 10);
    }
}
