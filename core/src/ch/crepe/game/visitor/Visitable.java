package ch.crepe.game.visitor;

public interface Visitable {
    void accept(VisitorEngine v);
}