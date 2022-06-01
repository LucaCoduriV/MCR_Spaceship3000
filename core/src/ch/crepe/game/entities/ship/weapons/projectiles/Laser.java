package ch.crepe.game.entities.ship.weapons.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    static String PIC_PATH = "weapons.lasers.01.png";

    public Laser(Vector2 position) {
        super(position, new Texture(PIC_PATH), new Vector2(0, 1));
    }
}