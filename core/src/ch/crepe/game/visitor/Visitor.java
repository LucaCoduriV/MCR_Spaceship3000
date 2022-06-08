package ch.crepe.game.visitor;

import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

/**
 * Interface representing a visitor in the design pattern Visitor
 */
public interface Visitor {
    void visit(Spaceship ship);
    void visit(SpaceShipAI ship);
    void visit(Asteroid asteroid);
    void visit(BlueLaser laser);
    void visit(GreenLaser laser);
    void visit(Laser laser);
}
