package ch.crepe.game.screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.audio.AudioManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class MainMenuScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final Stage stage;
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    private final Sprite logoSprite = new Sprite(AssetsLoader.getInstance().getLogo());

    public MainMenuScreen(Spaceship3000 parent) {
        this.parent = parent;
        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
    }

    @Override
    public void show() {
        AudioManager.getInstance().loadMusic(Music.MENU);
        AudioManager.getInstance().loopMusic(true);
        AudioManager.getInstance().resumeMusic();

        Gdx.input.setInputProcessor(stage);

        // Create a table that fills the screen. Everything else will go inside this table.
        VerticalGroup vg = new VerticalGroup();
        vg.setFillParent(true);
        vg.setDebug(false);
        vg.center();

        Image image = new Image(new SpriteDrawable(logoSprite));

        Table table = new Table();

        table.setDebug(false);
        vg.addActor(image);
        vg.addActor(table);
        stage.addActor(vg);

        Skin skin = AssetsLoader.getInstance().getSkin();

        //create buttons
        TextButton newGame = new TextButton("New Game", skin);
        TextButton preferences = new TextButton("Preferences", skin);
        TextButton exit = new TextButton("Exit", skin);

        //add buttons to table

        table.row().pad(10, 0, 10, 0);
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        // create button listeners
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.GAME);

            }
        });

        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.PREFERENCES);
            }
        });

    }

    @Override
    public void render(float delta) {
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.getBatch().begin();
        stage.getBatch().draw(backgroundSprite, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.getBatch().end();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
