package ch.crepe.game.visitor;

import ch.crepe.game.entities.asteroids.Asteroid;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

public interface Visitor {
    void visit(Spaceship ship);
    void visit(SpaceShipAI ship);
    void visit(BlueAsteroid asteroid);
    void visit(GreenAsteroid asteroid);
}
