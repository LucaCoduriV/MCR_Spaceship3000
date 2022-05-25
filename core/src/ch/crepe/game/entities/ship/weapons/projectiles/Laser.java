package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    static String picPath = "weapons.lasers.01.png";

    public Laser(Vector2 position) {
        super(position, new Texture(picPath));
    }

    @Override
    public void move(Vector2 direction) {

    }
}
