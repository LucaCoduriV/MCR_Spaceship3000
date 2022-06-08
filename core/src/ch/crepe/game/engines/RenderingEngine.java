package ch.crepe.game.engines;

import ch.crepe.game.assets.displayers.DisplayedSprite;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.asteroids.BlueAsteroid;
import ch.crepe.game.entities.asteroids.GreenAsteroid;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

abstract public class RenderingEngine implements Visitor {
    private final SpriteBatch batch;
    private final DisplayedSprite spaceShipSprite;
    private final DisplayedSprite spaceShipAISprite;
    private final DisplayedSprite blueAsteroidSprite;
    private final DisplayedSprite greenAsteroidSprite;
    private final DisplayedSprite blueLaserSprite;
    private final DisplayedSprite greenLaserSprite;

    public RenderingEngine(SpriteBatch batch, Texture spaceShipTexture, Texture spaceShipAITexture, Texture blueAsteroidTexture, Texture greenAsteroidTexture, Texture blueLaserTexture, Texture greenLaserTexture) {



        this.batch = batch;
        // TODO corriger les paramètres inutiles
        spaceShipSprite = new DisplayedSprite(spaceShipTexture,new Rectangle(0, 0, 5, 5),new Vector2(5 / 2f, 5 / 2f),0);
        spaceShipAISprite = new DisplayedSprite(spaceShipAITexture,new Rectangle(0, 0, 5, 5),new Vector2(5 / 2f, 5 / 2f),0);
        blueAsteroidSprite = new DisplayedSprite(blueAsteroidTexture,new Rectangle(0, 0, 5, 5),new Vector2(5 / 2f, 5 / 2f),0);
        greenAsteroidSprite = new DisplayedSprite(greenAsteroidTexture,new Rectangle(0, 0, 5, 5),new Vector2(5 / 2f, 5 / 2f),0);
        blueLaserSprite = new DisplayedSprite(blueLaserTexture,new Rectangle(0, 0, 5, 5),new Vector2(5 / 2f, 5 / 2f),0);
        greenLaserSprite = new DisplayedSprite(greenLaserTexture,new Rectangle(0, 0, 5, 5),new Vector2(5 / 2f, 5 / 2f),0);
    }


    @Override
    public void visit(Spaceship ship) {
        spaceShipSprite.setCenter(ship.getCenter());
        spaceShipSprite.setRotation(ship.getOrientation());
        spaceShipSprite.draw(batch);
    }

    @Override
    public void visit(SpaceShipAI ship) {
        spaceShipAISprite.setCenter(ship.getCenter());
        spaceShipAISprite.setRotation(ship.getOrientation());
        spaceShipAISprite.draw(batch);
    }

    @Override
    public void visit(BlueAsteroid asteroid) {
        blueAsteroidSprite.setCenter(asteroid.getCenter());
        blueAsteroidSprite.draw(batch);
    }

    @Override
    public void visit(GreenAsteroid asteroid) {
        greenAsteroidSprite.setCenter(asteroid.getCenter());
        greenAsteroidSprite.draw(batch);
    }

    @Override
    public void visit(GreenLaser greenLaser) {

    }

    @Override
    public void visit(BlueLaser blueLaser) {

    }
}
