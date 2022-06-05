package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Vector2;

abstract public class Projectile extends Entity {
    protected Projectile(Vector2 position, DisplayedAsset asset, Vector2 speed, float width, float height) {
        super(position, asset, speed, width, height);
    }

    abstract void makeNoise();
}
