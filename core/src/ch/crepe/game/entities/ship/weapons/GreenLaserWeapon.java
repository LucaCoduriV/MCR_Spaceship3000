package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import com.badlogic.gdx.math.Vector2;

public class GreenLaserWeapon extends Weapon {
    public GreenLaserWeapon(Spaceship spaceship) {
        super(spaceship);
    }

    @Override
    public void createProjectile() {
        getSpaceship().getGameController().addProjectile(new GreenLaser(new Vector2(getSpaceship().position().add(new Vector2())), getSpaceship().getSprite().getRotation() + 90));
    }
}
