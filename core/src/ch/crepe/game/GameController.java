package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.engines.CollisionEngine;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameController {
    private final GameInfo gameInfo;
    private final Spaceship playerShip;
    private final LinkedList<Entity> entities;
    private final LinkedList<Entity> projectiles;
    private final InputProcessor playerInput;
    private final EnemySpawner ennemySpawner;
    private final EntityCleaner bottomCleaner;
    private final EntityCleaner allSideCleaner;
    private InputProcessor pauseMenuInputProcessor;
    private final CollisionEngine ce;
    private final Rectangle worldBounds;

    public GameController(Rectangle worldBounds) {
        this.worldBounds = worldBounds;
        this.playerShip = new Spaceship(new Vector2(), new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter)), new Vector2(), this, 10, 10);
        this.entities = new LinkedList<>();
        this.projectiles = new LinkedList<>();
        this.playerInput = new PlayerInput(this, playerShip);
        this.gameInfo = new GameInfo();
        this.ennemySpawner = new EnemySpawner(this,96,54,entities);
        this.ce = new CollisionEngine(entities);
        this.bottomCleaner = new BottomEntityCleaner(entities, worldBounds);
        this.allSideCleaner = new EntityCleaner(projectiles, worldBounds);
        entities.add(playerShip);
    }

    public void setPauseMenuInputProcessor(InputProcessor pauseMenuInputProcessor) {
        this.pauseMenuInputProcessor = pauseMenuInputProcessor;
    }

    public void update(float delta) {
        ennemySpawner.update(delta);
        for (Entity entity : entities) {
            entity.accept(ce);
            entity.update(delta);
        }

        for (Entity entity : projectiles) {
            entity.accept(ce);
            entity.update(delta);
        }

        if(!worldBounds.contains(playerShip.position().cpy().add(playerShip.speed()))) {
            Vector2 newSpeed = playerShip.speed().cpy();
            if(playerShip.position().x < worldBounds.x || playerShip.position().x > worldBounds.x + worldBounds.width){
                newSpeed.x = 0;
                playerShip.position().x = playerShip.position().x - (playerShip.speed().x / Math.abs(playerShip.speed().x)) * 0.5f;
            }
            if(playerShip.position().y < worldBounds.y || playerShip.position().y > worldBounds.y + worldBounds.height){
                newSpeed.y = 0;
                playerShip.position().y = playerShip.position().y - (playerShip.speed().y / Math.abs(playerShip.speed().y)) * 0.5f;
            }
            playerShip.speed().set(newSpeed);
        }
        playerShip.update(delta);

        allSideCleaner.update(delta);
        bottomCleaner.update(delta);
    }

    public Spaceship getPlayerShip() {
        return playerShip;
    }

    public List<Entity> getEntities() {
        return entities;
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

    public LinkedList<Entity> getProjectiles() {
        return projectiles;
    }
}
