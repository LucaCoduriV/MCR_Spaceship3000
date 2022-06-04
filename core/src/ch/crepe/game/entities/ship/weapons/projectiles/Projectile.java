package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Vector2;

abstract public class Projectile extends Entity {
    public Projectile(DisplayedAsset asset, Vector2 speed) {
        super(asset, speed);
    }

 /*   protected Projectile(Vector2 position, Texture texture, Vector2 speed) {
        super(position, texture, speed);
    }*/
}
