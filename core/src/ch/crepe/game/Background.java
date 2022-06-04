package ch.crepe.game;

import ch.crepe.game.assets.*;
import ch.crepe.game.entities.LoopingEntity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.*;

public class Background {
    private static Random rnd = new Random();

    private Rectangle bounds;
    private Rectangle area;
    private LoopingEntity tile_1;
    private LoopingEntity tile_2;
    private List<LoopingEntity> stars;

    public Background(Rectangle area, Texture image, int nbStars) {

        this.area = new Rectangle(area);
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

    private void createStars(int nbStars) {
        for (int i = 0; i < nbStars; i++) {
            float rndPositionX = rnd.nextInt((int) bounds.width) + area.getX();
            float rndPositionY = rnd.nextInt((int) bounds.height) + area.getY();


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

            Star starType = Star.values()[rnd.nextInt(Star.values().length)];
            this.stars.add(new LoopingEntity(
                    new DisplayedAnimation(
                            AssetsLoader.getInstance().getStar(starType),
                            new Rectangle(
                                    rndPositionX, rndPositionY,
                                    14 * size, 14 * size
                            ),
                            starType.getTileWidth(),
                            starType.getTileHeight(),
                            1 / 40f
                    ),
                    new Vector2(0, -size / 10),
                    new Vector2(rndPositionX, bounds.height + bounds.y),
                    new Rectangle(bounds)
            ));
        }

       Collections.sort(stars, new Comparator<LoopingEntity>() {
           @Override
           public int compare(LoopingEntity o1, LoopingEntity o2) {
               return (int)(o1.getDrawingArea().area() - o2.getDrawingArea().area());
           }
       });
    }

    public void draw(SpriteBatch batch) {
        tile_1.draw(batch);
        tile_2.draw(batch);

        for (LoopingEntity s : stars) {
            s.draw(batch);
        }
    }

    public void update(float delta) {
        tile_1.update(delta);
        tile_2.update(delta);

        for (LoopingEntity s : stars) {
            s.update(delta);
        }
    }

}
