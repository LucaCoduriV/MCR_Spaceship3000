package ch.crepe.game.entities;

import ch.crepe.game.assets.DisplayedAsset;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
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
        return asset.position();
    }

    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        asset.draw(batch);
    }

    public void update(float delta){
        asset.setPosition(asset.position().add(speed));
    }

    public Vector2 speed() {
        return speed;
    }
}
