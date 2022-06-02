package ch.crepe.game.Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class PauseOverlay {
    Spaceship3000 parent;
    GameScreen gameScreen;
    private final Stage stage;
    public PauseOverlay(final Spaceship3000 parent, final GameScreen gameScreen){
        this.stage = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        this.parent = parent;
        this.gameScreen = gameScreen;

        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        Skin skin = AssetsLoader.getInstance().getSkin();

        Label gameOverLabel = new Label("Pause", skin);
        gameOverLabel.setFontScale(2);
        //create buttons
        TextButton resumeButton = new TextButton("Resume", skin);
        TextButton mainMenuButton = new TextButton("Quit to main menu", skin);

        //add buttons to table
        table.add(gameOverLabel).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(resumeButton).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(mainMenuButton).fillX().uniformX();
        table.row();

        resumeButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                gameScreen.resumeGame();
            }
        });

        mainMenuButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(ScreenType.MainMenu);
            }
        });
    }

    public void draw(Batch batch){
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    public void update(int width, int height){
        stage.getViewport().update(width, height, true);
    }

    public InputProcessor getInputProcessor(){
        return stage;
    }
}
