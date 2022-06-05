package ch.crepe.game.visitor;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;

public interface Visitor {
    void visitSpaceship(Spaceship ship);
    void visitLaser(Laser laser);
}
