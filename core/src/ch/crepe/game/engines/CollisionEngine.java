package ch.crepe.game.engines;

import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.math.Intersector;

import java.util.LinkedList;

public class CollisionEngine extends Engine {

    private final LinkedList<Spaceship> entities;

    public CollisionEngine(LinkedList<Spaceship> entities) {
        this.entities = entities;
    }

    @Override
    public void visitSpaceship(Spaceship ship) {
        for (Spaceship other : entities) {
            if(ship == other) continue;
            if(Intersector.overlaps(ship.getHitbox(), other.getHitbox())) {
                System.out.println("Collision between " + ship.getClass().getSimpleName() + " and " + other.getClass().getSimpleName());
            }
        }
    }
}
