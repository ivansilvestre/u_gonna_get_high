package org.academiadecodigo.client;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by codecadet on 23/11/17.
 */
public class SoundEffects {

    public static Music mainSound;

    public static Sound smokeWeed;
    public static Sound cops;
    public static Sound catchItem;
    public static Sound smokeWeedEveryday;
    public static Sound fWhereIsMyDealer;
    public static Sound gettingSober;
    public static Sound yeah;


    public static void playMusic() {

        playSound();
        mainSound = Gdx.audio.newMusic(Gdx.files.internal("sound/becauseIGotHigh.mp3"));
        mainSound.play();
        mainSound.setLooping(true);
    }

    public static void playSound() {

        //WITH WEED
        smokeWeed = Gdx.audio.newSound(Gdx.files.internal("sound/inspire.mp3"));
        //smokeWeed.play();
        smokeWeedEveryday = Gdx.audio.newSound(Gdx.files.internal("sound/smokeWeedEveryDay.mp3"));
        //smokeWeedEveryday.play();
        yeah = Gdx.audio.newSound(Gdx.files.internal("sound/yeah.mp3"));
        // yeah.setVolume(2,2);
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

    public static void playWeedPickUp() {

        int rand = (int) (Math.random() * 3);

        if (rand == 0) {
            smokeWeed.play();
        }

        if (rand == 1) {
            smokeWeedEveryday.play();
        }

        if (rand == 2) {
            yeah.play();
        }

    }
}
