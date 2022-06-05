package ch.crepe.game.assets.displayers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

/**
 * Represent an animation that can be drawn on the screen.
 * <p>
 *     The animation is created from a sprite-sheet.
 * </p>
 * @author      nelson.jeanrenaud@heig-vd.ch
 */
public class DisplayedAnimation extends DisplayedAsset{
    /**
     * List of sprites composing the animation
     */
    private final Animation<TextureRegion> animation;
    /**
     * Current time since the start of the animation
     */
    private float elapsedTime = 0f;

    /**
     * Creates a displayable animation from a sprite-sheet.
     * @param texture Sprite-sheet used to build the animation.
     * @param animationArea Area in which the frames will be drawn.
     * @param tileWidth Width of the tiles in the sprite-sheet.
     * @param tileHeight Height of the tiles in the sprite-sheet.
     * @param secondsPerFrame Time between frames in seconds.
     */
    public DisplayedAnimation(Texture texture, Rectangle animationArea, int tileWidth, int tileHeight, float secondsPerFrame) {
        super(animationArea);

        TextureRegion[][] frameTiles = TextureRegion.split(texture,tileWidth,tileHeight);

        if(frameTiles.length == 0 || frameTiles[0].length == 0) {
            throw new IllegalArgumentException("Can't extract tiles from Texture");
        }


        TextureRegion[] animationFrames = new TextureRegion[frameTiles.length * frameTiles[0].length];

        int index = 0;
        for (TextureRegion[] frameTileLine : frameTiles) {
            for(TextureRegion frameTile : frameTileLine) {
                animationFrames[index++] = frameTile;
            }
        }
        animation = new Animation<>(secondsPerFrame, animationFrames);
    }

    @Override
    public void draw(Batch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime(); // TODO mettre en parametre ?
        super.draw(batch);
    }

    @Override
    protected TextureRegion getDrawable() {
        return animation.getKeyFrame(elapsedTime, true);
    }
}
