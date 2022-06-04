package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    private final static float SIZE = 3;

    public Laser(Vector2 position, float orientation) {
        super(position, new Sprite(AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast)), new Vector2(1, 0).rotateDeg(orientation), SIZE, SIZE);
        getSprite().setOrigin(SIZE/2,SIZE/2);
        getSprite().rotate(orientation);
        getSprite().setSize(SIZE, SIZE);

        makeNoise();
    }

    public void makeNoise() {
        AudioManager.getInstance().playSound(Sound.laserSound);
    }

    @Override
    public void accept(Visitor v) {

    }
}
