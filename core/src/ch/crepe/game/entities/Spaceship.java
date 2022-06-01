package ch.crepe.game.entities;

import ch.crepe.game.PlayerInput;
import ch.crepe.game.entities.ship.weapons.Weapen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends VectorialMovableEntity {
    private Weapen weapen;
    private float speed;

    public Spaceship(Vector2 position, Texture texture, float speed) {
        super(position, texture, speed);
        this.speed = speed;
    }

    public void setWeapen(Weapen weapen) {
        this.weapen = weapen;
    }

    @Override
    public void move() {
        vectorialMove(PlayerInput.getInstance().getMove());

    }
}
