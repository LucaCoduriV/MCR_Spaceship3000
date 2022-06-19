package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Vector2;

/**
 * Represents a projectile.
 */
abstract public class Projectile extends Entity {
    protected Projectile(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0);
    }

    /**
     * Makes the projectile noise.
     */
    abstract void makeNoise();
}
