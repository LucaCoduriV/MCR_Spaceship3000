package ch.crepe.game.entities;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.ship.weapons.GreenLaserWeapon;
import ch.crepe.game.entities.ship.weapons.Weapon;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private static final float HITBOX_PERCENTAGE = 0.6f;
    /**
     * Gets the orientation of the ship
     *
     * @return The orientation of the ship in degrees
     */


    private final GameController gameController;
    private Weapon weapon;

    public Spaceship(Vector2 position, Vector2 speed, GameController gameController, float width, float height, float orientation) {
        super(position, speed, width * HITBOX_PERCENTAGE, height * HITBOX_PERCENTAGE, orientation);
        this.weapon = new GreenLaserWeapon(this);
        this.gameController = gameController;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        weapon.createProjectile();
    }

    public GameController getGameController() {
        return gameController;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
