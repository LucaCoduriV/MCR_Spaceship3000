package ch.crepe.game.Screens;

import ch.crepe.game.PlayerInput;
import ch.crepe.game.Spaceship3000;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.engines.CollisionEngine;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.LinkedList;

public class GameScreen extends ScreenAdapter {
    private final Spaceship3000 parent;
    private final FitViewport viewport;
    private final HeadUpDisplay hud;
    private static final float WORLD_WIDTH = 96;
    private static final float WORLD_HEIGHT = 54;
    private final Spaceship spaceship = new Spaceship(new Vector2(0, 0), new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighterDebug)),new Vector2(), 10, 10);
    private final Spaceship spaceship2 = new Spaceship(new Vector2(10, 10), new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighterDebug)),new Vector2(), 10, 10);
    private final Spaceship spaceship3 = new Spaceship(new Vector2(-10, -20), new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighterDebug)),new Vector2(), 10, 10);
    private final Sprite backgroundSprite = new Sprite(AssetsLoader.getInstance().getBackground());


    private final LinkedList<Spaceship> entites = new LinkedList<>();
    private final CollisionEngine ce = new CollisionEngine(entites);

    public GameScreen(Spaceship3000 parent){
        this.parent = parent;
        this.viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT);
        this.hud = new HeadUpDisplay();
        entites.add(spaceship);
        entites.add(spaceship2);
        entites.add(spaceship3);
    }

    @Override
    public void show() {
        backgroundSprite.setSize(WORLD_WIDTH,WORLD_HEIGHT);
        backgroundSprite.setPosition(-WORLD_WIDTH/2f,-WORLD_HEIGHT/2f);

        Gdx.input.setInputProcessor(new PlayerInput(spaceship));
    }

    @Override
    public void render(float delta) {
        spaceship.update(delta);

        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        viewport.apply();
        parent.getBatch().setProjectionMatrix(viewport.getCamera().combined);


        parent.getBatch().begin();
        backgroundSprite.draw(parent.getBatch());
        for (Entity entity : entites) {
            entity.draw(parent.getBatch());
            entity.accept(ce);
        }
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
