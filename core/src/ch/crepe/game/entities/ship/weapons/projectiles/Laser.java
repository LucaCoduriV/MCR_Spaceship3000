package ch.crepe.game.entities.ship.weapons.projectiles;


import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.assets.displayers.DisplayedSprite;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Laser extends Projectile {
    private final static float SIZE = 3;

    public Laser(Vector2 position, float orientation) {
        super(position, new DisplayedSprite(
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast),
                new Rectangle(position.x, position.y, SIZE, SIZE),
                new Vector2(SIZE / 2, SIZE / 2),
                orientation
                ), new Vector2(0, 1), SIZE, SIZE);
        makeNoise();
    }

    public void makeNoise() {
        AudioManager.getInstance().playSound(Sound.laserSound);
    }

    @Override
    public void accept(Visitor v) {

    }
}
