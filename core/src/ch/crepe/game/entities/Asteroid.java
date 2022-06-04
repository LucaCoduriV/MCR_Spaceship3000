package ch.crepe.game.entities;

import ch.crepe.game.assets.DisplayedAsset;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Asteroid extends Entity {
    public Asteroid(DisplayedAsset asset, Vector2 speed) {
        super(asset, speed);
    }
/*
    public Asteroid(Vector2 position, Texture texture, Vector2 speed) {
        super(position, texture, speed);
    }
    public Asteroid(Vector2 position, Sprite sprite, Vector2 speed) {
        super(position, sprite, speed);
    }*/
}
