package ch.crepe.game.entities;

import ch.crepe.game.entities.ship.weapons.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapon weapon;

    public Spaceship(Vector2 position, Texture texture, Vector2 speed) {
        super(position, texture, speed);
        getSprite().setSize(10, 10);
        getSprite().setCenter(getSprite().getWidth() / 2,getSprite().getHeight() / 2);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    //TODO temporaire en attendant visiteur
    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }
}
