package ch.crepe.game.entities;

import ch.crepe.game.GameController;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class SpaceShipAI extends Spaceship {
    float lastShotTime = 0;
    float nextShotTime;
    private final static Random r = new Random();

    public SpaceShipAI(Vector2 position, Sprite sprite, Vector2 speed, GameController gameController, float width, float height) {
        super(position, sprite, speed, gameController, width, height);
        generateNextShotTime();
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        lastShotTime += delta;
        if (lastShotTime > nextShotTime) {
            lastShotTime = 0;
            shoot();
            generateNextShotTime();
        }
    }

    private void generateNextShotTime() {
        nextShotTime = (r.nextInt(2500) + 500) / 1000f;
    }
}
