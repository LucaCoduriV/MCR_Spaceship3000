package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;


public class Explosion extends Entity {

    public Explosion(Vector2 position, DisplayedAsset animation, Vector2 speed, float width, float height) {
        super(position, animation, speed, width, height);
    }

    @Override
    public void accept(Visitor v) {

    }
}
