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
    private Sound catchItem;
    private Sound smokeWeedEveryday;
    private Sound fWhereIsMyDealer;
    private Sound gettingSober;
    private Sound yeah;


    public void playMusic() {

        mainSound = Gdx.audio.newMusic(Gdx.files.internal("sound/becauseIGotHigh.mp3"));
        //  mainSound.play();
        // mainSound.setLooping(true);
    }

    public void playSound() {

        //WITH WEED
        smokeWeed = Gdx.audio.newSound(Gdx.files.internal("sound/inspire.mp3"));
        //smokeWeed.play();
        smokeWeedEveryday = Gdx.audio.newSound(Gdx.files.internal("sound/smokeWeedEveryDay.mp3"));
        //smokeWeedEveryday.play();
        yeah = Gdx.audio.newSound(Gdx.files.internal("sound/yeah.mp3"));
        //yeah.play();

        //MISSING WEED
        fWhereIsMyDealer = Gdx.audio.newSound(Gdx.files.internal("sound/fWhereIsMyDealer.mp3"));
        //fWhereIsMyDealer.play();
        gettingSober = Gdx.audio.newSound(Gdx.files.internal("sound/gettingSober.mp3"));
        //gettingSober.play();


        cops = Gdx.audio.newSound(Gdx.files.internal("sound/siren.mp3"));
        // cops.play();

        catchItem = Gdx.audio.newSound(Gdx.files.internal("sound/catchItem.mp3"));
        // catchItem.play();
    }
}
