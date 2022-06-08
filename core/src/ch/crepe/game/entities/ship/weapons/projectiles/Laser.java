package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.assets.displayers.DisplayedAsset;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Sound;
import ch.crepe.game.assets.displayers.DisplayedSprite;
import ch.crepe.game.audio.AudioManager;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Texture;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class Laser extends Projectile {

    private final static float SIZE = 3;


    protected Laser(Spaceship owner, Vector2 position, float orientation, Texture texture) {
        super(owner, position, new Vector2(1, 0).rotateDeg(orientation), SIZE, SIZE);
        makeNoise();
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
