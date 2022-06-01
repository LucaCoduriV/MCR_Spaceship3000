package ch.crepe.game.Screens;

import ch.crepe.game.PlayerInput;
import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    private final HeadUpDisplay hud;
    private static final float WORLD_WIDTH = 96;
    private static final float WORLD_HEIGHT = 54;
    private final Spaceship spaceship = new Spaceship(new Vector2(), AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter),new Vector2());
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    private final Music[] musics = { Music.aloneAgainstEnemy, Music.deathMatch, Music.battleInTheStars, Music.epicEnd, Music.rainOfLasers, Music.spaceHeroes, Music.withoutFear };

    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
    }

    @Override
    public void show() {
        parent.getAudioManager().loadMusic(musics[(int) (Math.random() * musics.length)]);
        parent.getAudioManager().onMusicCompletion(new com.badlogic.gdx.audio.Music.OnCompletionListener() {
            @Override
            public void onCompletion(com.badlogic.gdx.audio.Music music) {
                parent.getAudioManager().loadMusic(musics[(int) (Math.random() * musics.length)]);
            }
        });
        parent.getAudioManager().resumeMusic();

        backgroundSprite.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        backgroundSprite.setPosition(-WORLD_WIDTH/2f,-WORLD_HEIGHT/2f);



        Gdx.input.setInputProcessor(new PlayerInput(spaceship));
    }

    @Override
    public void render(float delta) {
        spaceship.update(delta);

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        parent.getBatch().setProjectionMatrix(viewport.getCamera().combined);


        parent.getBatch().begin();
        backgroundSprite.draw(parent.getBatch());
        spaceship.draw(parent.getBatch());
        parent.getBatch().end();

        hud.draw();

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        hud.update(width, height);
    }
}
