package ch.crepe.game;

import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.Music;
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

    public void stopMusic(){
        music.stop();
    }

    public void pauseMusic(){
        music.pause();
    }

    public void resumeMusic(){
        music.setVolume(musicVolume);
        music.play();
    }

    public void playSound(Music music){
        am.newSound(assets.getAudio(music)).play();
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        switch (propertyChangeEvent.getPropertyName()){
            case AppPreferences.PREF_MUSIC_ENABLED:
                if((boolean)propertyChangeEvent.getNewValue()){
                    stopMusic();
                }else{
                    resumeMusic();
                }
                break;
            case AppPreferences.PREF_MUSIC_VOLUME:
                float volume = (float)propertyChangeEvent.getNewValue();
                music.setVolume(volume);
                this.musicVolume = volume;
                break;
            case AppPreferences.PREF_SOUND_ENABLED:
                if((boolean)propertyChangeEvent.getNewValue()){

                }else{

                }
                break;
            case AppPreferences.PREF_SOUND_VOL:
                this.soundVolume = (float)propertyChangeEvent.getNewValue();
                break;
            default:
                break;
        }
    }
}
