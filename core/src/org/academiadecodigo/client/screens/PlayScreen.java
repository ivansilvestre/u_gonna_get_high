package org.academiadecodigo.client.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import org.academiadecodigo.client.GameLogic;
import org.academiadecodigo.client.characters.Dealer;
import org.academiadecodigo.client.characters.Enemy;
import org.academiadecodigo.client.characters.Player;



/**
 * Created by codecadet on 23/11/17.
 */
public class PlayScreen extends ScreenAdapter {

    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;

    Texture img;
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;

    private Array<Rectangle> walls;


    private Stage gameStage;

    private Player player;

    private TextureMapObject object;


    public PlayScreen(Player player, Enemy enemy, Dealer dealer) {

        this.walls = new Array<Rectangle>();

        this.player = player;
        gameStage = new Stage();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, GameLogic.WIDTH, GameLogic.HEIGHT);
        camera.update();

        tiledMap = new TmxMapLoader().load("mapa_principal.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
        // Gdx.input.setInputProcessor(this);
        //player.setCamera(camera);
        gameStage.addActor(player);
        gameStage.addActor(enemy);
        gameStage.addActor(dealer);
        tiledMapRenderer.setView(camera);


    }


    @Override
    public void render(float delta) {

        gameStage.act();

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();

        tiledMapRenderer.render();

        gameStage.draw();
    }

    @Override
    public void show() {

        renderer = new OrthogonalTiledMapRenderer(map, 1 / 10f);
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false, width / 10, height / 10);
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
