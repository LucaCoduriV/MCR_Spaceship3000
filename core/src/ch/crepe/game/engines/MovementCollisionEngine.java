package ch.crepe.game.engines;

import ch.crepe.game.EnemySpawner;
import ch.crepe.game.GameController;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

public class MovementCollisionEngine extends CollisionEngine {
    public MovementCollisionEngine(GameController controller) {
        super(controller);
    }

    @Override
    public void visit(Laser laser) {
        for (Entity entity : getController().getEntities()) {
            if(laser == entity || laser.getOwner() == entity) continue;
            if(isColliding(laser, entity)) {
                if(laser.getOwner() != getController().getPlayerShip() && entity != getController().getPlayerShip()){
                    continue;
                }
                laser.kill();
                entity.setLife(entity.getLife() - laser.getDamage());

                if (entity != getController().getPlayerShip()) {
                    entity.speed().set(EnemySpawner.generateRandomDirection(entity.getPositon(), getController().getWorldBounds().getWidth(), getController().getWorldBounds().getHeight()));
                }

                if(!entity.isAlive()) {
                    getController().getGameInfo().addScore(1);
                }

            }
        }
    }
}
