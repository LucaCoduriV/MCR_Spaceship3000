package ch.crepe.game;

import ch.crepe.game.assets.*;
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
    private List<LoopingSprite> stars;

    public Background(Vector2 position, Vector2 size, Texture image, int nbStars, Rectangle bounds) {

        this.position = position;
        this.bounds = new Rectangle(
                bounds.x,
                bounds.y - bounds.height,
                bounds.width,
                2 * bounds.height
        );
        Vector2 tileSpawn = new Vector2(position.x, position.y + size.y);
        tile_1 = new LoopingSprite(new DisplayedSprite(image, size, position), new Vector2(0, -0.01f), tileSpawn, this.bounds);
        tile_2 = new LoopingSprite(new DisplayedSprite(image, size, tileSpawn), new Vector2(0, -0.01f), tileSpawn, this.bounds);
        this.stars = new LinkedList<>();
        createStars(nbStars);
    }

    private void createStars(int nbStars) {
        for (int i = 0; i < nbStars; i++) {
            float rndPositionX = rnd.nextInt((int)bounds.width) + position.x;
            float rndPositionY = rnd.nextInt((int)bounds.height) + position.y;



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
            this.stars.add(new LoopingSprite(
                    new DisplayedAnimation(
                            AssetsLoader.getInstance().getStar(starType),
                            new Vector2(14 * size, 14 * size),
                            new Vector2(rndPositionX, rndPositionY),
                            starType.getTileWidth(),
                            starType.getTileHeight(),
                            1/40f
                            ),
                    new Vector2(0, -size / 10),
                    new Vector2(rndPositionX, bounds.height + bounds.y),
                    new Rectangle(bounds)
                    ));
        }

       /* Collections.sort(stars, new Comparator<LoopingAnimation>() {
            @Override
            public int compare(LoopingAnimation o1, LoopingAnimation o2) {
                return Float.compare(o1.getSize().x + o1.getSize().y, o2.getSize().x + o2.getSize().y);
            }
        });*/
    }

    public void draw(SpriteBatch batch) {
        tile_1.draw(batch);
        tile_2.draw(batch);

        for (LoopingSprite s: stars) {
            s.draw(batch);
        }
    }

    public void update(float delta) {
        tile_1.update(delta);
        tile_2.update(delta);

        for (LoopingSprite s : stars) {
            s.update(delta);
        }
    }

}
