package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends Entity {
    public Asteroid(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
