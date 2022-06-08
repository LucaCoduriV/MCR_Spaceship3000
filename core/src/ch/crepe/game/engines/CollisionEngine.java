package ch.crepe.game.engines;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.asteroids.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import ch.crepe.game.entities.ship.weapons.projectiles.Projectile;
import com.badlogic.gdx.math.Intersector;

public class CollisionEngine {

    public CollisionEngine() {
    }

    static public boolean isColliding(Entity entity, Entity other) {
        return Intersector.overlaps(entity.getHitbox(), other.getHitbox());
    }
}
