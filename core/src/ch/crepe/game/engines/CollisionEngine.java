package ch.crepe.game.engines;

import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
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
    public void visit(Spaceship ship) {
        for (Entity other : entities) {
            if(ship == other) continue;
            if(isColliding(ship, other)) {
                ship.setLife(ship.getLife() - other.getDamage());
                other.setLife(other.getLife() - ship.getDamage());
            }
        }
    }

    @Override
    public void visit(SpaceShipAI ship) {

    }

    @Override
    public void visit(Asteroid asteroid) {

    }

    @Override
    public void visit(BlueLaser laser) {
        visit((Laser) laser);
    }

    @Override
    public void visit(GreenLaser laser) {
        visit((Laser) laser);
    }

    /**
     * Spaceship vs Laser
     */
    @Override
    public void visit(Laser laser) {
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
