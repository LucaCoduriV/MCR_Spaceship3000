package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.GameController;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.engines.CollisionEngine;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class GreenLaser extends Laser {
    public GreenLaser(Vector2 position, float orientation, Spaceship owner) {
        super(owner, position, orientation, AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.greenElectric));
    }

    @Override
    void makeNoise() {
        AudioManager.getInstance().playSound(Sound.blueLaserSound);
    }

    @Override
    public void visit(BlueAsteroid asteroid) {
        //TODO augmenter taille
    }

    @Override
    public void visit(GreenAsteroid asteroid) {
        if(CollisionEngine.isColliding(this, asteroid)) {
            asteroid.setLife(asteroid.getLife() - getDamage());
            if(!asteroid.isAlive()) {
                getOwner().getGameController().getGameInfo().addScore(1);
            }
            kill();
        }
    }
}
