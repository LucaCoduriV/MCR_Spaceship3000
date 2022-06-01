package ch.crepe.game.Screens;

import ch.crepe.game.PlayerInput;
import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Audio;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
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
    private final Audio[] musics = { Audio.aloneAgainstEnemy, Audio.deathMatch, Audio.battleInTheStars, Audio.epicEnd, Audio.rainOfLasers, Audio.spaceHeroes, Audio.withoutFear };
    private Music music;

    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
    }

    @Override
    public void show() {
        music = Gdx.audio.newMusic(AssetsLoader.getInstance().getAudio(musics[(int) (Math.random() * musics.length)]));
        music.play();
        music.setOnCompletionListener(new Music.OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                music.dispose();
                music = Gdx.audio.newMusic(AssetsLoader.getInstance().getAudio(musics[(int) (Math.random() * musics.length)]));
                music.play();
            }
        });
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
        music.stop();
        music.dispose();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        hud.update(width, height);
    }
}
