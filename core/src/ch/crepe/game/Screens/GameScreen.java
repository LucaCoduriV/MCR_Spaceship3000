package ch.crepe.game.Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    int posX = 0;
    int posY = 0;
    Sprite testSprite = new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter));
    Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(1920,1080);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                posX = screenX;
                posY = screenY;
                return super.mouseMoved(screenX, screenY);
            }
        });
    }

    @Override
    public void render(float delta) {

        viewport.apply();
        //parent.getBatch().setProjectionMatrix(extendViewPort.getCamera().view);


        parent.getBatch().begin();
        backgroundSprite.draw(parent.getBatch());
        testSprite.draw(parent.getBatch());
        parent.getBatch().end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }
}
