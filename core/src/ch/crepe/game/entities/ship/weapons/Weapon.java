package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;

abstract public class Weapon {
    private Spaceship spaceship;

    protected Weapon(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    public abstract void createProjectile();

    protected Spaceship getSpaceship() {
        return spaceship;
    }
}
