package ch.crepe.game.engines;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

public class SizeCollisionEngine extends CollisionEngine {
    private final float sizeMultEnemy = 0.6f;
    private final float sizeMultSpaceship = 1.4f;

    public SizeCollisionEngine(GameController controller) {
        super(controller);
    }

    @Override
    public void visit(Spaceship ship) {
        for (Entity other : getController().getEntities()) {
            if(ship == other) continue;
            if(isColliding(ship, other)) {
                ship.setLife(ship.getLife() - other.getDamage());
                getController().getGameInfo().addScore(1);
                other.setLife(0);
                ship.setSize(ship.getWidth() * sizeMultSpaceship, ship.getHeight() * sizeMultSpaceship);
            }
        }
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

                if (entity != getController().getPlayerShip())
                    entity.setSize(entity.getWidth() * sizeMultEnemy, entity.getHeight() * sizeMultEnemy);

                if(!entity.isAlive()) {
                    getController().getGameInfo().addScore(1);
                }

            }
        }
    }
}
