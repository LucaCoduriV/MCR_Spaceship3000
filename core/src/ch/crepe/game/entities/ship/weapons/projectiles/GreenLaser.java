package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.math.Vector2;

public class GreenLaser extends Laser {
    public GreenLaser(Vector2 position, float orientation, Spaceship owner) {
        super(owner, position, orientation, AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.GREEN_ELECTRIC));
    }

    @Override
    void makeNoise() {
        AudioManager.getInstance().playSound(Sound.BLUE_LASER_SOUND);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
