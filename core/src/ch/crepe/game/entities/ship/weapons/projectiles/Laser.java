package ch.crepe.game.entities.ship.weapons.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    static String PIC_PATH = "weapons.lasers.01.png";
    static float SPEED = 2;

    public Laser(Vector2 position, Vector2 direction) {
        super(position, new Texture(PIC_PATH), SPEED, direction);
    }

    @Override
    public void move() {

    }
}
