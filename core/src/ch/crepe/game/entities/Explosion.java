package ch.crepe.game.entities;

import ch.crepe.game.animation.Animation;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;

public class Explosion extends Entity {

    private final Animation animation;

    public Explosion(Vector2 position, Animation animation, Vector2 speed, float width, float height) {
        super(position, animation.getCurrentSprite(), speed, width, height);
        this.animation = animation;
    }

    @Override
    public void accept(Visitor v) {

    }
}
