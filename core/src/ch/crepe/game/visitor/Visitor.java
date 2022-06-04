package ch.crepe.game.visitor;

import ch.crepe.game.entities.Entity;

public interface Visitor {
    void visitEntity(Entity entity);
}
