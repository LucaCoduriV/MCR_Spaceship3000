package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Vector2;

public abstract class Projectile extends Entity {
    protected Projectile(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); // TODO orientation
    }

    abstract void makeNoise();
}
