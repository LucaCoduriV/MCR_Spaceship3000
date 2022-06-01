package ch.crepe.game.entities;

import ch.crepe.game.engines.Renderer.Renderer;
import ch.crepe.game.entities.ship.weapons.Weapon;
import ch.crepe.game.visitor.Visitor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Spaceship extends Entity {
    private Weapon weapon;
    private final ShapeRenderer renderer = new ShapeRenderer();

    public Spaceship(Vector2 position, Sprite sprite, Vector2 speed, float width, float height) {
        super(position, sprite, speed, width, height);
        sprite.setSize(width, height);
    }

    public void draw() {
//        Renderer.getInstance().getBatch().begin();
//        Renderer.getInstance().getBatch().draw(sprite.getTexture(), hitbox.x - (width - hitbox.width) / 2,
//                hitbox.y - (height - hitbox.height) / 2, width, height);
//        Renderer.getInstance().getBatch().end();
        renderer.begin(ShapeRenderer.ShapeType.Line);
        renderer.setColor(Color.RED);
        renderer.rect(hitbox.getX(), hitbox.getY(), hitbox.width, hitbox.height);
        renderer.end();
    }

    @Override
    public void draw(Batch batch) {
        super.draw(batch);
    }

    @Override
    public void accept(Visitor v) {
        v.visitSpaceship(this);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
