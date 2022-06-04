package ch.crepe.game.assets;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public abstract class DisplayedAsset {
    protected Rectangle drawingArea;

    public DisplayedAsset(Rectangle drawingArea) {
        this.drawingArea = new Rectangle(drawingArea);
    }

    public void draw(Batch batch) {
        batch.draw(getDrawable(), drawingArea.getX(), drawingArea.getY(), drawingArea.getWidth(), drawingArea.getHeight());
    };
    public Vector2 position() {
        return drawingArea.getPosition(new Vector2());
    }
    public void setPosition(Vector2 newPosition) {
        drawingArea.setPosition(newPosition);
    }

    public Rectangle getDrawingArea() {
        return new Rectangle(drawingArea);
    }

    protected abstract TextureRegion getDrawable();
}
