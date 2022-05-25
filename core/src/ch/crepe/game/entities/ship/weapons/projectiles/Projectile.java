package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

abstract public class Projectile extends Entity {

    Projectile(Vector2 position, Texture texture) {
        super(position, texture);
    }

    @Override
    public void move(Vector2 direction) {

    }
}
