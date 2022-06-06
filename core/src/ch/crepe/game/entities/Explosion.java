package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;


public class Explosion extends Entity {

    public Explosion(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); // TODO orientation
    }

    @Override
    public void accept(Visitor v) {

    }
}
