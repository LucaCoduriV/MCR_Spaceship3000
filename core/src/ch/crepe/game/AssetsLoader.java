package ch.crepe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.io.File;

public class AssetsLoader extends AssetManager {
    private static AssetsLoader instance;
    private static final String[] explosions = {
            "explosions/round_explosion/spritesheet/spritesheet.png",
            "explosions/round_vortex/spritesheet/spritesheet.png",
            "explosions/vertical_explosion/spritesheet/spritesheet.png",
            "explosions/vertical_explosion_small/spritesheet/spritesheet.png",
            "explosions/X_plosion/spritesheet/spritesheet.png"
    };

    private static final String[] starships = {
            "ships/starships_0000_Ice-Speedster-simple.png",
            "ships/starships_0000_sun-killer-simple.png",
            "ships/starships_0001_Centenial-Hawk-simple.png",
            "ships/starships_0001_Sun-killer.png",
            "ships/starships_0002_bow-fighter-simple.png",
            "ships/starships_0003_Ex-ving-simple.png",
            "ships/starships_0004_Ice-Speedster.png",
            "ships/starships_0005_Centenial-Hawk.png",
            "ships/starships_0006_Bow-fighter.png",
            "ships/starships_0007_Ex-ving.png"
    };

    private final String weaponsFolder = "weapons";
    private final String lasersFolder = weaponsFolder + File.pathSeparator + "lasers";

    private final FileHandle[] lasers;

    static AssetsLoader getInstance(){
        if(instance == null){
            instance = new AssetsLoader();
        }
        return instance;
    }
    private AssetsLoader(){

        // loading is async

        for(String asset:explosions){
            load(asset, Texture.class);
        }

        for(String asset : starships){
            load(asset, Texture.class);
        }

        lasers = Gdx.files.internal(lasersFolder).list();
        for (FileHandle fileHandle : lasers) {
            if (!fileHandle.isDirectory()) {
                String stringPath = fileHandle.path();
                load(stringPath, Texture.class);
            }
        }
    }

    public Texture getSpaceship(int index){
        return get(starships[index], Texture.class);
    }

    public Texture getExplosion(int index){
        return get(explosions[index], Texture.class);
    }

    public Texture getLaser(int index){
        return get(lasers[index].path(), Texture.class);
    }

}

