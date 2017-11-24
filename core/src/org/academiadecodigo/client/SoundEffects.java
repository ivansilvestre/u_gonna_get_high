package org.academiadecodigo.client;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by codecadet on 23/11/17.
 */
public class SoundEffects {

    private Music mainSound;
    private Sound smokeWeed;
    private Sound cops;

    public void playMusic() {

        mainSound = Gdx.audio.newMusic(Gdx.files.internal("sound/becauseIGotHigh.mp3"));
        mainSound.play();
        mainSound.setLooping(true);
    }

    public void playSound() {

        smokeWeed = Gdx.audio.newSound(Gdx.files.internal("sound/inspire.mp3"));
        smokeWeed.play();

        cops = Gdx.audio.newSound(Gdx.files.internal("sound/siren.mp3"));
        cops.play();
    }
}
