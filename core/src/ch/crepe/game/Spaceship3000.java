package ch.crepe.game;

import ch.crepe.game.screens.*;
import ch.crepe.game.audio.AudioManager;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * This class represents an instance of the game.
 */
public class Spaceship3000 extends Game {
    private static final int SCREEN_WIDTH = 960;
    private static final int SCREEN_HEIGHT = 540;
    private SpriteBatch batcher;
    private AppPreferences preferences;

    /**
     * Called when the game is first created.
     */
    @Override
    public void create() {
        Gdx.graphics.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
        batcher = new SpriteBatch();
        preferences = new AppPreferences();

        preferences.addListener(AudioManager.getInstance());
        AudioManager.getInstance().setMusicVolume(preferences.getMusicVolume());
        AudioManager.getInstance().setSoundVolume(preferences.getSoundVolume());
        AudioManager.getInstance().setMusicEnabled(preferences.isMusicEnabled());
        AudioManager.getInstance().setSoundEnabled(preferences.isSoundEffectsEnabled());

        changeScreen(ScreenType.LOADING);
    }

    /**
     * Changes the game screen
     *
     * @param screen The screen to show
     * @param args   Data to pass to a screen
     */
    public void changeScreen(ScreenType screen, Object... args) {
        switch (screen) {
            case LOADING:
                setScreen(new LoadingScreen(this));

                break;
            case MAIN_MENU:
                setScreen(new MainMenuScreen(this));
                break;
            case GAME:
                setScreen(new GameScreen(this));
                break;
            case PREFERENCES:
                setScreen(new PreferencesScreen(this));
                break;
            case GAME_OVER:
                setScreen(new GameOverScreen(this, preferences.getBestScore(), (int) args[0]));
                break;
        }
    }

    /**
     * Called when the game is destroyed.
     */
    @Override
    public void dispose() {
        batcher.dispose();
    }

    /**
     * Returns the sprite batch used to draw the game.
     *
     * @return The sprite batch used to draw the game.
     */
    public SpriteBatch getBatch() {
        return batcher;
    }

    /**
     * Returns the preferences of the game.
     *
     * @return The preferences of the game.
     */
    public AppPreferences getPreferences() {
        return preferences;
    }
}
