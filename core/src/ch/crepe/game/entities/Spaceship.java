package ch.crepe.game.entities;

import ch.crepe.game.entities.ship.weapons.Weapen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapen weapen;
    private float speed;

    public Spaceship(Vector2 position, Texture texture, float speed) {
        super(position, texture);
        this.speed = speed;
    }

    public void setWeapen(Weapen weapen) {
        this.weapen = weapen;
    }

    @Override
    public void move(Vector2 direction) {
        setPosition(new Vector2(
                position().x + Gdx.graphics.getDeltaTime() * speed,
                position().y + Gdx.graphics.getDeltaTime() * speed
        ));
    }
}
