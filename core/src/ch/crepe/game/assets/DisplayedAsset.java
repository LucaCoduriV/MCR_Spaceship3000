package ch.crepe.game.assets;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public abstract class DisplayedAsset {
    protected Vector2 position;

    public DisplayedAsset(Vector2 position) {
        this.position = new Vector2(position);
    }

    public abstract void draw(Batch batch);
    public Vector2 position() {
        return new Vector2(position);
    }
    public void setPosition(Vector2 newPosition) {
        position = new Vector2(newPosition);
    }
}
