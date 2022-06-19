package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Asteroid;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Cartoon rendering engine
 * This engine is used to render the game in a cartoon style
 */
public class CartoonRenderer extends RenderingEngine {
    public CartoonRenderer(SpriteBatch batch) {
        super(batch,
                AssetsLoader.getInstance().getSpaceship(SpaceShip.ARCADE_USER),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.ARCADE_USER),
                AssetsLoader.getInstance().getAsteroid(Asteroid.ARCADE_BLUE),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.BLUE_FAST),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.GREEN_ELECTRIC)
        );
    }
}
