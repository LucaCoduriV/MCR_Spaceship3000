package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends VectorialMovableEntity {
    static int SPEED = 2;

    public Asteroid(Vector2 position, Texture texture) {
        super(position, texture, SPEED);
    }

    @Override
    public void move() {
        vectorialMove(new Vector2(0, -1));
    }
}
