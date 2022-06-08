package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Cartoon rendering engine
 * This engine is used to render the game in a cartoon style
 */
public class CartoonRenderer extends RenderingEngine{
    public CartoonRenderer(SpriteBatch batch) {
        super(batch,
                AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.exVing),
                AssetsLoader.getInstance().getAsteroid(ch.crepe.game.assets.Asteroid.blue1),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.greenElectric)
        );
    }
}
