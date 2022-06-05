package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.AssetsLoader;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

abstract public class Laser extends Projectile {
    private final static float SIZE = 3;

    protected Laser(Vector2 position, float orientation, Sprite sprite) {
        super(position, sprite, new Vector2(1, 0).rotateDeg(orientation), SIZE, SIZE);
        getSprite().setOrigin(SIZE/2,SIZE/2);
        getSprite().rotate(orientation);
        getSprite().setSize(SIZE, SIZE);

        makeNoise();
    }
}
