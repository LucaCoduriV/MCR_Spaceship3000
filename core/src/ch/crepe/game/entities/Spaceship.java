package ch.crepe.game.entities;

import ch.crepe.game.GameController;
import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.entities.ship.weapons.GreenLaserWeapon;
import ch.crepe.game.entities.ship.weapons.Weapon;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapon weapon;

    /**
     * Gets the orientation of the ship
     * @return The orientation of the ship in degrees
     */



    private GameController gameController;
    private final ShapeRenderer renderer = new ShapeRenderer();
    private final static float HITBOX_PERCENTAGE = 0.6f;
    private int points;

    public Spaceship(Vector2 position, DisplayedAsset asset, Vector2 speed, GameController gameController, float width, float height, float orientation) {
        super(position, asset, speed, width * HITBOX_PERCENTAGE, height * HITBOX_PERCENTAGE, orientation);
        this.weapon = new GreenLaserWeapon(this);
        this.gameController = gameController;
        this.points = 0;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
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

    public int getScore() {
        return points;
    }

    public void increaseScore() {
        points += 1;
    }
}
