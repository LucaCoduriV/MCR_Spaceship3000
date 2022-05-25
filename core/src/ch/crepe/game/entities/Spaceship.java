package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private final Sprite sprite;
    Spaceship(Vector2 position, Texture texture) {
        super(position);
        sprite = new Sprite(texture);
    }
}
