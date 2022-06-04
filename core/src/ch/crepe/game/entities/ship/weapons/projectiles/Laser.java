package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.AssetsLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {

    public Laser(Vector2 position) {
        super(position, AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast), new Vector2(0, 1));
    }
}
