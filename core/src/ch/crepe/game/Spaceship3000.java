package ch.crepe.game;

import ch.crepe.game.entities.Asteroid;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import ch.crepe.game.entities.ship.weapons.LaserWeapon;
import ch.crepe.game.entities.ship.weapons.Weapen;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.LinkedList;
import java.util.List;

public class Spaceship3000 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x = 0;
	float y = 0;
	float speedX = 2;
	float speedY = 2;

	List<Entity> entities = new LinkedList<>();

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("GetPersonaPhoto.jpg");

		entities.add(new Spaceship(new Vector2(0, 0), img, 2));
		entities.add(new Asteroid(new Vector2(0, 0), new Texture(new Pixmap(10, 10, null))));
		AssetsLoader a = AssetsLoader.getInstance();
		return;
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		if(x > Gdx.graphics.getWidth() || x < 0) {
			speedX = -speedX;
		}
		if(y > Gdx.graphics.getHeight() || y < 0) {
			speedY = -speedY;
		}

		x += speedX;
		y += speedY;

		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
