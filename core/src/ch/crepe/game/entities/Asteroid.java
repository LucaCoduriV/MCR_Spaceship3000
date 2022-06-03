package ch.crepe.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

import ch.crepe.game.visitor.Visitor;

public class Asteroid extends Entity {

    //public Asteroid(Vector2 position, Sprite sprite, Vector2 speed) {
    //super(position, sprite, speed);
    public Asteroid(Vector2 position, Sprite sprite, Vector2 speed, float width, float height) {
        super(position, sprite, speed, width, height);
    }

    @Override
    public void accept(Visitor v) {

    }
}
