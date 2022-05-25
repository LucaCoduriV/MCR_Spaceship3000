package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Entity {
    private final Sprite sprite;
    Laser(Vector2 position, Texture texture) {
        super(position);
        sprite = new Sprite(texture);
    }
}
