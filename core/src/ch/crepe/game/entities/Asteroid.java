package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends Entity {

    public Asteroid(Vector2 position, Texture texture) {
        super(position, texture, new Vector2(0, 1));
    }
}
