package ch.crepe.game.assets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class DisplayedSprite extends DisplayedAsset {
    private Sprite sprite;

    public DisplayedSprite(Texture texture, Vector2 size, Vector2 position) {
        super(position);
        this.sprite = new Sprite(texture);
        sprite.setSize(size.x, size.y);
        sprite.setPosition(position.x, position.y); // TODO setCenter
    }

    @Override
    public void draw(Batch batch) {
        batch.draw( // TODO regarder la refactorisation
                sprite, position().x, position().y, sprite.getWidth(),
                sprite.getHeight()
        );
    }

    @Override
    public void setPosition(Vector2 newPosition) {
        super.setPosition(newPosition);
        sprite.setPosition(newPosition.x, newPosition.y);
    }
}
