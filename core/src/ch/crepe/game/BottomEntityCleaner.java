package ch.crepe.game;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

/**
 * This class is a utility class to clean entities which are under the world bounds.
 */
public class BottomEntityCleaner extends EntityCleaner {
    public BottomEntityCleaner(List<Entity> entities, Rectangle bounds) {
        super(entities, bounds);
    }

    /**
     * Check if an entity is under the world bounds.
     * @param entity The entity to check
     * @return True if the entity is under the world bounds, false otherwise
     */
    @Override
    protected boolean isOutOfBounds(Entity entity) {
        return entity.getHitbox().getCenter(new Vector2()).y < getBounds().y;
    }
}
