package ch.crepe.game;

import ch.crepe.game.Screens.*;
import ch.crepe.game.audio.AudioManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Spaceship3000 extends Game {
    private static final int screenWidth = 960;
    private static final int screenHeight = 540;
    private SpriteBatch batcher;
    private AppPreferences preferences;

    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(screenWidth, screenHeight);
        batcher = new SpriteBatch();
        preferences = new AppPreferences();

        preferences.addListener(AudioManager.getInstance());
        AudioManager.getInstance().setMusicVolume(preferences.getMusicVolume());
        AudioManager.getInstance().setSoundVolume(preferences.getSoundVolume());
        AudioManager.getInstance().setMusicEnabled(preferences.isMusicEnabled());
        AudioManager.getInstance().setSoundEnabled(preferences.isSoundEffectsEnabled());

        changeScreen(ScreenType.Loading);
    }

    /**
     * Changes the game screen
     *
     * @param screen The screen to show
     * @param args   Data to pass to a screen
     */
    public void changeScreen(ScreenType screen, Object... args) {
        switch (screen) {
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
                setScreen(new GameOverScreen(this, preferences.getBestScore(), (int) args[0]));
                break;
        }
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batcher.dispose();
    }

    public SpriteBatch getBatch() {
        return batcher;
    }

    public AppPreferences getPreferences() {
        return preferences;
    }
}
