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

import java.util.LinkedList;

public class CollisionEngine extends Engine {
    private final GameController controller;

    public CollisionEngine(GameController controller) {
        this.controller = controller;
    }

    /**
     * Spaceship vs Spaceship
     */
    @Override
    public void visit(Spaceship ship) {
        for (Entity other : controller.getEntities()) {
            if(ship == other) continue;
            if(isColliding(ship, other)) {
                ship.setLife(ship.getLife() - other.getDamage());
                controller.getGameInfo().addScore(1);
                other.setLife(0);
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
        for (Entity entity : controller.getEntities()) {
            if(laser == entity || laser.getOwner() == entity) continue;
            if(isColliding(laser, entity)) {
                if(laser.getOwner() != controller.getPlayerShip() && entity != controller.getPlayerShip()){
                    continue;
                }
                laser.kill();
                entity.setLife(entity.getLife() - laser.getDamage());
                if(!entity.isAlive()) {
                    controller.getGameInfo().addScore(1);
                }

            }
        }
    }

    public boolean isColliding(Entity entity, Entity other) {
        return Intersector.overlaps(entity.getHitbox(), other.getHitbox());
    }
}
