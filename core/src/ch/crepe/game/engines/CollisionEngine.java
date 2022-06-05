package ch.crepe.game.engines;

import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.ship.weapons.projectiles.Projectile;
import com.badlogic.gdx.math.Intersector;

import java.util.LinkedList;

public class CollisionEngine extends Engine {

    private final LinkedList<Entity> entities;

    public CollisionEngine(LinkedList<Entity> entities) {
        this.entities = entities;
    }

    @Override
    public void visitEntity(Entity ship) {
        for (Entity other : entities) {
            if(ship == other) continue;
            if(Intersector.overlaps(ship.getHitbox(), other.getHitbox())) {
                System.out.println("Collision between " + ship.getClass().getSimpleName() + " and " + other.getClass().getSimpleName());
            }
        }
    }

    @Override
    public void visitProjectile(Projectile projectile) {
        for (Entity other : entities) {
            if(projectile == other) continue;
            if(Intersector.overlaps(projectile.getHitbox(), other.getHitbox())) {
                System.out.println("Collision between " + projectile.getClass().getSimpleName() + " and " + other.getClass().getSimpleName());
            }
        }
    }
}
