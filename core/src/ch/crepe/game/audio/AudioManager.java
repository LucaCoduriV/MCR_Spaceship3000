package ch.crepe.game.audio;

import ch.crepe.game.AppPreferences;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.assets.Sound;
import com.badlogic.gdx.Gdx;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * This singleton class manages the audio.
 */
public class AudioManager implements PropertyChangeListener {
    private static AudioManager instance;
    private final com.badlogic.gdx.Audio am = Gdx.audio;
    private final AssetsLoader assets = AssetsLoader.getInstance();
    private com.badlogic.gdx.audio.Music music;
    private float musicVolume = 1f;
    private float soundVolume = 1f;
    private boolean musicEnabled = true;
    private boolean soundEnabled = true;

    private AudioManager() {
    }

    /**
     * Get the singleton instance of the AudioManager.
     *
     * @return The singleton instance of the AudioManager.
     */
    public static AudioManager getInstance() {
        if (instance == null)
            instance = new AudioManager();
        return instance;
    }

    /**
     * This method loads the music file.
     *
     * @param music The music file to load.
     */
    public void loadMusic(Music music) {
        stopMusic();
        this.music = assets.getMusic(music);
        this.music.setVolume(musicVolume);

    }

    /**
     * This method loads a playlist.
     *
     * @param playlist The playlist file to load.
     */
    public void loadPlaylist(Playlist playlist) {
        stopMusic();
        this.music = playlist;
        this.music.setVolume(musicVolume);
    }

    /**
     * Register a listener for when the music completes.
     *
     * @param listener The listener to register.
     */
    public void onMusicCompletion(com.badlogic.gdx.audio.Music.OnCompletionListener listener) {
        if (music != null) {
            music.setOnCompletionListener(listener);
        }
    }

    /**
     * This method stops the music
     */
    public void stopMusic() {
        if (this.music != null && musicEnabled)
            music.stop();
    }

    /**
     * Set the music to loop or not.
     *
     * @param loop True if the music should loop, false otherwise.
     */
    public void loopMusic(boolean loop) {
        if (music != null) {
            music.setLooping(loop);
        }
    }

    /**
     * This method pauses the music.
     */
    public void pauseMusic() {
        music.pause();
    }

    /**
     * This method resumes the music.
     */
    public void resumeMusic() {
        if (this.music != null && musicEnabled) {
            music.setVolume(musicVolume);
            music.play();
        }

    }

    /**
     * This method plays a sound.
     *
     * @param sound The sound to play.
     */
    public void playSound(Sound sound) {
        if (soundEnabled) {
            assets.getSound(sound).play(soundVolume);
        }
    }

    /**
     * This method is used to register to the AppPreferences.
     * It listens when the player changes the settings.
     *
     * @param propertyChangeEvent The event that is fired.
     */
    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        switch (propertyChangeEvent.getPropertyName()) {
            case AppPreferences.PREF_MUSIC_ENABLED:
                musicEnabled = (boolean) propertyChangeEvent.getNewValue();
                if (musicEnabled) {
                    resumeMusic();
                } else {
                    stopMusic();
                }
                break;
            case AppPreferences.PREF_MUSIC_VOLUME:
                float musicVolume = (float) propertyChangeEvent.getNewValue();
                System.out.println("Music volume: " + musicVolume);
                if (this.music != null)
                    music.setVolume(musicVolume);
                this.musicVolume = musicVolume;
                break;
            case AppPreferences.PREF_SOUND_ENABLED:
                soundEnabled = (boolean) propertyChangeEvent.getNewValue();
                break;
            case AppPreferences.PREF_SOUND_VOLUME:
                float soundVolume = (float) propertyChangeEvent.getNewValue();
                System.out.println("Music volume: " + soundVolume);
                this.soundVolume = soundVolume;
                break;
            default:
                break;
        }
    }

    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    public void setSoundVolume(float soundVolume) {
        this.soundVolume = soundVolume;
    }

    public void setMusicEnabled(boolean musicEnabled) {
        this.musicEnabled = musicEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }
}
