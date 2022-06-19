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

/**
 * This class is the core of the game and manages the game loop.
 */
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
    private final RenderingEngine[] renderers;
    private final CollisionEngine[] collisionEngines;
    private InputProcessor pauseMenuInputProcessor;
    private int currentRenderer = 0;
    private int currentCollisionEngine = 0;

    /**
     * Constructor of the game controller from a game instance and world bounds.
     * @param game Game instance
     * @param worldBounds World bounds
     */
    public GameController(Spaceship3000 game, Rectangle worldBounds) {
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

    /**
     * Handle pause menu input.
     * @param pauseMenuInputProcessor Input processor of the pause menu
     */
    public void setPauseMenuInputProcessor(InputProcessor pauseMenuInputProcessor) {
        this.pauseMenuInputProcessor = pauseMenuInputProcessor;
    }

    /**
     * Update the game state.
     * @param delta Time since last update
     */
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

        allSideCleaner.update(delta);
        bottomCleaner.update(delta);
    }

    /**
     * Return the user ship.
     * @return The user ship
     */
    public Spaceship getPlayerShip() {
        return playerShip;
    }

    /**
     * Return the list of entities.
     * @return The list of entities
     */
    public List<Entity> getEntities() {
        return entities;
    }

    /**
     * Pause the game.
     */
    public void pauseGame() {
        gameInfo.setState(GameInfo.GameState.pause);
        Gdx.input.setInputProcessor(pauseMenuInputProcessor);

    }

    /**
     * Resume the game.
     */
    public void resumeGame() {
        gameInfo.setState(GameInfo.GameState.playing);
        Gdx.input.setInputProcessor(playerInput);
    }

    /**
     * Return the player input.
     * @return The player input
     */
    public InputProcessor getPlayerInput() {
        return playerInput;
    }

    /**
     * Return the game info.
     * @return The game info
     */
    public GameInfo getGameInfo() {
        return gameInfo;
    }

    /**
     * Add a new projectile to the list of projectiles.
     * @param entity The projectile to add
     */
    public void addProjectile(Entity entity) {
        projectiles.add(entity);
    }

    /**
     * Return the list of projectiles.
     * @return The list of projectiles
     */
    public LinkedList<Entity> getProjectiles() {
        return projectiles;
    }

    /**
     * Switch to the next renderer in the list.
     */
    public void toggleRenderer() {
        currentRenderer = (currentRenderer + 1) % renderers.length;
    }

    /**
     * Switch to the next collision engine in the list.
     */
    public void toggleCollisionEngine() {
        currentCollisionEngine = (currentCollisionEngine + 1) % collisionEngines.length;
    }

    /**
     * Return the current renderer.
     * @return The current renderer
     */
    public RenderingEngine getRenderer() {
        return renderers[currentRenderer];
    }

    /**
     * Return the current collision engine.
     * @return The current collision engine
     */
    public CollisionEngine getCollisionEngine() {
        return collisionEngines[currentCollisionEngine];
    }

    /**
     * Return the world bounds.
     * @return The world bounds
     */
    public Rectangle getWorldBounds() {
        return worldBounds;
    }
}
