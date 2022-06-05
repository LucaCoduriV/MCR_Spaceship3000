package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

abstract public class Laser extends Projectile {

    private final static float SIZE = 3;
    private final Spaceship owner;

    protected Laser(Spaceship owner, Vector2 position, float orientation, Sprite sprite) {
        super(position, sprite, new Vector2(1, 0).rotateDeg(orientation), SIZE, SIZE);
        this.owner = owner;

        getSprite().setOrigin(SIZE/2,SIZE/2);
        getSprite().rotate(orientation);
        getSprite().setSize(SIZE, SIZE);

        makeNoise();
    }

    public Spaceship getOwner() {
        return owner;
    }

    @Override
    public void accept(Visitor v) {
        v.visitLaser(this);
    }
}
