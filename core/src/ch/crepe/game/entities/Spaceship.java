package ch.crepe.game.entities;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.ship.weapons.LaserWeapon;
import ch.crepe.game.entities.ship.weapons.Weapon;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapon weapon;
    private GameController gameController;

    public Spaceship(Vector2 position, Texture texture, Vector2 speed, GameController gameController) {
        super(position, texture, speed);
        getSprite().setSize(10, 10);
        getSprite().setCenter(getSprite().getWidth() / 2,getSprite().getHeight() / 2);
        this.weapon = new LaserWeapon(this);
        this.gameController = gameController;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


    //TODO temporaire en attendant visiteur
    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    public void shoot() {
        weapon.createProjectile();
    }

    public GameController getGameController() {
        return gameController;
    }
}
