package ch.crepe.game;

import ch.crepe.game.Screens.*;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.audio.AudioManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Spaceship3000 extends Game {
	private static final int screenWidth = 1280;
	private static final int screenHeight = 720;
	private SpriteBatch batcher;
	private AppPreferences preferences;

	Background background;

	@Override
	public void create () {
		Gdx.graphics.setWindowedMode(960,540);
		batcher = new SpriteBatch();
		preferences = new AppPreferences();

		preferences.addListener(AudioManager.getInstance());

		changeScreen(ScreenType.Loading);
	}

	public void changeScreen(ScreenType screen){
		switch (screen){
			case Loading:
				setScreen(new LoadingScreen(this));

				break;
			case MainMenu:
				System.out.println("Showing MainMenu screen !");
				setScreen(new MainMenuScreen(this));
				break;
			case Game:
				System.out.println("Showing Game screen !");
				setScreen(new GameScreen(this));
				break;
			case Preferences:
				System.out.println("Showing Preferences screen !");
				setScreen(new PreferencesScreen(this));
				break;
			case GameOver:
				System.out.println("Showing Game Over screen !");
				setScreen(new GameOverScreen(this, 10329023, 18));
				break;
		}
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

	public AppPreferences getPreferences() {
		return preferences;
	}
}
