package ch.crepe.game.engines;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.KillableEntity;
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
    GameController controller;

    public CollisionEngine(GameController controller) {
        this.controller = controller;
    }

    public void checkAllCollisions(KillableEntity entity) {
        checkEntityCollision(entity);
        checkProjectileCollision(entity);
    }

    public void checkEntityCollision(KillableEntity entity) {
        for (KillableEntity other : controller.getEntities()) {
            if (entity != other)
                entity.accept(other);
        }
    }

    public void checkProjectileCollision(KillableEntity entity) {
        for (Projectile projectile : controller.getProjectiles()) {
            entity.accept(projectile);
        }
    }

    static public boolean isColliding(Entity entity, Entity other) {
        return Intersector.overlaps(entity.getHitbox(), other.getHitbox());
    }
}
