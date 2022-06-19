package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Asteroid;
import ch.crepe.game.assets.Laser;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Paint rendering engine
 * This engine is used to render the game as if it was a user messing with
 * MS paint
 */
public class PaintRenderer extends RenderingEngine {
    public PaintRenderer(SpriteBatch batch) {
        super(batch,
                AssetsLoader.getInstance().getSpaceship(SpaceShip.PAINT_USER),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.PAINT_AI),
                AssetsLoader.getInstance().getAsteroid(Asteroid.PAINT_BLUE),
                AssetsLoader.getInstance().getLaser(Laser.BLUE_PLASMA),
                AssetsLoader.getInstance().getLaser(Laser.GREEN_PLASMA)
        );
    }
}
