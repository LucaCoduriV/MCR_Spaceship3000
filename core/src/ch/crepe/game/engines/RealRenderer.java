package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Asteroid;
import ch.crepe.game.assets.Laser;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Real rendering engine
 * This engine is used to render the game in a realistic style
 */
public class RealRenderer extends RenderingEngine {
    public RealRenderer(SpriteBatch batch) {
        super(batch,
                AssetsLoader.getInstance().getSpaceship(SpaceShip.realisticUser),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.realisticAi),
                AssetsLoader.getInstance().getAsteroid(Asteroid.realisticBlue),
                AssetsLoader.getInstance().getLaser(Laser.bluePlasma),
                AssetsLoader.getInstance().getLaser(Laser.greenPlasma)
        );
    }
}
