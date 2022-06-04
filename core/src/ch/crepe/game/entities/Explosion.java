package ch.crepe.game.entities;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import com.badlogic.gdx.math.Vector2;

public class Explosion extends Entity {
    public Explosion(DisplayedAsset asset, Vector2 speed) {
        super(asset, speed);
    }/*
    private final Animation animation;
    Explosion(Vector2 position, Animation animation) {
        super(position, animation.getCurrentSprite(), new Vector2());
        this.animation = animation;
    }*/
}
