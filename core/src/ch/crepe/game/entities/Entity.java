package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity implements Visitable {
    protected Vector2 position;
    protected final Sprite sprite;
    protected final float width;
    protected final float height;
    protected final Rectangle hitbox;
    private Vector2 speed;
    private final float reduction = 0.8f;

    public Entity(Vector2 position, Sprite sprite,  Vector2 speed, float width, float height) {
        this.position = position;
        this.sprite = sprite;
        this.height = height;
        this.width = width;
        this.hitbox = new Rectangle(position.x, position.y, width * reduction, height * reduction);
        this.speed = speed;
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

    public Rectangle getHitbox() {
        return hitbox;
    }

    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        getSprite().setPosition(position().x, position().y);
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
