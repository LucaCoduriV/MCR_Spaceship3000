package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameController {
    private final GameInfo gameInfo;
    private final Spaceship playerShip;
    private final List<Entity> entities;
    private final List<Entity> projectiles;
    private final InputProcessor playerInput;
    private EnnemySpawner ennemySpawner;
    private InputProcessor pauseMenuInputProcessor;


    public GameController() {
        this.playerShip = new Spaceship(new Vector2(), AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter), new Vector2(), this);
        this.entities = new ArrayList<>();
        this.projectiles = new LinkedList<>();
        this.playerInput = new PlayerInput(this, playerShip);
        this.gameInfo = new GameInfo();
        this.ennemySpawner = new EnnemySpawner(96,54,entities);
    }

    public void setPauseMenuInputProcessor(InputProcessor pauseMenuInputProcessor) {
        this.pauseMenuInputProcessor = pauseMenuInputProcessor;
    }

    public void update(float delta) {
        ennemySpawner.update(delta);
        for (Entity entity : entities) {
            entity.update(delta);
        }

        for (Entity entity : projectiles)
            entity.update(delta);

        playerShip.update(delta);
    }

    public Spaceship getPlayerShip() {
        return playerShip;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getProjectiles() {
        return projectiles;
    }

    public void pauseGame() {
        gameInfo.setState(GameInfo.GameState.pause);
        Gdx.input.setInputProcessor(pauseMenuInputProcessor);

    }

    public void resumeGame() {
        gameInfo.setState(GameInfo.GameState.playing);
        Gdx.input.setInputProcessor(playerInput);
    }

    public InputProcessor getPlayerInput() {
        return playerInput;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public void addProjectile(Entity entity) {
        projectiles.add(entity);
    }
}
