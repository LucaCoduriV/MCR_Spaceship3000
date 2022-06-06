package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import com.badlogic.gdx.math.Vector2;

import ch.crepe.game.visitor.Visitor;

public class Asteroid extends Entity {
    public Asteroid(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); //TODO orientation
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
