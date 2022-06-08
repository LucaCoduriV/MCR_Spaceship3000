package ch.crepe.game;

import ch.crepe.game.entities.KillableEntity;
import ch.crepe.game.entities.asteroids.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Random;

public class EnemySpawner {
    private final int worldWidth;
    private final int worldHeight;
    private final Vector2 worldMinLeftPos;
    private final Vector2 worldMinRightPos;
    private final Random r;
    private float elapsedTimeSpawn = 0;
    private float elapsedTime = 0;
    private float timeForNextSpawn;
    private static final int TIME_FOR_NEXT_LEVEL = 5000;
    private static final float ENNEMY_SIZE = 5f;
    private final List<KillableEntity> entityList;
    private final GameController gameController;
    private int maxNextSpawnTimeMs = 5000;
    private int level = 0;

    public EnemySpawner(GameController controller, int worldWidth, int worldHeight, List<KillableEntity> entityList) {
        this.gameController = controller;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.entityList = entityList;
        this.r = new Random();
        this.worldMinLeftPos = new Vector2(-worldWidth/2f,-worldHeight/2f);
        this.worldMinRightPos = new Vector2(worldWidth/2f,-worldHeight/2f);
        this.timeForNextSpawn = r.nextInt(maxNextSpawnTimeMs) / 1000f;
    }

    public KillableEntity spawnEnemy() {
        Vector2 position = generateRandomPosition(ENNEMY_SIZE);
        Vector2 direction = generateRandomDirection(position);

        return randomEnemy(position, direction, ENNEMY_SIZE, ENNEMY_SIZE);
    }

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

    private Vector2 generateRandomDirection(Vector2 position){

        float minAngle = position.cpy().sub(worldMinLeftPos).angleDeg();
        float maxAngle = position.cpy().sub(worldMinRightPos).angleDeg();
        float angle = minAngle + r.nextFloat() * (maxAngle - minAngle);

        return new Vector2(0,0.1f).setAngleDeg(angle).rotateDeg(180);
    }

    private Vector2 generateRandomPosition(float size){
        final int result = r.nextInt(worldWidth) - worldWidth / 2;
        return new Vector2(result,worldHeight / 2f + size);
    }

    private KillableEntity randomEnemy(Vector2 position, Vector2 direction, float width, float height){
        int randomNumber = r.nextInt(3);
        switch (randomNumber){
            case 0:
                return new SpaceShipAI(position,  direction, gameController, width, height, 180);
            case 1:
                return new BlueAsteroid(position, direction, width, height);
            case 2:
                return new GreenAsteroid(position, direction, width, height);
            default:
                return new SpaceShipAI(position, new Vector2(0,0), gameController, 10, 10, 180);
        }
    }

    private void updateNextMaxSpawnTime(){
        maxNextSpawnTimeMs = Math.round(maxNextSpawnTimeMs / 1.1f);
        level++;
    }
}
