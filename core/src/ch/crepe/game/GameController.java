package ch.crepe.game;

import ch.crepe.game.engines.*;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

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
    private final Rectangle worldBounds;
    private final Spaceship3000 game;
    private final RenderingEngine[] renderers;
    private final CollisionEngine[] collisionEngines;
    private InputProcessor pauseMenuInputProcessor;
    private int currentRenderer = 0;
    private int currentCollisionEngine = 0;

    public GameController(Spaceship3000 game, Rectangle worldBounds) {
        this.game = game;
        this.worldBounds = worldBounds;
        this.playerShip = new Spaceship(
                new Vector2(),
                new Vector2(),
                this, 5, 5, 0);
        this.entities = new LinkedList<>();
        this.projectiles = new LinkedList<>();
        this.playerInput = new PlayerInput(this, playerShip);
        this.gameInfo = new GameInfo();
        this.ennemySpawner = new EnemySpawner(this, (int) worldBounds.getWidth(), (int) worldBounds.getHeight(), entities);
        this.bottomCleaner = new BottomEntityCleaner(entities, worldBounds);
        this.allSideCleaner = new EntityCleaner(projectiles, worldBounds);
        entities.add(playerShip);
        renderers = new RenderingEngine[]{
                new CartoonRenderer(game.getBatch()),
                new RealRenderer(game.getBatch()),
                new PaintRenderer(game.getBatch())
        };
        collisionEngines = new CollisionEngine[]{
                new CollisionEngine(this),
                new MovementCollisionEngine(this)
        };
    }

    public void setPauseMenuInputProcessor(InputProcessor pauseMenuInputProcessor) {
        this.pauseMenuInputProcessor = pauseMenuInputProcessor;
    }

    public void update(float delta) {
        ennemySpawner.update(delta);
        for (Entity entity : entities) {
            entity.accept(getCollisionEngine());
            entity.update(delta);
        }

        for (Entity projectile : projectiles) {
            projectile.accept(getCollisionEngine());
            projectile.update(delta);
        }

        // TODO Je pense que l'on peut mettre ça dans le CollisionEngine
        if (!worldBounds.contains(playerShip.getCenter().cpy().add(playerShip.speed()))) {
            Vector2 newPosition = playerShip.getCenter();
            if (playerShip.getCenter().x < worldBounds.x) {
                newPosition.x = worldBounds.x;

            }
            if (playerShip.getCenter().x > worldBounds.x + worldBounds.width) {

                newPosition.x = worldBounds.x + worldBounds.width;
            }
            if (playerShip.getCenter().y < worldBounds.y) {
                newPosition.y = worldBounds.y;

            }
            if (playerShip.getCenter().y > worldBounds.y + worldBounds.height) {

                newPosition.y = worldBounds.y + worldBounds.height;
            }
            playerShip.setCenter(newPosition);

        }

        // TODO discuter si il faut mettre ça dans collision engine
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

    public void toggleRenderer() {
        currentRenderer = (currentRenderer + 1) % renderers.length;
    }

    public void toggleCollisionEngine() {
        currentCollisionEngine = (currentCollisionEngine + 1) % collisionEngines.length;
    }

    public RenderingEngine getRenderer() {
        return renderers[currentRenderer];
    }

    public CollisionEngine getCollisionEngine() {
        return collisionEngines[currentCollisionEngine];
    }

    public Rectangle getWorldBounds() {
        return worldBounds;
    }
}
