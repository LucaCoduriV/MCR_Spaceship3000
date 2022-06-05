package ch.crepe.game.visitor;

import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.ship.weapons.projectiles.Projectile;

public interface Visitor {
    void visitEntity(Entity entity);
    void visitProjectile(Projectile projectile);
}
