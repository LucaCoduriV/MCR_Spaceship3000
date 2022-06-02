package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

public class LaserWeapon extends Weapon {
    public LaserWeapon(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    void createProjectile() {
        //TODO changer direction
        new Laser(getSpaceship().position());
    }

    @Override
    void createExplosion() {

    }
}
