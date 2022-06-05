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
    private final Vector2 speed;
    private final float reduction = 0.6f;
    private int life;
    private final int damage;
    private int points;

    public Entity(Vector2 position, Sprite sprite,  Vector2 speed, float width, float height) {
        this.sprite = sprite;
        this.height = height;
        this.width = width;
        this.hitbox = new Rectangle(0, 0, width * reduction, height * reduction);
        this.hitbox.setCenter(position);
        this.speed = speed;
        this.life = 20;
        this.damage = 5;
        this.points = 0;
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 position() {
        return new Vector2(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height / 2);
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
        getSprite().setCenter(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height / 2);
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

    public boolean isAlive() {
        return life > 0;
    }

    public int getLife() {
        return life;
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

    public int getScore() {
        return points;
    }

    public void increaseScore() {
        points += 1;
    }
}
