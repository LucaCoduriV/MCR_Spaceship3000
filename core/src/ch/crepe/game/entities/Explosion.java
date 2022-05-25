package ch.crepe.game.entities;

import ch.crepe.game.animation.Animation;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Explosion extends Entity {
    private final Animation animation;
    Explosion(Vector2 position, Animation animation) {
        super(position);
        this.animation = animation;
    }
}
