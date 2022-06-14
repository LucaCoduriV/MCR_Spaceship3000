package ch.crepe.game;

import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.SpaceShipAI;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Random;

/**
 * This class spawns enemies over time and increase the difficulty of the game.
 */
public class EnemySpawner {
    private final int worldWidth;
    private final int worldHeight;
    static private final Random r = new Random();
    private float elapsedTimeSpawn = 0;
    private float elapsedTime = 0;
    private float timeForNextSpawn;
    private static final int TIME_FOR_NEXT_LEVEL = 5000;
    private static final float ENNEMY_SIZE = 5f;
    private final List<Entity> entityList;
    private final GameController gameController;
    private int maxNextSpawnTimeMs = 5000;
    private int level = 0;

    public EnemySpawner(GameController controller, int worldWidth, int worldHeight, List<Entity> entityList) {
        this.gameController = controller;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.entityList = entityList;
        this.timeForNextSpawn = r.nextInt(maxNextSpawnTimeMs) / 1000f;
    }

    /**
     * This method spawns an enemy at a random position over the viewport and gives it a random direction.
     * It takes care to give the ennemies a direction that goes into the player's viewport.
     * @return the spawned enemy.
     */
    public Entity spawnEnemy() {
        Vector2 position = generateRandomPosition(ENNEMY_SIZE);
        Vector2 direction = generateRandomDirection(position, worldWidth, worldHeight);

        return randomEnemy(position, direction, ENNEMY_SIZE, ENNEMY_SIZE);
    }

    /**
     * This method is called every frame and spawns an enemy if the time is right.
     * The time to spawn an enemy changes over time.
     * @param delta the time since the last frame.
     */
    public void update(float delta){
        elapsedTimeSpawn += delta;
        elapsedTime += delta;

        if(elapsedTimeSpawn > timeForNextSpawn){
            elapsedTimeSpawn = 0;
            this.timeForNextSpawn = r.nextInt(maxNextSpawnTimeMs) / 1000f;
            entityList.add(spawnEnemy());
        }
        if(elapsedTime * 1000 / TIME_FOR_NEXT_LEVEL > level){
            updateNextMaxSpawnTime();
            System.out.println("Changing to level " + level);
        }
    }

    /**
     * It generates a random direction for the enemy so that he goes into the player's viewport.
     * @param position the position of the enemy.
     * @return the direction of the enemy.
     */
    static public Vector2 generateRandomDirection(Vector2 position, float worldWidth, float worldHeight) {
        Vector2 worldMinLeftPos = new Vector2(-worldWidth/2f,-worldHeight/2f);
        Vector2 worldMinRightPos = new Vector2(worldWidth/2f,-worldHeight/2f);

        float minAngle = position.cpy().sub(worldMinLeftPos).angleDeg();
        float maxAngle = position.cpy().sub(worldMinRightPos).angleDeg();
        float angle = minAngle + r.nextFloat() * (maxAngle - minAngle);

        return new Vector2(0,0.1f).setAngleDeg(angle).rotateDeg(180);
    }

    /**
     * It generates a random position for the enemy.
     * @param size the size of the enemy.
     * @return A position that stays between the viewport X axe.
     */
    private Vector2 generateRandomPosition(float size){
        final int result = r.nextInt(worldWidth) - worldWidth / 2;
        return new Vector2(result,worldHeight / 2f + size);
    }

    /**
     * It generates a enemy of a random type. (Asteroid or SpaceShipAI)
     * @param position the position of the enemy.
     * @param direction the direction of the enemy.
     * @param width the width of the enemy.
     * @param height the height of the enemy.
     * @return the enemy.
     */
    private Entity randomEnemy(Vector2 position, Vector2 direction, float width, float height){
        int randomNumber = r.nextInt(2);
        switch (randomNumber){
            case 0:
                return new SpaceShipAI(position,  direction, gameController, width, height, 180);
            case 1:
                return new Asteroid(position, direction, width, height);
            default:
                return new SpaceShipAI(position, new Vector2(0,0), gameController, 10, 10, 180);
        }
    }

    /**
     * It decreases the time to spawn an enemy.
     */
    private void updateNextMaxSpawnTime(){
        maxNextSpawnTimeMs = Math.round(maxNextSpawnTimeMs / 1.1f);
        level++;
    }
}
