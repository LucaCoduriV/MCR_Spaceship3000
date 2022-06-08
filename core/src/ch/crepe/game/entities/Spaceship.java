package ch.crepe.game.entities;

import ch.crepe.game.GameController;
import ch.crepe.game.engines.CollisionEngine;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.entities.ship.weapons.GreenLaserWeapon;
import ch.crepe.game.entities.ship.weapons.Weapon;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends KillableEntity {
    private Weapon weapon;

    /**
     * Gets the orientation of the ship
     * @return The orientation of the ship in degrees
     */



    private final GameController gameController;
    private final ShapeRenderer renderer = new ShapeRenderer();
    private final static float HITBOX_PERCENTAGE = 0.6f;

    public Spaceship(Vector2 position, Vector2 speed, GameController gameController, float width, float height, float orientation) {
        super(position, speed, width * HITBOX_PERCENTAGE, height * HITBOX_PERCENTAGE, orientation);
        this.weapon = new GreenLaserWeapon(this);
        this.gameController = gameController;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void shoot() {
        weapon.createProjectile();
    }

    public GameController getGameController() {
        return gameController;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    @Override
    public void visit(Spaceship ship) {
        if(CollisionEngine.isColliding(ship, this)) {
            if (this != ship) {
                ship.setLife(getLife() - ship.getDamage());
                gameController.getGameInfo().addScore(1);
                ship.setLife(0);
            }
        }
    }

    //TODO factoriser les 3 fonctions
    @Override
    public void visit(SpaceShipAI ship) {
        visit((Spaceship) ship);
    }

    @Override
    public void visit(BlueAsteroid asteroid) {
        if(CollisionEngine.isColliding(asteroid, this)) {
            asteroid.setLife(getLife() - asteroid.getDamage());
            gameController.getGameInfo().addScore(1);
            asteroid.setLife(0);
        }
    }

    @Override
    public void visit(GreenAsteroid asteroid) {
        if(CollisionEngine.isColliding(asteroid, this)) {
            asteroid.setLife(getLife() - asteroid.getDamage());
            gameController.getGameInfo().addScore(1);
            asteroid.setLife(0);
        }
    }
}
