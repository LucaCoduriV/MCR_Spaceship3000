package ch.crepe.game;

import ch.crepe.game.entities.Star;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Background {
    private static Random rnd = new Random();
    private Sprite image;
    private List<Star> stars;

    public Background(Vector2 position, Vector2 size, Texture image, int nbStars) {
        this.image = new Sprite(image);
        this.image.setSize(size.x, size.y);
        this.image.setPosition(position.x, position.y);
        this.stars = new LinkedList<>();
        createStars(nbStars);
    }

    private void createStars(int nbStars) {
        for (int i = 0; i < nbStars; i++) {
            int rndPositionX = rnd.nextInt((int)image.getWidth()) + (int)image.getX();
            int rndPositionY = rnd.nextInt((int)image.getHeight()) + (int)image.getY();
            this.stars.add(new Star(
                    new Vector2(rndPositionX, image.getHeight() / 2),
                    new Vector2(rndPositionX, rndPositionY),
                    0.1f,
                    image.getBoundingRectangle()));
        }
    }

    public void draw(SpriteBatch batch) {
        image.draw(batch);

        for (Star s: stars) {
            s.draw(batch);
        }
    }

    public void update() {
        for (Star s : stars) {
            s.move();
        }
    }

}
