package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity implements Visitable {
    protected final Sprite sprite;
    protected final float width;
    protected final float height;
    protected final Rectangle hitbox;
    private Vector2 speed;
    private final float reduction = 1f;

    public Entity(Vector2 position, Sprite sprite,  Vector2 speed, float width, float height) {
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
        return new Vector2(hitbox.x, hitbox.y);
    }

    protected void setPosition(Vector2 position) {
        this.hitbox.x = position.x;
        this.hitbox.y = position.y;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        getSprite().setPosition(hitbox.x - (width - hitbox.width) / 2,
                hitbox.y - (height - hitbox.height) / 2);
        getSprite().draw(batch);
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void update(float delta){
        hitbox.x += speed.x;
        hitbox.y += speed.y;
    }

    public Vector2 speed() {
        return speed;
    }
}
