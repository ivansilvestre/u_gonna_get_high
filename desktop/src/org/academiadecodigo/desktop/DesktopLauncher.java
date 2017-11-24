package org.academiadecodigo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.client.GameLogic;
import org.academiadecodigo.client.SoundEffects;

public class DesktopLauncher {
    public static void main(String[] arg) {

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Stoners";
        config.width = 1000;
        config.height = 720;
        new LwjglApplication(new GameLogic(), config);

    }
}
