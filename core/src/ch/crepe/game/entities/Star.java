package ch.crepe.game.entities;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Laser;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Star extends Entity {
    private Vector2 speed;
    private Rectangle bounds;

    private Vector2 basePosition;

    public Star(Vector2 basePosition, Vector2 speed, Rectangle bounds) {
        super(basePosition);
        
        this.basePosition = basePosition;
        this.speed = speed;
        this.bounds = bounds;
    }

    public void move() {
        checkBounds();
        position().add(speed);
    }

    // if the star is out of bounds, return it to the base position
    private void checkBounds() {
        if(!bounds.contains(position())){
            setPosition(basePosition);
        }
    }

    public Texture getTexture(){
        return AssetsLoader.getInstance().getLaser(Laser.blueFast);
    }
}
