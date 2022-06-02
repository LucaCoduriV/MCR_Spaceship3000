package ch.crepe.game.Screens;

import ch.crepe.game.Background;
import ch.crepe.game.EnnemySpawner;
import ch.crepe.game.PlayerInput;
import ch.crepe.game.Spaceship3000;
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
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class GameScreen extends ScreenAdapter {
    private enum GameState{
        playing,
        pause
    }
    private GameState gameState = GameState.playing;
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    private final HeadUpDisplay hud;
    private final PauseOverlay pauseOverlay;
    private final PlayerInput playerInput;
    private static final float WORLD_WIDTH = 96;
    private static final float WORLD_HEIGHT = 54;
    private final Spaceship spaceship = new Spaceship(new Vector2(), AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter),new Vector2());
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    private final Background background = new Background(new Vector2(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f),
            new Vector2(WORLD_WIDTH, WORLD_HEIGHT),
            AssetsLoader.getInstance().getBackground(), 15, new Rectangle(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f,
            WORLD_WIDTH, WORLD_HEIGHT));
    private final Music[] musics = { Music.aloneAgainstEnemy, Music.deathMatch, Music.battleInTheStars, Music.epicEnd, Music.rainOfLasers, Music.spaceHeroes, Music.withoutFear };
    private final List<Entity> ennemies = new ArrayList<Entity>();
    public GameScreen(Spaceship3000 parent){

        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
        this.pauseOverlay = new PauseOverlay(parent, this);
        this.playerInput = new PlayerInput(this, spaceship);

        final EnnemySpawner spawner = new EnnemySpawner(96, 54);
        new Timer().scheduleTask(new Timer.Task() {
            @Override
            public void run() {
                ennemies.add(spawner.spawnEnnemy());

            }
        }, 0, 2);
    }

    @Override
    public void show() {
        Playlist musicPlaylist = new Playlist(musics);
        musicPlaylist.shuffle();
        parent.getAudioManager().loadPlaylist(musicPlaylist);
        parent.getAudioManager().resumeMusic();

        backgroundSprite.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        backgroundSprite.setPosition(-WORLD_WIDTH/2f,-WORLD_HEIGHT/2f);



        Gdx.input.setInputProcessor(playerInput);
    }

    @Override
    public void render(float delta) {
        if(gameState == GameState.playing){
                updateGame(delta);
                drawGame();
        }else if(gameState == GameState.pause){
            Gdx.gl.glClearColor(0f, 0f, 0f, 0.1f);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            drawPauseMenu();
        }

    }

    private void updateGame(float delta){
        for (Entity entity : ennemies) {
            entity.update(delta);
        }
        spaceship.update(delta);
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
        for (Entity entity : ennemies) {
            entity.draw(parent.getBatch());
        }
        spaceship.draw(parent.getBatch());
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
        gameState = GameState.pause;
    }

    public void resumeGame(){
        Gdx.input.setInputProcessor(playerInput);
        gameState = GameState.playing;
    }
}
