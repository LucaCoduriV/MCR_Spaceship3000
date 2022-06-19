package ch.crepe.game.engines;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

/**
 * Engine managing the collision between entities. Size of the entities that
 * aren't the main spaceship get smaller if they collide with laser from the main
 * spaceship. Main spaceship's size get bigger if it collides with an other
 * entity or a laser.
 * This class is implemented as a visitor.
 */
public class SizeCollisionEngine extends CollisionEngine {
    private static final float SIZE_MULT = 0.7f;

    public SizeCollisionEngine(GameController controller) {
        super(controller);
    }

    @Override
    public void visit(Laser laser) {
        for (Entity entity : getController().getEntities()) {
            if (laser == entity || laser.getOwner() == entity) continue;
            if (isColliding(laser, entity)) {
                if (laser.getOwner() != getController().getPlayerShip() && entity != getController().getPlayerShip()) {
                    continue;
                }
                laser.kill();
                entity.setLife(entity.getLife() - laser.getDamage());
                entity.setSize(entity.getWidth() * SIZE_MULT, entity.getHeight() * SIZE_MULT);
                if (!entity.isAlive()) {
                    getController().getGameInfo().addScore(1);
                }

            }
        }
    }
}
