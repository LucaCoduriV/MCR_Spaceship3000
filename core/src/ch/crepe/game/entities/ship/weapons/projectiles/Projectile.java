package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

abstract public class Projectile extends Entity {

    protected Projectile(Vector2 position, Sprite sprite, Vector2 speed, float width, float height) {
        super(position, sprite, speed, width, height);
    }

    abstract void makeNoise();
}
