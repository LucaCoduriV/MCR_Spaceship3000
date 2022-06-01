package ch.crepe.game.entities;

import ch.crepe.game.PlayerInput;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

abstract public class VectorialMovableEntity extends Entity {
    float speed;

    protected VectorialMovableEntity(Vector2 position, Texture texture, float speed) {
        super(position, texture);
        this.speed = speed;
    }

    protected void vectorialMove(Vector2 direction) {
        setPosition(new Vector2(
                position().x + Gdx.graphics.getDeltaTime() * speed * direction.x,
                position().y + Gdx.graphics.getDeltaTime() * speed * direction.y
        ));
    }
}
