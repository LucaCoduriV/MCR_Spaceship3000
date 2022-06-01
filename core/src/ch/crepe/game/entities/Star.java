package ch.crepe.game.entities;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Laser;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Star extends Entity {
    private Float speed;
    private Rectangle bounds;

    private Vector2 basePosition;

    private Vector2 respawnPosition;

    private Sprite sprite;

    public Star(Vector2 respawnPosition, Vector2 basePosition, Float speed, Rectangle bounds) {
        super(basePosition);
        
        this.basePosition = new Vector2(basePosition.x, basePosition.y);
        this.respawnPosition = new Vector2(respawnPosition.x, respawnPosition.y);
        this.speed = speed;
        this.bounds = bounds;

        sprite = new Sprite(AssetsLoader.getInstance().getLaser(Laser.blueFast));
        sprite.setPosition(basePosition.x, basePosition.y);
        sprite.setSize(10, 10); // TODO factory bref modif
    }

    public void move() {
        if(checkBounds())
            setPosition(position().sub(0, speed));
    }

    // if the star is out of bounds, return it to the base position
    private boolean checkBounds() {
        if(!bounds.contains(position())){
            System.out.println("Reseting position");
            setPosition(respawnPosition);
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
