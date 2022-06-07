package ch.crepe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AppPreferences {
    public static final String PREF_MUSIC_VOLUME = "music.volume";
    public static final String PREF_MUSIC_ENABLED = "music.enabled";
    public static final String PREF_SOUND_ENABLED = "sound.enabled";
    public static final String PREF_SOUND_VOLUME = "sound.volume";
    private static final String PREFS_NAME = "spaceship3000";
    private static final String BEST_SCORE = "game.bestScore";
    private final PropertyChangeSupport propChangeSupport =
            new PropertyChangeSupport(this);

    public void addListener(PropertyChangeListener listener) {
        propChangeSupport.addPropertyChangeListener(listener);
    }


    protected Preferences getPrefs() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public boolean isSoundEffectsEnabled() {
        return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        propChangeSupport.firePropertyChange(PREF_SOUND_ENABLED, getPrefs().getBoolean(PREF_SOUND_ENABLED), soundEffectsEnabled);
        getPrefs().putBoolean(PREF_SOUND_ENABLED, soundEffectsEnabled);
        getPrefs().flush();
    }

    public boolean isMusicEnabled() {
        return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
    }

    public void setMusicEnabled(boolean musicEnabled) {
        propChangeSupport.firePropertyChange(PREF_MUSIC_ENABLED, getPrefs().getBoolean(PREF_MUSIC_ENABLED), musicEnabled);
        getPrefs().putBoolean(PREF_MUSIC_ENABLED, musicEnabled);
        getPrefs().flush();
    }

    public float getMusicVolume() {
        return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
    }

    public void setMusicVolume(float volume) {
        propChangeSupport.firePropertyChange(PREF_MUSIC_VOLUME, getPrefs().getBoolean(PREF_MUSIC_VOLUME), volume);
        getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
        getPrefs().flush();
    }

    public float getSoundVolume() {
        return getPrefs().getFloat(PREF_SOUND_VOLUME, 0.5f);
    }

    public void setSoundVolume(float volume) {
        propChangeSupport.firePropertyChange(PREF_SOUND_VOLUME, getPrefs().getBoolean(PREF_SOUND_VOLUME), volume);
        getPrefs().putFloat(PREF_SOUND_VOLUME, volume);
        getPrefs().flush();
    }

    public void setBestScore(int score) {
        getPrefs().putInteger("BEST_SCORE", score);
        getPrefs().flush();
    }

    public int getBestScore(){
        return getPrefs().getInteger("BEST_SCORE", 0);
    }
}
