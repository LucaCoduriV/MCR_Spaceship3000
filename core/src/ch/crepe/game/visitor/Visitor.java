package ch.crepe.game.visitor;

import ch.crepe.game.entities.Spaceship;

public interface Visitor {
    void visitSpaceship(Spaceship ship);
}
