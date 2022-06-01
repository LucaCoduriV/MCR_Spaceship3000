package ch.crepe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class AppPreferences {
    static final String PREF_MUSIC_VOLUME = "volume";
    static final String PREF_MUSIC_ENABLED = "music.enabled";
    static final String PREF_SOUND_ENABLED = "sound.enabled";
    static final String PREF_SOUND_VOL = "sound";
    private static final String PREFS_NAME = "spaceship3000";
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
        return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
    }

    public void setSoundVolume(float volume) {
        propChangeSupport.firePropertyChange(PREF_SOUND_VOL, getPrefs().getBoolean(PREF_SOUND_VOL), volume);
        getPrefs().putFloat(PREF_SOUND_VOL, volume);
        getPrefs().flush();
    }
}
