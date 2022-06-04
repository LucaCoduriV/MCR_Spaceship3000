package ch.crepe.game.entities;

import ch.crepe.game.GameController;
import ch.crepe.game.entities.ship.weapons.LaserWeapon;
import ch.crepe.game.entities.ship.weapons.Weapon;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapon weapon;
    private GameController gameController;
    private final ShapeRenderer renderer = new ShapeRenderer();

    public Spaceship(Vector2 position, Sprite sprite, Vector2 speed, GameController gameController, float width, float height) {
        super(position, sprite, speed, width, height);
        getSprite().setSize(10, 10);
        getSprite().setCenter(getSprite().getWidth() / 2,getSprite().getHeight() / 2);
        this.weapon = new LaserWeapon(this);
        this.gameController = gameController;
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
        v.visitEntity(this);
    }
}
