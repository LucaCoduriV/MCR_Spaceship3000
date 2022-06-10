package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ch.crepe.game.assets.Asteroid;

/**
 * Cartoon rendering engine
 * This engine is used to render the game in a cartoon style
 */
public class CartoonRenderer extends RenderingEngine{
    public CartoonRenderer(SpriteBatch batch) {
        super(batch,
                AssetsLoader.getInstance().getSpaceship(SpaceShip.arcadeUser),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.arcadeUser),
                AssetsLoader.getInstance().getAsteroid(Asteroid.arcadeBlue),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.greenElectric)
        );
    }
}
