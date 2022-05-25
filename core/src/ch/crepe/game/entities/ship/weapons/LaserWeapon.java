package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class LaserWeapon extends Weapen {
    public LaserWeapon(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    void createProjectile() {
        //TODO changer direction
        new Laser(getSpaceship().position(), new Vector2());
    }

    @Override
    void createExplosion() {

    }
}
