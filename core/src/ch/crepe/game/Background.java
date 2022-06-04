package ch.crepe.game;

import ch.crepe.game.assets.*;
import ch.crepe.game.assets.displayers.DisplayedAnimation;
import ch.crepe.game.assets.displayers.DisplayedSprite;
import ch.crepe.game.entities.LoopingEntity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.*;

/**
 * Represent the background of the game.
 * <p>
 *     It contains 2 Sprites of the background image that travels from the top to the bottom of the screen,
 *     returning to the top once it's out of the screen. Creating an illusion of movement.
 * </p>
 * <p>
 *     It also contains a defined number of stars generated randomly who follows the same behavior.
 * </p>
 * @author      nelson.jeanrenaud@heig-vd.ch
 */
public class Background {
    /**
     * Random number generator.
     */
    private static final Random rnd = new Random();
    /**
     * Area displayed on the screen.
     */
    private final Rectangle area;
    /**
     * Rectangle of "bounds" calculated from the displayed area.
     * Objects are moved to their respawn position when they leave this rectangle.
     */
    private final Rectangle bounds;
    /**
     * First background sprite tile.
     */
    private final LoopingEntity tile_1;
    /**
     * Second background sprite tile.
     */
    private final LoopingEntity tile_2;
    /**
     * List of all the stars.
     */
    private final List<LoopingEntity> stars;

    /**
     * Creates a background in the given area with a specified number of stars.
     * @param area Area of the background.
     * @param image Texture used for the background.
     * @param nbStars Number of stars to generate in the background.
     */
    public Background(Rectangle area, Texture image, int nbStars) {

        this.area = new Rectangle(area);
        // Calculate the bounds from the screen area. It's twice as long (y-axis) and starts "further up" (y-axis).
        this.bounds = new Rectangle(
                area.getX(),
                area.getY() - area.getHeight(),
                area.getWidth(),
                2 * area.getHeight()
        );
        // Get the position of the rectangle offset-ed by its height
        Vector2 tileSpawn = area.getPosition(new Vector2()).add(0, area.getHeight());

        tile_1 = new LoopingEntity(
                new DisplayedSprite(image, area),
                new Vector2(0, -0.01f), tileSpawn, this.bounds);

        tile_2 = new LoopingEntity(
                new DisplayedSprite(image, new Rectangle(tileSpawn.x, tileSpawn.y, area.getWidth(), area.getHeight())),
                new Vector2(0, -0.01f), tileSpawn, this.bounds);

        this.stars = new LinkedList<>();

        createStars(nbStars);
    }

    /**
     * Creates a specified number of stars randomly and adds them to the background.
     * @param nbStars Number of stars to create.
     */
    private void createStars(int nbStars) {
        for (int i = 0; i < nbStars; i++) {

            // Ratio by which the characteristics of the star are affected by it size.
            final float gameSizeRatio = 14f; // Converts the size which is in the interval ]0, 1] to the actual size.
            final float speedRatio = 1/10f;
            final float frameSpeedRatio = 1/40f;

            final float rndPositionX = rnd.nextInt((int) bounds.width) + area.getX();
            final float rndPositionY = rnd.nextInt((int) bounds.height) + area.getY();

            // TODO Trouver un meilleur moyen de gérer la distribution de taille.
            // Generate the size of the star based on a size distribution.
            final float randomPercentile = rnd.nextInt(100);
            final float sizePercentage =
                    randomPercentile < 20 ? 0.1f :
                            randomPercentile < 40 ? 0.2f :
                                    randomPercentile < 55 ? 0.3f :
                                            randomPercentile < 80 ? 0.4f :
                                                    randomPercentile < 85 ? 0.5f :
                                                            randomPercentile < 87 ? 0.6f :
                                                                    randomPercentile < 90 ? 0.7f :
                                                                            randomPercentile < 93 ? 0.8f :
                                                                                    randomPercentile < 96 ? 0.9f : 1;

            final Star starType = Star.values()[rnd.nextInt(Star.values().length)]; // Get a random type of celestial body
            this.stars.add(new LoopingEntity(
                    new DisplayedAnimation(
                            AssetsLoader.getInstance().getStar(starType),
                            new Rectangle(
                                    rndPositionX, rndPositionY,
                                    gameSizeRatio * sizePercentage, gameSizeRatio * sizePercentage
                            ),
                            starType.getTileWidth(),
                            starType.getTileHeight(),
                            frameSpeedRatio / sizePercentage
                    ),
                    new Vector2(0, -sizePercentage * speedRatio),
                    new Vector2(rndPositionX, bounds.height + bounds.y),
                    new Rectangle(bounds)
            ));
        }

        // Sorts the list so the smallest body are drawn firsts and hidden by the bigger objects
        // (since they are further from the camera view).
       Collections.sort(stars, new Comparator<LoopingEntity>() {
           @Override
           public int compare(LoopingEntity o1, LoopingEntity o2) {
               return (int)(o1.getDrawingArea().area() - o2.getDrawingArea().area());
           }
       });
    }

    /**
     * Draws the background onto the specified batch.
     * @param batch The batch.
     */
    public void draw(SpriteBatch batch) {
        tile_1.draw(batch);
        tile_2.draw(batch);

        for (LoopingEntity s : stars) {
            s.draw(batch);
        }
    }

    /**
     * Update the background.
     * @param delta Time delta since last update.
     */
    public void update(float delta) {
        tile_1.update(delta);
        tile_2.update(delta);

        for (LoopingEntity s : stars) {
            s.update(delta);
        }
    }

}
