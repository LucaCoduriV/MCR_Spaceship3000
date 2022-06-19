package ch.crepe.game.Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Other;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoadingScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final AssetManager manager;
    private final Stage stage;
    private ProgressBar progressBar;

    public LoadingScreen(Spaceship3000 parent) {
        this.parent = parent;
        stage = new Stage(new ScreenViewport());
        manager = new AssetManager();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
        // Create a table that fills the screen. Everything else will go inside this table.
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(false);
        stage.addActor(table);

        manager.load(Other.skin.getPath(), Skin.class);
        manager.finishLoading();
        Skin skin = manager.get(Other.skin.getPath(), Skin.class);

        //create buttons
        progressBar = new ProgressBar(0, 1, 0.001f, false, skin);
        table.add(progressBar).fillX().uniformX();
        AssetsLoader.getInstance().loadAll();
    }

    @Override
    public void render(float delta) {
        AssetsLoader.getInstance().update();
        if (AssetsLoader.getInstance().isFinished()) {
            parent.changeScreen(ScreenType.MainMenu);
        }

        progressBar.setValue(AssetsLoader.getInstance().getProgress());
        // clear the screen ready for next set of images to be drawn
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // tell our stage to do actions and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
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
        manager.dispose();
    }
}
