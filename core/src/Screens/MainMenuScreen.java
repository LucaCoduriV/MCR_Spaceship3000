package Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.MenuAssets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import java.awt.*;

public class MainMenuScreen extends ScreenAdapter {
    OrthographicCamera guiCam;
    Rectangle soundBounds;
    Rectangle playBounds;
    Rectangle highscoresBounds;
    Rectangle helpBounds;
    Vector3 touchPoint;
    AssetsLoader assets;
    Spaceship3000 game;

    public MainMenuScreen(Spaceship3000 game) {
        assets = AssetsLoader.getInstance();
        this.game = game;
        guiCam = new OrthographicCamera(game.getScreenWidth(), game.getScreenHeight());
        guiCam.position.set(320 / 2, 480 / 2, 0);
        soundBounds = new Rectangle(0, 0, 64, 64);
        playBounds = new Rectangle(160 - 150, 200 + 18, 300, 36);
        highscoresBounds = new Rectangle(160 - 150, 200 - 18, 300, 36);
        helpBounds = new Rectangle(160 - 150, 200 - 18 - 36, 300, 36);
        touchPoint = new Vector3();
    }

    public void update() {
    }

    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(1, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCam.update();
        game.getBatch().setProjectionMatrix(guiCam.combined);

        game.getBatch().disableBlending();
        game.getBatch().begin();
        game.getBatch().draw(MenuAssets.backgroundRegion, 0, 0, 320, 480);
        game.getBatch().end();

        game.getBatch().enableBlending();
        game.getBatch().begin();
        game.getBatch().draw(MenuAssets.logo, 160 - 274 / 2, 480 - 10 - 142, 274, 142);
        game.getBatch().draw(MenuAssets.mainMenu, 10, 200 - 110 / 2, 300, 110);
        game.getBatch().end();
    }

    @Override
    public void render(float delta) {
        update();
        draw();
    }

    @Override
    public void pause() {
//        Settings.save();
    }
}
