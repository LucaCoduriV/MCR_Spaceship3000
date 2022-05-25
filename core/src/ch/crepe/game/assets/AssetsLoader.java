package ch.crepe.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class AssetsLoader extends AssetManager {
    private static AssetsLoader instance;

    private static final String LEVEL_BACKGROUND_IMG = "backgrounds/space_background.png";

    private final String weaponsFolder = "weapons";
    private final String lasersFolder = weaponsFolder + File.pathSeparator + "lasers";

    private final FileHandle[] lasers;

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

        for(SpaceShips s : SpaceShips.values()){
            load(s.getPath(), Texture.class);
        }

        lasers = Gdx.files.internal(lasersFolder).list();
        for (FileHandle fileHandle : lasers) {
            if (!fileHandle.isDirectory()) {
                String stringPath = fileHandle.path();
                load(stringPath, Texture.class);
            }
        }
    }

    public Texture getSpaceship(SpaceShips ship){
        return get(ship.getPath(), Texture.class);
    }

    public Texture getExplosion(Explosions explosion){
        return get(explosion.getPath(), Texture.class);
    }

    public Texture getLaser(int index){
        return get(lasers[index].path(), Texture.class);
    }

}

