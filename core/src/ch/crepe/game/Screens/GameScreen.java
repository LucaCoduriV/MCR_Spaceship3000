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
    private static final float WORLD_WIDTH = 96;
    private static final float WORLD_HEIGHT = 54;
    private float posX = 0;
    private float posY = 0;
    private boolean isDown = false;
    private boolean isUp = false;
    private boolean isLeft = false;
    private boolean isRight = false;
    private final Sprite testSprite = new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter));
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
    }

    @Override
    public void show() {
        backgroundSprite.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        backgroundSprite.setPosition(-WORLD_WIDTH/2f,-WORLD_HEIGHT/2f);

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
