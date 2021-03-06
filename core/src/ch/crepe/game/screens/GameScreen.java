package ch.crepe.game.screens;

import ch.crepe.game.Background;
import ch.crepe.game.GameController;
import ch.crepe.game.GameInfo;
import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.audio.Playlist;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter {
    private static final float WORLD_WIDTH = 96;
    private static final float WORLD_HEIGHT = 54;
    private static final Music[] musics = {
            Music.ALONE_AGAINST_ENEMY,
            Music.DEATH_MATCH,
            Music.BATTLE_IN_THE_STARS,
            Music.EPIC_END,
            Music.RAIN_OF_LASERS,
            Music.SPACE_HEROES,
            Music.WITHOUT_FEAR
    };
    private final GameController controller;
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    private final HeadUpDisplay hud;
    private final PauseOverlay pauseOverlay;
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    private final Background background = new Background(
            new Rectangle(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f, WORLD_WIDTH, WORLD_HEIGHT),
            AssetsLoader.getInstance().getBackground(),
            15);

    public GameScreen(final Spaceship3000 parent) {
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
        this.controller = new GameController(parent, new Rectangle(-WORLD_WIDTH / 2, -WORLD_HEIGHT / 2, WORLD_WIDTH, WORLD_HEIGHT));
        final ChangeListener onResume = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                controller.resumeGame();
            }
        };
        final ChangeListener onQuit = new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.MAIN_MENU);
            }
        };
        this.pauseOverlay = new PauseOverlay(onQuit, onResume);
        this.controller.setPauseMenuInputProcessor(pauseOverlay.getInputProcessor());

    }

    @Override
    public void show() {
        Playlist musicPlaylist = new Playlist(musics);
        musicPlaylist.shuffle();
        AudioManager.getInstance().loadPlaylist(musicPlaylist);
        AudioManager.getInstance().resumeMusic();

        backgroundSprite.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        backgroundSprite.setPosition(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f);
        Gdx.input.setInputProcessor(controller.getPlayerInput());
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (controller.getGameInfo().getState() == GameInfo.GameState.PLAYING) {
            updateGame(delta);
            drawGame();
        } else if (controller.getGameInfo().getState() == GameInfo.GameState.PAUSE) {
            drawPauseMenu();
        }

    }

    private void updateGame(float delta) {
        controller.update(delta);
        background.update(delta);
    }

    private void drawGame() {

        viewport.apply();
        parent.getBatch().setProjectionMatrix(viewport.getCamera().combined);

        parent.getBatch().begin();
        background.draw(parent.getBatch());

        for (Entity entity : controller.getEntities()) {
            entity.accept(controller.getRenderer());
        }

        for (Entity entity : controller.getProjectiles()) {
            entity.accept(controller.getRenderer());
        }

        hud.setLife(controller.getPlayerShip().getPercentLife());
        hud.setScore(controller.getGameInfo().getScore());
        if (!controller.getPlayerShip().isAlive()) {
            if (parent.getPreferences().getBestScore() < controller.getGameInfo().getScore()) {
                parent.getPreferences().setBestScore(controller.getGameInfo().getScore());
            }
            parent.changeScreen(ScreenType.GAME_OVER, controller.getGameInfo().getScore());
        }

        controller.getPlayerShip().accept(controller.getRenderer());
        parent.getBatch().end();

        hud.draw();
    }

    private void drawPauseMenu() {
        pauseOverlay.draw(parent.getBatch());
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        pauseOverlay.update(width, height);
        hud.update(width, height);
    }
}
