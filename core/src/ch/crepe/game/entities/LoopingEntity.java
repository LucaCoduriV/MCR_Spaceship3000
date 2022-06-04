package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Represent an Entity that returns to a position when it's out of a specific bounding area.
 * @author      nelson.jeanrenaud@heig-vd.ch
 */
public class LoopingEntity extends Entity{
    /**
     * Position where the Entity returns to when it's out of bounds.
     */
    private final Vector2 respawnPosition;

    /**
     * Area in which the Entity is confined.
     */
    private final Rectangle bounds;

    /**
     * Creates an instance of LoopingEntity.
     * @param asset Asset displayed by the entity.
     * @param speed Speed at which the entity is moving.
     * @param respawnPosition Position where the entity returns to when it's out of bounds.
     * @param bounds Area in which the Entity is confined.
     */
    public LoopingEntity(DisplayedAsset asset, Vector2 speed, Vector2 respawnPosition, Rectangle bounds) {
        super(asset, speed);
        this.respawnPosition = new Vector2(respawnPosition);
        this.bounds = new Rectangle(bounds);
    }

    @Override
    public void update(float delta) {
        if(checkBounds())
            super.update(delta);
    }

    /**
     * If the star is out of bounds, return it to the base position.
     * @return True if the bounds are respected by the entity, false otherwise.
     */
    private boolean checkBounds() {
        if(!bounds.contains(position())){
            System.out.println("Reseting position");
            asset.setPosition(respawnPosition.cpy());
            return false;
        }
        return true;
    }
}
