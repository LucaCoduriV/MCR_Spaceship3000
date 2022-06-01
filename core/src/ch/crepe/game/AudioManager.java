package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
import ch.crepe.game.assets.Sound;
import com.badlogic.gdx.Gdx;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AudioManager implements PropertyChangeListener {
    private final com.badlogic.gdx.Audio am = Gdx.audio;
    private final AssetsLoader assets = AssetsLoader.getInstance();
    private com.badlogic.gdx.audio.Music music;
    private float musicVolume = 1f;
    private float soundVolume = 1f;
    private boolean musicEnabled = true;
    private boolean soundEnabled = true;

    public void loadMusic(Music music){
        if(this.music != null) this.music.dispose();
        this.music = am.newMusic(assets.getAudio(music));
        this.music.setVolume(musicVolume);
    }

    public void onMusicCompletion(com.badlogic.gdx.audio.Music.OnCompletionListener listener){
        if(music != null){
            music.setOnCompletionListener(listener);
        }
    }

    public void stopMusic(){
        if(this.music != null)
            music.stop();
    }

    public void loopMusic(boolean loop){
        if(music != null){
            music.setLooping(loop);
        }
    }

    public void pauseMusic(){
        music.pause();
    }

    public void resumeMusic(){
        if(this.music != null){
            music.setVolume(musicVolume);
            music.play();
        }

    }

    public void playSound(Sound sound){
        if(soundEnabled) {
            assets.getSound(sound).play(soundVolume);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        switch (propertyChangeEvent.getPropertyName()){
            case AppPreferences.PREF_MUSIC_ENABLED:
                musicEnabled = (boolean)propertyChangeEvent.getNewValue();
                if(musicEnabled){
                    stopMusic();
                }else{
                    resumeMusic();
                }
                break;
            case AppPreferences.PREF_MUSIC_VOLUME:
                float musicVolume = (float)propertyChangeEvent.getNewValue();
                System.out.println("Music volume: " + musicVolume);
                if(this.music != null)
                    music.setVolume(musicVolume);
                this.musicVolume = musicVolume;
                break;
            case AppPreferences.PREF_SOUND_ENABLED:
                soundEnabled = (boolean)propertyChangeEvent.getNewValue();
                break;
            case AppPreferences.PREF_SOUND_VOLUME:
                float soundVolume = (float)propertyChangeEvent.getNewValue();
                System.out.println("Music volume: " + soundVolume);
                this.soundVolume = soundVolume;
                break;
            default:
                break;
        }
    }
}
