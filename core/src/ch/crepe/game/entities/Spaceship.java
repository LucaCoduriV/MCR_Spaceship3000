package ch.crepe.game.entities;

import ch.crepe.game.PlayerInput;
import ch.crepe.game.entities.ship.weapons.Weapen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapen weapen;

    public Spaceship(Vector2 position, Texture texture, Vector2 speed) {
        super(position, texture, speed);
        getSprite().setSize(10, 10);
        getSprite().setCenter(getSprite().getWidth() / 2,getSprite().getHeight() / 2);
    }

    public void setWeapen(Weapen weapen) {
        this.weapen = weapen;
    }


    //TODO temporaire en attendant visiteur
    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }
}
