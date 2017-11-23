package org.academiadecodigo.client.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import org.academiadecodigo.client.GameLogic;


/**
 * Created by codecadet on 23/11/17.
 */
public class PlayScreen implements Screen {

    private GameLogic game;
    private OrthographicCamera camera;
    private Viewport gamePort;
    private int noZaxis = 0;

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    public PlayScreen(GameLogic game) {
        this.game = game;
        camera = new OrthographicCamera();
        gamePort = new FitViewport(GameLogic.WIDTH, GameLogic.HEIGHT);

        // create HUD

        maploader = new TmxMapLoader();
        System.out.println(maploader);
        map = maploader.load("mapa_principal.tmx");
        renderer = new OrthogonalTiledMapRenderer(map);
        camera.position.set(gamePort.getScreenWidth() / 2, gamePort.getScreenHeight() / 2, noZaxis);

    }

    public void update(float dt){

        renderer.setView(camera);
    }

    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {

        renderer.render();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
