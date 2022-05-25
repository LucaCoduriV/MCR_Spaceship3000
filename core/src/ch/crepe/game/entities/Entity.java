package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity {
    private Vector2 position;
    private final Sprite sprite;

    public Entity(Vector2 position, Texture texture) {
        this(position, new Sprite(texture));
    }

    public Entity(Vector2 position, Sprite sprite) {
        this.position = position;
        this.sprite = sprite;
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 position() {
        return position;
    }

    protected void setPosition(Vector2 position) {
        this.position = position;
    }

    abstract public void move(Vector2 direction);

}
