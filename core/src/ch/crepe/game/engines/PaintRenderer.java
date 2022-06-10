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
                AssetsLoader.getInstance().getSpaceship(SpaceShip.paintUser),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.paintAi),
                AssetsLoader.getInstance().getAsteroid(Asteroid.paintBlue),
                AssetsLoader.getInstance().getLaser(Laser.bluePlasma),
                AssetsLoader.getInstance().getLaser(Laser.greenPlasma)
        );
    }
}
