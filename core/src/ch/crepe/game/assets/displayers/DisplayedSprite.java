package ch.crepe.game.assets.displayers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Represent a drawable sprite on screen.
 * @author      nelson.jeanrenaud@heig-vd.ch
 */
public class DisplayedSprite extends DisplayedAsset {
    /**
     * Sprite drawn.
     */
    private final Sprite sprite;

    /**
     * Creates a sprite from the given texture that can be drawn in the given rectangle.
     * @param texture Texture of the sprite.
     * @param spriteArea Rectangle in which the sprite will be drawn.
     */
    public DisplayedSprite(Texture texture, Rectangle spriteArea) {
        super(spriteArea);
        this.sprite = new Sprite(texture);
        // TODO Vous utilisiez setCenter ?
    }

    public DisplayedSprite(Texture texture, Rectangle spriteArea, Vector2 orientationCenter, float orientation) {
        this(texture, spriteArea);
        sprite.setOrigin(orientationCenter.x, orientationCenter.y);
        sprite.rotate(orientation);
    }

    // TODO ça brise pas carrément l'encapsulation ? :'(
    @Override
    protected Sprite getDrawable() {
        return sprite;
    }

}
