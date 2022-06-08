package ch.crepe.game;

import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.KillableEntity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class BottomEntityCleaner extends EntityCleaner {
    public BottomEntityCleaner(List<? extends Entity> entities, Rectangle bounds) {
        super(entities, bounds);
    }

    @Override
    protected boolean isOutOfBounds(Entity entity) {
        return entity.getHitbox().getCenter(new Vector2()).y < getBounds().y;
    }
}
