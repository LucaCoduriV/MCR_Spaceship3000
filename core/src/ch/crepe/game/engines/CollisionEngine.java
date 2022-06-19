package ch.crepe.game.engines;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import com.badlogic.gdx.math.Intersector;

/**
 * Engine managing the collision between entities.
 * This class is implemented as a visitor.
 */
public class CollisionEngine extends Engine {
    private final GameController controller;

    public CollisionEngine(GameController controller) {
        this.controller = controller;
    }

    /**
     * Check if a spaceship has collided with an other entity
     * If the collision is detected, the spaceship is damaged and
     * the entity is destroyed
     *
     * @param ship Ship to check collision with
     */
    @Override
    public void visit(Spaceship ship) {
        for (Entity other : controller.getEntities()) {
            if (ship == other) continue;
            if (isColliding(ship, other)) {
                ship.setLife(ship.getLife() - other.getDamage());
                controller.getGameInfo().addScore(1);
                other.setLife(0);
            }
        }
    }

    /**
     * Check if a spaceshipAI has collided with an other entity
     *
     * @param ship
     */
    @Override
    public void visit(SpaceShipAI ship) {
        //we do nothing
    }

    /**
     * Check if an asteroid has collided with an other entity
     *
     * @param asteroid Asteroid to check collision with
     */
    @Override
    public void visit(Asteroid asteroid) {
        //we do nothing
    }

    /**
     * Check if a blue laser has collided with an other entity
     *
     * @param laser Laser to check collision with
     */
    @Override
    public void visit(BlueLaser laser) {
        visit((Laser) laser);
    }

    /**
     * Check if a green laser has collided with an other entity
     *
     * @param laser Laser to check collision with
     */
    @Override
    public void visit(GreenLaser laser) {
        visit((Laser) laser);
    }

    /**
     * Check if a laser has collided with an other entity
     * If the laser has collided with an other entity, the laser is destroyed
     * and the other entity is damaged or destroyed
     *
     * @param laser Laser to check collision with
     */
    @Override
    public void visit(Laser laser) {
        for (Entity entity : controller.getEntities()) {
            if (laser == entity || laser.getOwner() == entity) continue;
            if (isColliding(laser, entity)) {
                if (laser.getOwner() != controller.getPlayerShip() && entity != controller.getPlayerShip()) {
                    continue;
                }
                laser.kill();
                entity.setLife(entity.getLife() - laser.getDamage());
                if (!entity.isAlive()) {
                    controller.getGameInfo().addScore(1);
                }

            }
        }
    }

    /**
     * Check if two entities are colliding
     *
     * @param entity First entity to check collision with
     * @param other  Second entity to check collision with
     * @return If the two entities are colliding
     */
    public boolean isColliding(Entity entity, Entity other) {
        return Intersector.overlaps(entity.getHitbox(), other.getHitbox());
    }

    protected GameController getController() {
        return controller;
    }
}
