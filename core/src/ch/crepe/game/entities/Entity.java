package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.visitor.Visitable;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class Entity implements Visitable {
    protected final DisplayedAsset asset;
    protected final float width;
    protected final float height;
    protected final Rectangle hitbox;
    protected final Vector2 speed; // TODO getter protected
    private final float reduction = 0.6f;

    public Entity(Vector2 position, DisplayedAsset asset, Vector2 speed, float width, float height) {
        this.asset = asset;
        this.height = height;
        this.width = width;
        this.hitbox = new Rectangle(0, 0, width * reduction, height * reduction);
        this.hitbox.setCenter(position);
        this.speed = new Vector2(speed);
    }

    /**
     * Get the position or update it.
     * @return entity position.
     */
    public Vector2 position() {
//        return asset.getDrawingArea().getPosition(new Vector2()); TODO delete si ça marche
        return new Vector2(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height / 2);
    }

    protected void setPosition(Vector2 position) {
        this.hitbox.x = position.x;
        this.hitbox.y = position.y;
        asset.setPosition(new Vector2(hitbox.x + hitbox.width / 2, hitbox.y + hitbox.height / 2)); // TODO setCenter sinon ça marche pas je crois
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    //TODO temporaire en attendant visiteur
    public void draw(Batch batch) {
        asset.draw(batch);
    }

    public void update(float delta){
        setPosition(hitbox.getPosition(new Vector2()).add(speed()));
    }

    public Vector2 speed() {
        return speed;
    }

    public Rectangle getDrawingArea() {
        return asset.getDrawingArea();
    }
}
