package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;

abstract public class Weapon {
    private Spaceship spaceship;

    protected Weapon(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    abstract void createProjectile();
    abstract void createExplosion();

    public Spaceship getSpaceship() {
        return spaceship;
    }
}
