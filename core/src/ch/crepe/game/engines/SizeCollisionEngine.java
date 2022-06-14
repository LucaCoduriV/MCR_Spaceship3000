package ch.crepe.game.engines;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

public class SizeCollisionEngine extends CollisionEngine {
    private final float sizeMult = 0.7f;

    public SizeCollisionEngine(GameController controller) {
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
                entity.setSize(entity.getWidth() * sizeMult, entity.getHeight() * sizeMult);
                if(!entity.isAlive()) {
                    getController().getGameInfo().addScore(1);
                }

            }
        }
    }
}
