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
    private Vector2 position;
    private Texture image;
    private List<Star> stars;

    public Background(Vector2 position, Texture image, int nbStars) {
        this.position = position;
        this.image = image;
        this.stars = new LinkedList<>();
        createStars(nbStars);
    }

    private void createStars(int nbStars) {
        for (int i = 0; i < nbStars; i++) {
            this.stars.add(new Star(new Vector2(rnd.nextInt(image.getWidth()), image.getHeight()).add(position),
                    new Vector2(0, -10),
                    new Rectangle(0, 0, image.getWidth() + 20, 10)));
        }
    }

    public void draw(SpriteBatch batch) {
        //batch.begin();
        batch.draw(image, position.x, position.y);

        for (Star s: stars) {
            batch.draw(s.getTexture(), s.position().x, s.position().y);
        }
        //batch.end();
    }

    public void update() {
        for (Star s : stars) {
            s.move();
        }
    }

}
