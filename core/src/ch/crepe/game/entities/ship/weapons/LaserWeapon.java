package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import com.badlogic.gdx.math.Vector2;

public class LaserWeapon extends Weapon {
    public LaserWeapon(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    public void createProjectile() {
        getSpaceship().getGameController().addProjectile(new Laser(new Vector2(getSpaceship().position()), getSpaceship().getSprite().getRotation() + 90));
    }
}
