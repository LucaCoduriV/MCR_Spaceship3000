package ch.crepe.game.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class DisplayedSprite extends DisplayedAsset {
    private Sprite sprite;

    public DisplayedSprite(Texture texture, Rectangle spriteArea) {
        super(spriteArea);
        this.sprite = new Sprite(texture);
        //sprite.setSize(size.x, size.y);
        //sprite.setPosition(position.x, position.y); // TODO setCenter
    }

    @Override
    public void setPosition(Vector2 newPosition) {
        super.setPosition(newPosition);
    }

    @Override
    protected TextureRegion getDrawable() {
        return sprite;
    }
}
