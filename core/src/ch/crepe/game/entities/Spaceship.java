package ch.crepe.game.entities;

import ch.crepe.game.visitor.Visitable;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

import java.awt.Point;

public class Spaceship implements Visitable {
    private final Sprite sprite;
    private final Texture texture;
    private final Rectangle hitbox;
    private final PolygonSpriteBatch batch;
    private final ShapeRenderer renderer = new ShapeRenderer();
    private final float width;
    private final float height;
    private final float reduction = 0.8f;

    public Spaceship(Point pos) {
        super();
        this.texture = new Texture("ships/starships_0000_Ice-Speedster-simple.png");
        this.width = 100;
        this.height = 100;
        this.hitbox = new Rectangle(pos.x, pos.y, width * reduction, height * reduction);

        sprite = new Sprite(texture);
        batch = new PolygonSpriteBatch();
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void draw() {
        batch.begin();
        batch.draw(texture, hitbox.x - (width - hitbox.width) / 2,
                hitbox.y - (height - hitbox.height) / 2, width, height);
        batch.end();
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.BLACK);
        renderer.rect(hitbox.getX(), hitbox.getY(), hitbox.width, hitbox.height);
        renderer.end();
    }


    @Override
    public void accept(Visitor v) {
        v.visitSpaceship(this);
    }
}
