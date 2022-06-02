package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class LoopingSprite extends Entity {
    private Float speed;
    private Rectangle bounds;
    private Vector2 respawnPosition;

    public Sprite getSprite() {
        return sprite;
    }

    private Sprite sprite;

    public LoopingSprite(Texture texture, Vector2 size, Vector2 respawnPosition, Vector2 basePosition, Float speed, Rectangle bounds) {
        super(basePosition);
        this.respawnPosition = new Vector2(respawnPosition.x, respawnPosition.y);
        this.speed = speed;
        this.bounds = bounds;

        sprite = new Sprite(texture);
        sprite.setPosition(basePosition.x, basePosition.y);
        sprite.setSize(size.x, size.y);
    }

    public void move() {
        if(checkBounds())
            setPosition(position().sub(0, speed));
    }

    // if the star is out of bounds, return it to the base position
    private boolean checkBounds() {
        if(!bounds.contains(position())){
            System.out.println("Reseting position");
            setPosition(respawnPosition.cpy());
            return false;
        }
        return true;
    }

    @Override
    public void setPosition(Vector2 position) {
        super.setPosition(position);
        sprite.setPosition(position.x, position.y);
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }
}
