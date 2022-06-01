package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends Entity {

    public Asteroid(Vector2 position, Sprite sprite, Vector2 speed, float width, float height) {
        super(position, sprite, speed, width, height);
    }

    @Override
    public void accept(Visitor v) {

    }
}
