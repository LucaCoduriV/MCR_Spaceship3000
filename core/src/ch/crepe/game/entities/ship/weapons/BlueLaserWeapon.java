package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import com.badlogic.gdx.math.Vector2;

public class BlueLaserWeapon extends Weapon {
    public BlueLaserWeapon(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    public void createProjectile() {
        getSpaceship().getGameController().addProjectile(
                new BlueLaser(
                        new Vector2(getSpaceship().getCenter().add(new Vector2())),
                        getSpaceship().getOrientation() + 90,
                        getOwner()));
    }
}
