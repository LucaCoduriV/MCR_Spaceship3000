package ch.crepe.game.visitor;

/**
 * Interface representing a visitable in the design pattern Visitor
 */
public interface Visitable {
    void accept(Visitor v);
}
