package ch.crepe.game.Screens;

import ch.crepe.game.Background;
import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    private final HeadUpDisplay hud;
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

    private final Background background = new Background(new Vector2(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f),
            new Vector2(WORLD_WIDTH, WORLD_HEIGHT),
            AssetsLoader.getInstance().getBackground(), 15, new Rectangle(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f,
            WORLD_WIDTH, WORLD_HEIGHT));

    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();

        /*
                Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());
        backgroundSprite.setPosition(-WORLD_WIDTH / 2f, -WORLD_HEIGHT / 2f);
        //Vector2 realSize = viewport.unproject(new Vector2(AssetsLoader.getInstance().getBackground().getWidth(), AssetsLoader.getInstance().getBackground().getHeight()));
        //backgroundSprite.setSize(realSize.x, realSize.y);
         */
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
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

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
        //backgroundSprite.draw(parent.getBatch());
        background.draw(parent.getBatch());
        background.update();
        //testSprite.setPosition(testSprite.getX() - testSprite.getX() / 2, testSprite.getY() - testSprite.getY() / 2);
        testSprite.setSize(10,10);
        testSprite.setPosition(posX, posY);
        testSprite.draw(parent.getBatch());
        parent.getBatch().end();

        hud.draw();

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        hud.update(width, height);
    }
}
