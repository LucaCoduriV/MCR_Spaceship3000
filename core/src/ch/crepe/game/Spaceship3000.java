package ch.crepe.game;

import Screens.MainMenuScreen;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.MenuAssets;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Spaceship3000 extends Game {
	private SpriteBatch batcher;

	@Override
	public void create () {
		AssetsLoader.getInstance().finishLoading();
		MenuAssets.load();
		Gdx.graphics.setWindowedMode(1280,720);
		batcher = new SpriteBatch();
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batcher.dispose();
	}

	public SpriteBatch getBatch() {
		return batcher;
	}
}
