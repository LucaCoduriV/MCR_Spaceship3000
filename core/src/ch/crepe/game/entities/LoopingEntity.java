package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Batch;
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
    protected final DisplayedAsset asset;
    /**
     * Area in which the Entity is confined.
     */
    private final Rectangle bounds;

    /**
     * Creates an instance of LoopingEntity.
     * @param position Position of the Entity.
     * @param asset Asset displayed by the entity.
     * @param speed Speed at which the entity is moving.
     * @param respawnPosition Position where the entity returns to when it's out of bounds.
     * @param bounds Area in which the Entity is confined.
     * @param width Width of the hitbox.
     * @param height Height of the hitbox.
     */
    public LoopingEntity(Vector2 position, DisplayedAsset asset, Vector2 speed, Vector2 respawnPosition, Rectangle bounds, float width, float height) {
        super(position, speed, width, height, 0); //TODO orientation
        this.asset = asset;
        this.respawnPosition = new Vector2(respawnPosition);
        this.bounds = new Rectangle(bounds);
    }



    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        asset.draw(batch);
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
        if(!bounds.overlaps(getHitbox())){
            System.out.println("Reseting position");
            setCenter(respawnPosition.cpy());
            return false;
        }
        return true;
    }


    @Override
    public void accept(Visitor v) {
    }

    public Rectangle getDrawingArea() {
        return asset.getDrawingArea();
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        asset.setCenter(new Vector2(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height / 2));
    }
}
