package ch.crepe.game.Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class GameScreen extends ScreenAdapter {
    Spaceship3000 parent;
    int posX = 0;
    int posY = 0;
    Sprite testSprite = new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter));
    public GameScreen(Spaceship3000 parent){
        this.parent = parent;

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
        Gdx.gl.glClearColor(0, 0, .25f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        testSprite.setX(posX);
        testSprite.setY(posY);

        parent.getBatch().begin();
        testSprite.draw(parent.getBatch());
        parent.getBatch().end();
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
