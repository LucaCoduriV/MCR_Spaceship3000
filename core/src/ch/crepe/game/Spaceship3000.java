package ch.crepe.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Spaceship3000 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x = 0;
	float y = 0;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("GetPersonaPhoto.jpg");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, x++, y++);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
