package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitable;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity implements Visitable {

    protected float width;
    protected float height;
    protected final Rectangle hitbox;
    protected final Vector2 speed; // TODO getter protected

    private int life;
    private final int damage;

    private static final int DEFAULT_LIFE = 20;
    private float orientation;

    public Entity(Vector2 position, Vector2 speed, float width, float height, float orientation) {
        this.height = height;
        this.width = width;
        this.hitbox = new Rectangle(0, 0, width, height);
        this.hitbox.setCenter(position);
        this.speed = new Vector2(speed);
        this.life = DEFAULT_LIFE;
        this.damage = 5;
        this.orientation = orientation;

    }
    public float getOrientation() {
        return orientation;
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 getCenter() {
        return new Vector2(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height / 2);
    }

    public Vector2 getPositon() {
        return hitbox.getPosition(new Vector2());
    }

    public void setPosition(Vector2 position) {
        this.hitbox.x = position.x;
        this.hitbox.y = position.y;
    }

    public void setCenter(Vector2 position) {
        setPosition(new Vector2(position.x - getHitbox().getWidth() / 2, position.y - getHitbox().getHeight() / 2));
    }
    public Rectangle getHitbox() {
        return hitbox;
    }

    public void update(float delta){
        setPosition(hitbox.getPosition(new Vector2()).add(speed()));
    }

    public Vector2 speed() {
        return speed;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public int getLife() {
        return life;
    }

    public int getPercentLife() {
        return (int) ((life / (float) DEFAULT_LIFE) * 100);
    }

    public int getDamage() {
        return damage;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void kill() {
        this.life = 0;
    }

    public void setSize(float width, float height) {
        this.width = width;
        this.height = height;

        hitbox.setSize(0.8f * width, 0.8f * height);
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
