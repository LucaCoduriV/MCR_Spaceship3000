package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.audio.AudioManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    private final float size = 3;

    public Laser(Vector2 position, float orientation) {
        super(position, AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast), new Vector2(0, 1));
        getSprite().setOrigin(size/2,size/2);
        getSprite().rotate(orientation);
        getSprite().setSize(size, size);

        makeNoise();
    }

    public void makeNoise() {
        AudioManager.getInstance().playSound(Sound.laserSound);
    }
}
