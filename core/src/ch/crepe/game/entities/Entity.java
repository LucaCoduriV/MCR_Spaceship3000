package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity {
    protected Vector2 speed;
    protected final DisplayedAsset asset;


    public Entity(DisplayedAsset asset, Vector2 speed) {
        this.asset = asset;
        this.speed = speed;
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 position() {
        return asset.getDrawingArea().getPosition(new Vector2());
    }

    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        asset.draw(batch);
    }

    public void update(float delta){
        asset.setPosition(asset.getDrawingArea().getPosition(new Vector2()).add(speed));
    }

    public Vector2 speed() {
        return speed;
    }

    public Rectangle getDrawingArea() {
        return asset.getDrawingArea();
    }
}
