package ch.crepe.game.engines;

import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import com.badlogic.gdx.math.Intersector;

import java.util.LinkedList;

public class CollisionEngine extends Engine {

    private final LinkedList<Entity> entities;

    public CollisionEngine(LinkedList<Entity> entities) {
        this.entities = entities;
    }

    /**
     * Spaceship vs Spaceship
     */
    @Override
    public void visitSpaceship(Spaceship ship) {
        for (Entity other : entities) {
            if(ship == other) continue;
            if(isColliding(ship, other)) {
                ship.setLife(ship.getLife() - other.getDamage());
                other.setLife(other.getLife() - ship.getDamage());
            }
        }
    }

    /**
     * Spaceship vs Laser
     */
    @Override
    public void visitLaser(Laser laser) {
        for (Entity entity : entities) {
            if(laser == entity || laser.getOwner() == entity) continue;
            if(isColliding(laser, entity)) {
                laser.kill();
                entity.setLife(entity.getLife() - laser.getDamage());
                if(!entity.isAlive()) {
                    laser.getOwner().increaseScore();
                }
            }
        }
    }

    public boolean isColliding(Entity entity, Entity other) {
        return Intersector.overlaps(entity.getHitbox(), other.getHitbox());
    }
}
