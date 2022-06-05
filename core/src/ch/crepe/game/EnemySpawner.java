package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.assets.displayers.DisplayedSprite;
import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.SpaceShipAI;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Random;

public class EnemySpawner {
    private final int worldWidth;
    private final int worldHeight;
    private final Vector2 worldMinLeftPos;
    private final Vector2 worldMinRightPos;
    private final Random r;
    private float elapsedTime = 0;
    private float timeForNextSpawn;
    private final List<Entity> entityList;
    private final GameController gameController;

    public EnemySpawner(GameController controller, int worldWidth, int worldHeight, List<Entity> entityList) {
        this.gameController = controller;
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.entityList = entityList;
        this.r = new Random();
        this.worldMinLeftPos = new Vector2(-worldWidth/2f,-worldHeight/2f);
        this.worldMinRightPos = new Vector2(worldWidth/2f,-worldHeight/2f);
        this.timeForNextSpawn = r.nextInt(5000) / 1000f;
    }

    public Entity spawnEnemy() {
        final float size = 5;
        Vector2 position = generateRandomPosition(size);
        Vector2 direction = generateRandomDirection(position);

        return randomEnemy(position, direction, size, size);
    }

    public void update(float delta){
        elapsedTime += delta;

        if(elapsedTime > timeForNextSpawn){
            elapsedTime = 0;
            this.timeForNextSpawn = r.nextInt(5000) / 1000f;
            entityList.add(spawnEnemy());
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

    private Entity randomEnemy(Vector2 position, Vector2 direction, float width, float height){
        int randomNumber = r.nextInt(2);
        switch (randomNumber){
            case 0:
                return new SpaceShipAI(position, new DisplayedSprite(
                        AssetsLoader.getInstance().getSpaceship(SpaceShip.iceSpeedster),
                        new Rectangle(0,0, width, height),
                        new Vector2(width/2, height/2),
                        180),  direction,
                        gameController, width, height, 180);
            case 1:
                return new Asteroid(position, new DisplayedSprite(
                        AssetsLoader.getInstance().getAsteroid(ch.crepe.game.assets.Asteroid.blue1),
                                new Rectangle(0,0, width, height),
                                new Vector2(width/2, height/2),
                                180),
                        direction, width, height);
            default:
                return new SpaceShipAI(position, new DisplayedSprite(
                        AssetsLoader.getInstance().getSpaceship(SpaceShip.iceSpeedster),
                        new Rectangle(width/2,height/2, width, height),
                        new Vector2(width/2, height/2),
                        0),  new Vector2(0,0),
                        gameController, 10, 10, 180);
        }
    }
}
