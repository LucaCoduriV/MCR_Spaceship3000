package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class Laser extends Projectile {

    private static final float SIZE = 3;
    private final Spaceship owner;

    protected Laser(Spaceship owner, Vector2 position, float orientation, Texture texture) {
        super(position, new Vector2(1, 0).rotateDeg(orientation), SIZE, SIZE);
        this.owner = owner;
        makeNoise();
    }

    public Spaceship getOwner() {
        return owner;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
