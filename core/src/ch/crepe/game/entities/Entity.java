package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity {
    private Vector2 position;
    private Vector2 speed;
    private final Sprite sprite;

    public Entity(Vector2 position, Texture texture, Vector2 speed) {
        this(position, new Sprite(texture), speed);
    }

    public Entity(Vector2 position, Sprite sprite, Vector2 speed) {
        this.position = position;
        this.sprite = sprite;
        this.speed = speed;
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 position() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        getSprite().setCenter(position().x, position().y);
        getSprite().draw(batch);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void update(float delta){
        position.add(speed);
    }

    public Vector2 speed() {
        return speed;
    }
}
