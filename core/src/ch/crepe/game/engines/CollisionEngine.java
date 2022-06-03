package ch.crepe.game.engines;

import ch.crepe.game.entities.Entity;
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
                //System.out.println("Collision between " + ship.getClass().getSimpleName() + " and " + other.getClass().getSimpleName());
            }
        }
    }
}
