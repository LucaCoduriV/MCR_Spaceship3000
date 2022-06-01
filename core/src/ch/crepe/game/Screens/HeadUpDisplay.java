package ch.crepe.game.Screens;

import ch.crepe.game.assets.AssetsLoader;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class HeadUpDisplay {
    private final Stage overlay;
    private final ShapeRenderer shapeRenderer;
    private final Label lifeLabel;
    private final Label scoreLabel;

    public HeadUpDisplay(){
        this.overlay = new Stage(new FitViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        this.shapeRenderer = new ShapeRenderer();


        Skin skin = AssetsLoader.getInstance().getSkin();
        lifeLabel = new Label("Life: 100%", skin);
        scoreLabel = new Label("score: 0", skin);

        lifeLabel.setFontScale(2f);
        lifeLabel.setX(Gdx.graphics.getWidth() - lifeLabel.getWidth() * 2 - 20);
        scoreLabel.setFontScale(2f);
        scoreLabel.setX(Gdx.graphics.getWidth() - scoreLabel.getWidth() * 2 - 20);
        scoreLabel.setY(Gdx.graphics.getHeight() - scoreLabel.getHeight() * 2 - 20);
        overlay.addActor(lifeLabel);
        overlay.addActor(scoreLabel);

    }

    public void draw(){
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(new Color(0,0,0,0));
        shapeRenderer.rect(overlay.getWidth() - 200,0,200,30);
        shapeRenderer.end();

        overlay.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        overlay.draw();
    }

    public void setLife(int life) {
        lifeLabel.setText("Life: " + life + "%");
    }

    public void setScore(int score){
        scoreLabel.setText("score: " + score);
    }

    public void update(int width, int height){
        overlay.getViewport().update(width, height);    }
}
