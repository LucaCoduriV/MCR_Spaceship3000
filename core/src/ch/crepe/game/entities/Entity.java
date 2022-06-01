package ch.crepe.game.entities;

import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
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

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position().y;
    }
}
