package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Laser;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.assets.Star;
import ch.crepe.game.entities.LoopingAnimation;
import ch.crepe.game.entities.LoopingSprite;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.*;

public class Background {
    private static Random rnd = new Random();

    private Rectangle bounds;

    private Vector2 position;
    private LoopingSprite tile_1;
    private LoopingSprite tile_2;
    private List<LoopingAnimation> stars;

    public Background(Vector2 position, Vector2 size, Texture image, int nbStars, Rectangle bounds) {

        this.position = position;
        this.bounds = new Rectangle(
                bounds.x,
                bounds.y - bounds.height,
                bounds.width,
                2 * bounds.height
        );
        Vector2 tileSpawn = new Vector2(position.x, position.y + size.y);
        tile_1 = new LoopingSprite(image, size, tileSpawn, position, 0.01f, this.bounds);
        tile_2 = new LoopingSprite(image, size, tileSpawn, tileSpawn, 0.01f, this.bounds);
        this.stars = new LinkedList<>();
        createStars(nbStars);
    }

    private void createStars(int nbStars) {
        for (int i = 0; i < nbStars; i++) {
            float rndPositionX = rnd.nextInt((int)tile_1.getSprite().getWidth()) + position.x;
            float rndPositionY = rnd.nextInt((int)tile_1.getSprite().getHeight()) + position.y;



            float rndDistanceRatio = rnd.nextInt(100);
            float size =
                    rndDistanceRatio < 20 ? 0.1f :
                            rndDistanceRatio < 40 ? 0.2f :
                                    rndDistanceRatio < 55 ? 0.3f :
                                            rndDistanceRatio < 80 ? 0.4f :
                                                    rndDistanceRatio < 85 ? 0.5f :
                                                            rndDistanceRatio < 87 ? 0.6f :
                                                                    rndDistanceRatio < 90 ? 0.7f :
                                                                            rndDistanceRatio < 93 ? 0.8f :
                                                                                    rndDistanceRatio < 96 ? 0.9f : 1;

            Star starType =  Star.values()[rnd.nextInt(Star.values().length)];
            this.stars.add(new LoopingAnimation(
                    AssetsLoader.getInstance().getStar(starType),
                    new Vector2(14 * size, 14 * size),
                    new Vector2(rndPositionX, position.y + (int)tile_1.getSprite().getHeight()),
                    new Vector2(rndPositionX, rndPositionY),
                    size / 10,
                    new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height),
                    starType.getTileWidth(), starType.getTileHeight()));
        }

        Collections.sort(stars, new Comparator<LoopingAnimation>() {
            @Override
            public int compare(LoopingAnimation o1, LoopingAnimation o2) {
                return Float.compare(o1.getSize().x + o1.getSize().y, o2.getSize().x + o2.getSize().y);
            }
        });
    }

    public void draw(SpriteBatch batch) {
        tile_1.draw(batch);
        tile_2.draw(batch);

        for (LoopingSprite s: stars) {
            s.draw(batch);
        }
    }

    public void update() {
        tile_1.move();
        tile_2.move();

        for (LoopingSprite s : stars) {
            s.move();
        }
    }

}
