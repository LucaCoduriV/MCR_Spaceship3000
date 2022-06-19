package ch.crepe.game;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;
import java.util.List;

/**
 * This class is a utility class to clean entities which are dead or out of the world bounds.
 */
public class EntityCleaner {
    private final List<Entity> entities;
    private final Rectangle bounds;

    /**
     * Constructor of the entity cleaner from a list of entities and world bounds.
     * @param entities The list of entities
     * @param bounds The world bounds
     */
    public EntityCleaner(List<Entity> entities, Rectangle bounds) {
        this.entities = entities;
        this.bounds = bounds;
    }

    /**
     * Clean the entities.
     */
    public void update() {
        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {
            Entity entity = it.next();
            if (isOutOfBounds(entity) || !entity.isAlive()) {
                it.remove();
            }
        }
    }

    /**
     * Check if an entity is out of the world bounds.
     * @param entity The entity to check
     * @return True if the entity is out of the world bounds, false otherwise
     */
    protected boolean isOutOfBounds(Entity entity) {
        return !bounds.overlaps(entity.getHitbox());
    }

    /**
     * Get the bounds of the world.
     * @return The world bounds
     */
    protected Rectangle getBounds() {
        return bounds;
    }
}
