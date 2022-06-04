package ch.crepe.game.entities;

import ch.crepe.game.assets.DisplayedAsset;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.graalvm.compiler.core.common.cfg.Loop;

public class LoopingSprite extends Entity{
    private final Rectangle bounds;
    private final Vector2 respawnPosition;

    public LoopingSprite(DisplayedAsset asset, Vector2 speed, Vector2 respawnPosition, Rectangle bounds) {
        super(asset, speed);
        this.respawnPosition = new Vector2(respawnPosition);
        this.bounds = new Rectangle(bounds); // TODO est-ce qu'il faut copier ce genre de paramètre enfaite ?
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
}
