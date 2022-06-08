package ch.crepe.game.entities.asteroids;

import ch.crepe.game.entities.KillableEntity;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import com.badlogic.gdx.math.Vector2;

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
    public void visit(GreenLaser greenLaser) {

    }

    @Override
    public void visit(BlueLaser blueLaser) {

    }

    @Override
    public void visit(BlueAsteroid asteroid) {

    }

    @Override
    public void visit(GreenAsteroid asteroid) {

    }
}
