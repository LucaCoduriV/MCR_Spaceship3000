package ch.crepe.game.engines;

import ch.crepe.game.assets.displayers.DisplayedSprite;
import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.SpaceShipAI;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.projectiles.BlueLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.GreenLaser;
import ch.crepe.game.entities.ship.weapons.projectiles.Laser;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Engine managing the rendering of entities
 * This class is implemented as a visitor
 */
abstract public class RenderingEngine implements Visitor {
    private final SpriteBatch batch;
    private final DisplayedSprite spaceShipSprite;
    private final DisplayedSprite spaceShipAISprite;
    private final DisplayedSprite asteroidSprite;
    private final DisplayedSprite blueLaserSprite;
    private final DisplayedSprite greenLaserSprite;

    public RenderingEngine(SpriteBatch batch, Texture spaceShipTexture, Texture spaceShipAITexture, Texture asteroidTexture, Texture blueLaserTexture, Texture greenLaserTexture) {
        this.batch = batch;
        // TODO corriger les paramètres inutiles
        spaceShipSprite = new DisplayedSprite(spaceShipTexture, new Rectangle(0, 0, 5, 5), new Vector2(5 / 2f, 5 / 2f), 0);
        spaceShipAISprite = new DisplayedSprite(spaceShipAITexture, new Rectangle(0, 0, 5, 5), new Vector2(5 / 2f, 5 / 2f), 0);
        asteroidSprite = new DisplayedSprite(asteroidTexture, new Rectangle(0, 0, 5, 5), new Vector2(5 / 2f, 5 / 2f), 0);
        blueLaserSprite = new DisplayedSprite(blueLaserTexture, new Rectangle(0, 0, 5, 5), new Vector2(5 / 2f, 5 / 2f), 0);
        greenLaserSprite = new DisplayedSprite(greenLaserTexture, new Rectangle(0, 0, 5, 5), new Vector2(5 / 2f, 5 / 2f), 0);
    }


    /**
     * Render a Spaceship
     *
     * @param ship Spaceship to render
     */
    @Override
    public void visit(Spaceship ship) {
        spaceShipSprite.setCenter(ship.getCenter());
        spaceShipSprite.setRotation(ship.getOrientation());
        spaceShipSprite.draw(batch);
    }

    /**
     * Render a SpaceshipAI
     *
     * @param ship SpaceshipAI to render
     */
    @Override
    public void visit(SpaceShipAI ship) {
        spaceShipAISprite.setCenter(ship.getCenter());
        spaceShipAISprite.setRotation(ship.getOrientation());
        spaceShipAISprite.draw(batch);
    }

    /**
     * Render an Asteroid
     *
     * @param asteroid Asteroid to render
     */
    @Override
    public void visit(Asteroid asteroid) {
        asteroidSprite.setCenter(asteroid.getCenter());
        asteroidSprite.draw(batch);
    }

    /**
     * Render a blue laser
     *
     * @param laser Blue laser to render
     */
    @Override
    public void visit(BlueLaser laser) {
        blueLaserSprite.setCenter(laser.getCenter());
        blueLaserSprite.setRotation(laser.getOrientation() + 90);
        blueLaserSprite.draw(batch);
    }

    /**
     * Render a green laser
     *
     * @param laser Green laser to render
     */
    @Override
    public void visit(GreenLaser laser) {
        greenLaserSprite.setCenter(laser.getCenter());
        greenLaserSprite.setRotation(laser.getOrientation() + 90);
        greenLaserSprite.draw(batch);
    }

    /**
     * Render a laser
     *
     * @param laser Laser to render
     */
    @Override
    public void visit(Laser laser) {
        throw new RuntimeException("Not implemented");
    }
}
