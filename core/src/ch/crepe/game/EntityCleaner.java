package ch.crepe.game;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Iterator;
import java.util.List;

public class EntityCleaner {
    private final List<Entity> entities;
    private final Rectangle bounds;

    public EntityCleaner(List<Entity> entities, Rectangle bounds) {
        this.entities = entities;
        this.bounds = bounds;
    }

    public void update(float delta){
        // TODO Il est peut-être mieux d'éviter de boucler tout le temps sur la liste des entités, mais plutôt de le faire une seule fois pour toute les opérations.
        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {
            Entity entity = it.next();
            if(isOutOfBounds(entity)){
                it.remove();
            }
        }
    }

    protected boolean isOutOfBounds(Entity entity){
        return !bounds.overlaps(entity.getHitbox());
    }

    protected Rectangle getBounds(){
        return bounds;
    }
}
