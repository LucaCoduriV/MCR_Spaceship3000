package ch.crepe.game.engines;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.assets.displayers.DisplayedSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class CartoonRenderer extends RenderingEngine{
    public CartoonRenderer(SpriteBatch batch) {
        super(batch,
                AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter),
                AssetsLoader.getInstance().getSpaceship(SpaceShip.exVing),
                AssetsLoader.getInstance().getAsteroid(ch.crepe.game.assets.Asteroid.blue1),
                AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.blueFast)
                , AssetsLoader.getInstance().getLaser(ch.crepe.game.assets.Laser.greenElectric)
        );
    }
}
