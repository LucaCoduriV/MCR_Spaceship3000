package ch.crepe.game.entities.asteroids;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.KillableEntity;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import com.badlogic.gdx.math.Vector2;

import ch.crepe.game.visitor.Visitor;

public abstract class Asteroid extends KillableEntity {
    protected Asteroid(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); //TODO orientation
    }

    @Override
    public void visit(Spaceship ship) {

    }

    @Override
    public void visit(SpaceShipAI ship) {

    }

    @Override
    public void visit(BlueAsteroid asteroid) {

    }

    @Override
    public void visit(GreenAsteroid asteroid) {

    }
}
