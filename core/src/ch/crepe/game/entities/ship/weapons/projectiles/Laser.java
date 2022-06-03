package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    static String PIC_PATH = "weapons.lasers.01.png";

    public Laser(Vector2 position, Vector2 speed, float width, float height) {
        super(position, new Sprite(new Texture(PIC_PATH)), speed, width, height);
    }

    @Override
    public void accept(Visitor v) {

    }
}
