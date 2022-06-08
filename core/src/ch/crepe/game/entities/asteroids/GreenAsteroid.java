package ch.crepe.game.entities.asteroids;

import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;

public class GreenAsteroid extends Asteroid {
    public GreenAsteroid(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
