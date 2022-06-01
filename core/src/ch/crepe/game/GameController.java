package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.engines.CollisionEngine;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.awt.*;
import java.util.LinkedList;

public class GameController extends ApplicationAdapter {

    private PolygonSpriteBatch batch;
    private final LinkedList<Spaceship> entites = new LinkedList<>();
    private final CollisionEngine ce = new CollisionEngine(entites);

    @Override
    public void create () {
        batch = new PolygonSpriteBatch();
        AssetsLoader a = AssetsLoader.getInstance();
        Spaceship ship = new Spaceship(new Vector2(180, 200), new Sprite(new Texture(SpaceShip.bowFighter.getPath())), new Vector2(10, 10),100, 100);
        Spaceship ship2 = new Spaceship(new Vector2(280, 200), new Sprite(new Texture(SpaceShip.centenialHawk.getPath())), new Vector2(10, 10),100, 100);
        Spaceship ship3 = new Spaceship(new Vector2(80, 200), new Sprite(new Texture(SpaceShip.exVing.getPath())), new Vector2(10, 10),100, 100);
        entites.add(ship);
        entites.add(ship2);
        entites.add(ship3);
    }

    @Override
    public void render () {
        ScreenUtils.clear(1, 0, 0, 1);

        for (Spaceship entity : entites) {
            entity.accept(ce);
            entity.draw();
        }
    }

}
