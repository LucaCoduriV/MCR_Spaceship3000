package ch.crepe.game.Screens;

import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    float posX = 0;
    float posY = 0;
    boolean isDown = false;
    boolean isUp = false;
    boolean isLeft = false;
    boolean isRight = false;
    Sprite testSprite = new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter));
    Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(96,54);
        //((OrthographicCamera)this.viewport.getCamera()).position.set(96f, 54/2f, 0);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter(){
            @Override
            public boolean keyDown(int keycode) {

                switch (keycode){
                    case Input.Keys.UP:
                        isUp = true;
                        break;
                    case Input.Keys.DOWN:
                        isDown = true;
                        break;
                    case Input.Keys.LEFT:
                        isLeft = true;
                        break;
                    case Input.Keys.RIGHT:
                        isRight = true;
                        break;
                }
                return super.keyDown(keycode);
            }

            @Override
            public boolean keyUp(int keycode) {
                System.out.println(keycode);
                switch (keycode){
                    case Input.Keys.UP:
                        isUp = false;
                        break;
                    case Input.Keys.DOWN:
                        isDown = false;
                        break;
                    case Input.Keys.LEFT:
                        isLeft = false;
                        break;
                    case Input.Keys.RIGHT:
                        isRight = false;
                        break;
                }
                return super.keyUp(keycode);
            }
        });
    }

    @Override
    public void render(float delta) {

        viewport.apply();
        parent.getBatch().setProjectionMatrix(viewport.getCamera().combined);

        if(isDown){
            posY -= 0.5f;
        }
        if(isUp){
            posY += 0.5f;
        }
        if(isLeft){
            posX -= 0.5f;
        }
        if(isRight){
            posX += 0.5f;
        }

        parent.getBatch().begin();
        backgroundSprite.setSize(96,54);
        backgroundSprite.setPosition(-96/2f,-54/2f);
        backgroundSprite.draw(parent.getBatch());
        //testSprite.setPosition(testSprite.getX() - testSprite.getX() / 2, testSprite.getY() - testSprite.getY() / 2);
        testSprite.setSize(10,10);
        testSprite.setPosition(posX, posY);
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
