package ch.crepe.game.entities.asteroids;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import com.badlogic.gdx.math.Vector2;

import ch.crepe.game.visitor.Visitor;

public abstract class Asteroid extends Entity {
    protected Asteroid(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); //TODO orientation
    }
}
