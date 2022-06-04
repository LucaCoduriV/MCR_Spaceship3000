package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GreenLaser extends Laser {
    public GreenLaser(Vector2 position, float orientation) {
        super(position, orientation, new Sprite(AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.greenElectric)));
    }

    @Override
    void makeNoise() {
        AudioManager.getInstance().playSound(Sound.blueLaserSound);
    }

    @Override
    public void accept(Visitor v) {

    }
}
