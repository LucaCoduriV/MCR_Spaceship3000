package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShips;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Spaceship3000 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x = 0;
	float y = 0;
	float speedX = 2;
	float speedY = 2;

	Background background;

	@Override
	public void create () {
		Gdx.graphics.setWindowedMode(1000,800);
		batch = new SpriteBatch();
		AssetsLoader a = AssetsLoader.getInstance();
		a.finishLoading();

		img = a.getSpaceship(SpaceShips.exVing);
		background = new Background(
				new Vector2(0,0),
				a.getBackground(),
				10
		);
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
		background.draw(batch);
		batch.end();

		background.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
