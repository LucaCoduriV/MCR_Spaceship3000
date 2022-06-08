package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitable;
import com.badlogic.gdx.math.Vector2;

public abstract class KillableEntity extends Entity {
    protected KillableEntity(Vector2 position, Vector2 speed, float width, float height, float orientation) {
        super(position, speed, width, height, orientation);
    }
}
