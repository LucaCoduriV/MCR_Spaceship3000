package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import com.badlogic.gdx.graphics.Texture;

public class LaserWeapon extends Weapen {
    public LaserWeapon(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    void createProjectile() {
        new Laser(getSpaceship().position());
    }

    @Override
    void createExplosion() {

    }
}
