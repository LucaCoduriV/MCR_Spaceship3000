package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;

/**
 * Represents a spaceship weapon.
 */
public abstract class Weapon {
    private final Spaceship spaceship;

    protected Weapon(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public abstract void createProjectile();

    protected Spaceship getSpaceship() {
        return spaceship;
    }

    public Spaceship getOwner() {
        return spaceship;
    }
}
