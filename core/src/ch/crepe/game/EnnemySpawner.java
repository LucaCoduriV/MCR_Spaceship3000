package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.List;
import java.util.Random;

public class EnnemySpawner {
    private final int worldWidth;
    private final int worldHeight;
    private final Vector2 worldMinLeftPos;
    private final Vector2 worldMinRightPos;
    private final Random r;
    private float elapsedTime = 0;
    private final List<Entity> entityList;

    public EnnemySpawner(int worldWidth, int worldHeight, List<Entity> entityList) {
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        this.entityList = entityList;
        this.r = new Random();
        this.worldMinLeftPos = new Vector2(-worldWidth/2f,-worldHeight/2f);
        this.worldMinRightPos = new Vector2(worldWidth/2f,-worldHeight/2f);
    }

    public Entity spawnEnnemy() {
        final float size = 10;
        final int result = r.nextInt(worldWidth) - worldWidth / 2;
        Vector2 position = new Vector2(result,worldHeight / 2f + size);
        float minAngle = position.cpy().sub(worldMinLeftPos).angleDeg();
        float maxAngle = position.cpy().sub(worldMinRightPos).angleDeg();
        float angle = minAngle + r.nextFloat() * (maxAngle - minAngle);

        Vector2 velocity = new Vector2(0,0.1f);
        velocity.setAngleDeg(angle);
        velocity.rotateDeg(180);

        Sprite sprite = new Sprite(AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter));
        sprite.setOrigin(size/2,size/2);
        sprite.rotate(180);
        sprite.setSize(size,size);

        return new Asteroid(position, sprite, velocity);
    }

    public void update(float delta){
        elapsedTime += delta;

        if(elapsedTime > 5f){
            elapsedTime = 0;
            entityList.add(spawnEnnemy());
        }
    }
}
