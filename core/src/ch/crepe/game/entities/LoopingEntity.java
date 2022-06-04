package ch.crepe.game.entities;

import ch.crepe.game.assets.DisplayedAsset;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class LoopingEntity extends Entity{
    private final Rectangle bounds;
    private final Vector2 respawnPosition;

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

    // if the star is out of bounds, return it to the base position
    private boolean checkBounds() {
        if(!bounds.contains(position())){
            System.out.println("Reseting position");
            asset.setPosition(respawnPosition.cpy());
            return false;
        }
        return true;
    }

    public Rectangle getDrawingArea() {
        return asset.getDrawingArea();
    }
}
