package ch.crepe.game.Screens;

import ch.crepe.game.*;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.audio.Playlist;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class GameScreen extends ScreenAdapter {
    private GameController controller;
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    private final HeadUpDisplay hud;
    private final PauseOverlay pauseOverlay;
    private static final float WORLD_WIDTH = 96;
    private static final float WORLD_HEIGHT = 54;
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    private static final Music[] musics = {
            Music.aloneAgainstEnemy,
            Music.deathMatch,
            Music.battleInTheStars,
            Music.epicEnd,
            Music.rainOfLasers,
            Music.spaceHeroes,
            Music.withoutFear
    };
    public GameScreen(Spaceship3000 parent){
        this.controller = new GameController();
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
        this.pauseOverlay = new PauseOverlay(parent, this);



    }

    @Override
    public void show() {
        Playlist musicPlaylist = new Playlist(musics);
        musicPlaylist.shuffle();
        parent.getAudioManager().loadPlaylist(musicPlaylist);
        parent.getAudioManager().resumeMusic();

        backgroundSprite.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        backgroundSprite.setPosition(-WORLD_WIDTH/2f,-WORLD_HEIGHT/2f);



        Gdx.input.setInputProcessor(controller.getPlayerInput());
    }

    @Override
    public void render(float delta) {
        if(controller.getGameInfo().getState() == GameInfo.GameState.playing){
                updateGame(delta);
                drawGame();
        }else if(controller.getGameInfo().getState() == GameInfo.GameState.pause){
            Gdx.gl.glClearColor(0f, 0f, 0f, 0.1f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            drawPauseMenu();
        }

    }

    private void updateGame(float delta){
        controller.update(delta);
    }
    private void drawGame(){
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        parent.getBatch().setProjectionMatrix(viewport.getCamera().combined);


        parent.getBatch().begin();
        backgroundSprite.draw(parent.getBatch());
        for (Entity entity : controller.getEntities()) {
            entity.draw(parent.getBatch());
        }
        controller.getPlayerShip().draw(parent.getBatch());
        parent.getBatch().end();

        hud.draw();
    }

    private void drawPauseMenu(){
        pauseOverlay.draw(parent.getBatch());
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        pauseOverlay.update(width,height);
        hud.update(width, height);
    }

    public void pauseGame(){
        Gdx.input.setInputProcessor(pauseOverlay.getInputProcessor());
        controller.getGameInfo().setState(GameInfo.GameState.pause);
    }

    public void resumeGame(){
        Gdx.input.setInputProcessor(controller.getPlayerInput());
        controller.getGameInfo().setState(GameInfo.GameState.playing);
    }
}
