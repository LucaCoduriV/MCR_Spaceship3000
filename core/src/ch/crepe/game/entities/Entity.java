package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Entity {
    private final Vector2 position;

    Entity(Vector2 position) {
        this.position = position;
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 position() {
        return position;
    }
}
