package ch.crepe.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class AssetsLoader extends AssetManager {
    private static AssetsLoader instance;

    private static final String LEVEL_BACKGROUND_IMG = "backgrounds/space_background_3.png";
    private static final String MENU_IMG = "items.png";

    public static AssetsLoader getInstance(){
        if(instance == null){
            instance = new AssetsLoader();
        }
        return instance;
    }
    private AssetsLoader(){

        // loading is async

        for(Explosions e: Explosions.values()){
            load(e.getPath(), Texture.class);
        }

        for(SpaceShip s : SpaceShip.values()){
            load(s.getPath(), Texture.class);
        }

        for(Star s : Star.values()){
            load(s.getPath(), Texture.class);
        }

        for(Laser l : Laser.values()){
            load(l.getPath(), Texture.class);
        }
        load(Other.skin.getPath(), Skin.class);

        load(LEVEL_BACKGROUND_IMG, Texture.class);

        for(Music music : Music.values()){
            load(music.getPath(), com.badlogic.gdx.audio.Music.class);
        }

        for(Sound sound : Sound.values()){
            load(sound.getPath(), com.badlogic.gdx.audio.Sound.class);
        }

        load(Other.logo.getPath(), Texture.class);

    }

    public Texture getSpaceship(SpaceShip ship){
        return get(ship.getPath(), Texture.class);
    }

    public Texture getStar(Star star){
        return get(star.getPath(), Texture.class);
    }

    public Texture getExplosion(Explosions explosion){
        return get(explosion.getPath(), Texture.class);
    }

    public Texture getLaser(Laser laser){
        return get(laser.getPath(), Texture.class);
    }

    public Texture getBackground(){
        return get(LEVEL_BACKGROUND_IMG, Texture.class);
    }
    public Texture getLogo(){
        return get(Other.logo.getPath(), Texture.class);
    }
    public Texture getMenu(){
        return get(MENU_IMG, Texture.class);
    }

    public Skin getSkin(){
        return get(Other.skin.getPath(), Skin.class);
    }
    public FileHandle getAudio(Music music){
        return getFileHandleResolver().resolve(music.getPath());
    }

    public com.badlogic.gdx.audio.Music getMusic(Music music){
        return get(music.getPath(), com.badlogic.gdx.audio.Music.class);
    }

    public com.badlogic.gdx.audio.Sound getSound(Sound sound){
        return get(sound.getPath(), com.badlogic.gdx.audio.Sound.class);
    }
}

