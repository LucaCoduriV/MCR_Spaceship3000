package ch.crepe.game.audio;


import ch.crepe.game.assets.AssetsLoader;
import com.badlogic.gdx.audio.Music;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Playlist implements Music {
    private final List<Music> musics;
    private int index = 0;

    public Playlist(ch.crepe.game.assets.Music[] musics){
        this.musics = new ArrayList<>();
        for (ch.crepe.game.assets.Music music: musics) {
            this.musics.add(AssetsLoader.getInstance().getMusic(music));
        }
    }

    public void shuffle(){
        Collections.shuffle(this.musics);
    }

    @Override
    public void play() {
        getCurrentSong().play();
        getCurrentSong().setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                getCurrentSong().setOnCompletionListener(null);
                setNextSong();
                play();
            }
        });
    }

    private Music getCurrentSong(){
        return musics.get(index);
    }

    private Music setNextSong(){
        if(index < musics.size()){
            index++;
        }else{
            index = 0;
        }
        return musics.get(index);
    }

    @Override
    public void pause() {
        musics.get(index).pause();
    }

    @Override
    public void stop() {
        musics.get(index).stop();
    }

    @Override
    public boolean isPlaying() {
        return musics.get(index).isPlaying();
    }

    @Override
    public void setLooping(boolean isLooping) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setVolume(float volume) {
        for(Music music : musics){
            music.setVolume(volume);
        }
    }

    @Override
    public float getVolume() {
        return musics.get(index).getVolume();
    }

    @Override
    public void setPan(float pan, float volume) {
        throw new NotImplementedException();
    }

    @Override
    public void setPosition(float position) {
        throw new NotImplementedException();
    }

    @Override
    public float getPosition() {
        return 0;
    }

    @Override
    public void dispose() {
        throw new NotImplementedException();
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        throw new NotImplementedException();
    }
}
