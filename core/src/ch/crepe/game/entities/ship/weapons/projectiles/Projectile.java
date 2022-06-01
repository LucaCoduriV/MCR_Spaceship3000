package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.VectorialMovableEntity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

abstract public class Projectile extends VectorialMovableEntity {
    Vector2 direction;

    protected Projectile(Vector2 position, Texture texture, float speed, Vector2 direction) {
        super(position, texture, speed);
        this.direction = direction;
    }

    @Override
    public void move() {
        vectorialMove(direction);
    }
}
