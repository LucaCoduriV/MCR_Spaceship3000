package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.GameController;
import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import com.badlogic.gdx.math.Vector2;

abstract public class Projectile extends Entity {
    private final Spaceship owner;

    protected Projectile(Spaceship owner, Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); // TODO orientation
        this.owner = owner;
    }

    public Spaceship getOwner() {
        return owner;
    }

    abstract void makeNoise();
}
