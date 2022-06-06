package ch.crepe.game.visitor;

import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;

public interface RenderVisitor {
    void visit(Spaceship ship);
    void visit(SpaceShipAI ship);
    void visit(Asteroid ship);
    void visit(BlueLaser ship);
    void visit(GreenLaser ship);
}
