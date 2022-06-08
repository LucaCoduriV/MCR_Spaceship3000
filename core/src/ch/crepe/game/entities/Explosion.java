package ch.crepe.game.entities;

import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;


public class Explosion extends Entity {

    public Explosion(Vector2 position, Vector2 speed, float width, float height) {
        super(position, speed, width, height, 0); // TODO orientation
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

    @Override
    public void visit(GreenLaser greenLaser) {

    }

    @Override
    public void visit(BlueLaser blueLaser) {

    }

    @Override
    public void accept(Visitor v) {

    }
}
