package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.GameController;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class BlueLaser extends Laser {

    public BlueLaser(Vector2 position, float orientation, Spaceship owner) {
        super(owner, position, orientation,AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast));
    }

    @Override
    public void makeNoise() {
        AudioManager.getInstance().playSound(Sound.blueLaserSound);
    }

    @Override
    public void reactToCollision(BlueAsteroid asteroid, GameController controller) {
        //TODO factoriser ?
        asteroid.setLife(asteroid.getLife() - getDamage());
        if(!asteroid.isAlive()) {
            controller.getGameInfo().addScore(1);
        }
        kill();
    }

    @Override
    public void reactToCollision(GreenAsteroid asteroid, GameController controller) { }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
