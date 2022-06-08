package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Asteroid;
import ch.crepe.game.assets.Laser;
import ch.crepe.game.assets.SpaceShip;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RealRenderer extends RenderingEngine{
    public RealRenderer(SpriteBatch batch) {
        super(batch,
                //TODO à changer
                AssetsLoader.getInstance().getSpaceship(SpaceShip.speedsterSimple),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.sunKiller),
                AssetsLoader.getInstance().getAsteroid(Asteroid.blue2),
                AssetsLoader.getInstance().getAsteroid(Asteroid.green2),
                AssetsLoader.getInstance().getLaser(Laser.bluePlasma)
                , AssetsLoader.getInstance().getLaser(Laser.greenPlasma)
        );
    }
}
