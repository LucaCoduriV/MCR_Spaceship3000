package ch.crepe.game;

import ch.crepe.game.Screens.MainMenuScreen;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.MenuAssets;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Spaceship3000 extends Game {
	private static final int screenWidth = 1280;
	private static final int screenHeight = 720;
	private SpriteBatch batcher;

	@Override
	public void create () {
		AssetsLoader.getInstance().finishLoading();
		MenuAssets.load();
		Gdx.graphics.setWindowedMode(screenWidth,screenHeight);
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

	public int getScreenWidth(){
		return screenWidth;
	}

	public int getScreenHeight(){
		return screenHeight;
	}
}
