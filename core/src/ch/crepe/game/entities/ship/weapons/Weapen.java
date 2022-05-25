package ch.crepe.game.entities.ship.weapons;

import ch.crepe.game.entities.Spaceship;

abstract public class Weapen {
    private Spaceship spaceship;

    protected Weapen(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    abstract void createProjectile();
    abstract void createExplosion();

    public Spaceship getSpaceship() {
        return spaceship;
    }
}
