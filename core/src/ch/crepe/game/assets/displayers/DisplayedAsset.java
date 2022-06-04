package ch.crepe.game.assets.displayers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


/**
 * Represents an asset that is drawable on the screen.
 * <p>
 *     The shape and position of the drawn asset is defined by a Rectangle given in parameter.
 * </p>
 * <p>
 *     Subclasses needs to provide the concrete type of the drawable asset by overriding the getDrawable method.
 * </p>
 * @author      nelson.jeanrenaud@heig-vd.ch
 */
public abstract class DisplayedAsset {
    /**
     * Area on which the texture is drawn.
     */
    protected Rectangle drawingArea;

    /**
     * Creates an instance of DisplayedAsset.
     * @param drawingArea Area on which the texture is drawn.
     */
    public DisplayedAsset(Rectangle drawingArea) {
        this.drawingArea = new Rectangle(drawingArea);
    }

    /**
     * Draws the asset on the specified batch.
     * @param batch The batch
     */
    public void draw(Batch batch) {
        batch.draw(getDrawable(), drawingArea.getX(), drawingArea.getY(), drawingArea.getWidth(), drawingArea.getHeight());
    }

    /**
     * Returns a copy of the drawing area.
     * @return The area on which the texture is drawn.
     */
    public Rectangle getDrawingArea() {
        return new Rectangle(drawingArea);
    }

    /**
     * Sets the position of the drawable area.
     * @param newPosition The new position of the area.
     */
    public void setPosition(Vector2 newPosition) {
        drawingArea.setPosition(newPosition);
    }

    /**
     * Returns the texture to be drawn.
     * @return the texture
     */
    protected abstract TextureRegion getDrawable();
}
