package ch.crepe.game.Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameOverScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final Stage stage;
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    private Music music;
    private final int bestScore;
    private final int yourScore;
    public GameOverScreen(Spaceship3000 parent, int bestScore, int yourScore) {
        this.parent = parent;

        /// create stage and set it as input processor
        stage = new Stage(new ScreenViewport());
        this.bestScore = bestScore;
        this.yourScore = yourScore;

    }

    @Override
    public void show() {
        music = Gdx.audio.newMusic(AssetsLoader.getInstance().getAudio(Audio.defeat));
        music.play();
        Gdx.input.setInputProcessor(stage);

        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        Skin skin = AssetsLoader.getInstance().getSkin();

        Label gameOverLabel = new Label("Game Over", skin);
        Label yourScoreLabel = new Label("Yout score: " + yourScore, skin);
        Label bestScoreLabel = new Label("Best score: " + bestScore, skin);
        gameOverLabel.setFontScale(2);
        //create buttons
        TextButton retryButton = new TextButton("Retry", skin);
        TextButton mainMenuButton = new TextButton("Main menu", skin);

        //add buttons to table
        table.add(gameOverLabel).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(yourScoreLabel).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(bestScoreLabel).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(retryButton).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(mainMenuButton).fillX().uniformX();
        table.row();

        retryButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.Game);

            }
        });

        mainMenuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.MainMenu);
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
        music.stop();
        music.dispose();
    }
}
