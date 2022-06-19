package ch.crepe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * This class is used to store data of the game.
 * It fires a property change event when a value is changed.
 */
public class AppPreferences {
    public static final String PREF_MUSIC_VOLUME = "music.volume";
    public static final String PREF_MUSIC_ENABLED = "music.enabled";
    public static final String PREF_SOUND_ENABLED = "sound.enabled";
    public static final String PREF_SOUND_VOLUME = "sound.volume";
    private static final String PREFS_NAME = "spaceship3000";
    private static final String BEST_SCORE = "game.bestScore";
    private final PropertyChangeSupport propChangeSupport =
            new PropertyChangeSupport(this);

    /**
     * Add a listner to the property change event.
     * @param listener The listener to add
     */
    public void addListener(PropertyChangeListener listener) {
        propChangeSupport.addPropertyChangeListener(listener);
    }

    /**
     * Get the preferences.
     * @return The preferences
     */
    protected Preferences getPrefs() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    /**
     * Return if the sound effect is enabled.
     * @return True if the sound effect is enabled, false otherwise
     */
    public boolean isSoundEffectsEnabled() {
        return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
    }

    /**
     * Set if the sound effect is enabled.
     * @param soundEffectsEnabled True if the sound effect is enabled, false otherwise
     */
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        propChangeSupport.firePropertyChange(PREF_SOUND_ENABLED, getPrefs().getBoolean(PREF_SOUND_ENABLED), soundEffectsEnabled);
        getPrefs().putBoolean(PREF_SOUND_ENABLED, soundEffectsEnabled);
        getPrefs().flush();
    }

    /**
     * Return if the music is enabled.
     * @return True if the music is enabled, false otherwise
     */
    public boolean isMusicEnabled() {
        return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
    }

    /**
     * Set if the music is enabled.
     * @param musicEnabled True if the music is enabled, false otherwise
     */
    public void setMusicEnabled(boolean musicEnabled) {
        propChangeSupport.firePropertyChange(PREF_MUSIC_ENABLED, getPrefs().getBoolean(PREF_MUSIC_ENABLED), musicEnabled);
        getPrefs().putBoolean(PREF_MUSIC_ENABLED, musicEnabled);
        getPrefs().flush();
    }

    /**
     * Return the volume of the music.
     * @return The volume of the music
     */
    public float getMusicVolume() {
        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
    }

    /**
     * Set the volume of the music.
     * @param volume The volume of the music
     */
    public void setMusicVolume(float volume) {
        propChangeSupport.firePropertyChange(PREF_MUSIC_VOLUME, getPrefs().getBoolean(PREF_MUSIC_VOLUME), volume);
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    /**
     * Return the volume of the sound.
     * @return The volume of the sound
     */
    public float getSoundVolume() {
        return getPrefs().getFloat(PREF_SOUND_VOLUME, 0.5f);
    }

    /**
     * Set the volume of the sound.
     * @param volume The volume of the sound
     */
    public void setSoundVolume(float volume) {
        propChangeSupport.firePropertyChange(PREF_SOUND_VOLUME, getPrefs().getBoolean(PREF_SOUND_VOLUME), volume);
        getPrefs().putFloat(PREF_SOUND_VOLUME, volume);
        getPrefs().flush();
    }

    /**
     * Return the best score.
     * @return The best score
     */
    public int getBestScore() {
        return getPrefs().getInteger(BEST_SCORE, 0);
    }

    /**
     * Set the best score.
     * @param score The best score
     */
    public void setBestScore(int score) {
        getPrefs().putInteger(BEST_SCORE, score);
        getPrefs().flush();
    }
}
