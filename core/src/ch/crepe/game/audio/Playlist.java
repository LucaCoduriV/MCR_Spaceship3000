package ch.crepe.game.audio;


import ch.crepe.game.assets.AssetsLoader;
import com.badlogic.gdx.audio.Music;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A playlist of music.
 */
public class Playlist implements Music {
    private final List<Music> musics;
    private int index = 0;

    /**
     * It creates a new playlist.
     *
     * @param musics the musics to add to the playlist.
     */
    public Playlist(ch.crepe.game.assets.Music[] musics) {
        this.musics = new ArrayList<>();
        for (ch.crepe.game.assets.Music music : musics) {
            this.musics.add(AssetsLoader.getInstance().getMusic(music));
        }
    }

    /**
     * It shuffles the playlist.
     */
    public void shuffle() {
        Collections.shuffle(this.musics);
    }

    /**
     * It plays the next music in the playlist.
     */
    @Override
    public void play() {
        getCurrentSong().play();
        getCurrentSong().setOnCompletionListener(new OnCompletionListener() {
            @Override
            public void onCompletion(Music music) {
                getCurrentSong().setOnCompletionListener(null);
                nextSong();
                play();
            }
        });
    }

    private Music getCurrentSong() {
        return musics.get(index);
    }

    /**
     * It plays the next music in the playlist.
     *
     * @return the next music in the playlist.
     */
    private Music nextSong() {
        if (index < musics.size()) {
            index++;
        } else {
            index = 0;
        }
        return musics.get(index);
    }

    /**
     * It pauses the current music.
     */
    @Override
    public void pause() {
        musics.get(index).pause();
    }

    /**
     * It stops the current music.
     */
    @Override
    public void stop() {
        musics.get(index).stop();
    }

    @Override
    public boolean isPlaying() {
        return musics.get(index).isPlaying();
    }

    @Override
    public boolean isLooping() {
        return false;
    }

    @Override
    public void setLooping(boolean isLooping) {
        throw new NotImplementedException();
    }

    @Override
    public float getVolume() {
        return musics.get(index).getVolume();
    }

    @Override
    public void setVolume(float volume) {
        for (Music music : musics) {
            music.setVolume(volume);
        }
    }

    @Override
    public void setPan(float pan, float volume) {
        throw new NotImplementedException();
    }

    @Override
    public float getPosition() {
        return getCurrentSong().getPosition();
    }

    @Override
    public void setPosition(float position) {
        getCurrentSong().setPosition(position);
    }

    @Override
    public void dispose() {
        for (Music music : musics) {
            music.dispose();
        }
    }

    @Override
    public void setOnCompletionListener(OnCompletionListener listener) {
        throw new NotImplementedException();
    }
}
