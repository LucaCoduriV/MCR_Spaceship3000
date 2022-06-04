package ch.crepe.game.Screens;

import ch.crepe.game.*;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.audio.Playlist;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter {
    private final GameController controller;
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
    private final Background background = new Background(new Vector2(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f),
            new Vector2(WORLD_WIDTH, WORLD_HEIGHT),
            AssetsLoader.getInstance().getBackground(), 15, new Rectangle(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f,
            WORLD_WIDTH, WORLD_HEIGHT));

    public GameScreen(final Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
        this.controller = new GameController(new Rectangle(-WORLD_WIDTH/2,-WORLD_HEIGHT/2,WORLD_WIDTH,WORLD_HEIGHT));
        final ChangeListener onResume = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.resumeGame();
            }
        };
        final ChangeListener onQuit = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.MainMenu);
            }
        };
        this.pauseOverlay = new PauseOverlay(onQuit, onResume);
        this.controller.setPauseMenuInputProcessor(pauseOverlay.getInputProcessor());


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
        //backgroundSprite.draw(parent.getBatch());
        background.draw(parent.getBatch());
        background.update();
        //testSprite.setPosition(testSprite.getX() - testSprite.getX() / 2, testSprite.getY() - testSprite.getY() / 2);
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
}
