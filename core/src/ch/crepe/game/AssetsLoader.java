package ch.crepe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.io.File;
import java.util.Map.Entry;
import java.util.Map;

import static java.util.Map.entry;

public class AssetsLoader extends AssetManager {
    private static AssetsLoader instance;
    private static final Map<String, String> explosions = Map.ofEntries(
        entry("round-explosion","explosions/round_explosion/spritesheet/spritesheet.png"),
        entry("round-vortex","explosions/round_vortex/spritesheet/spritesheet.png"),
        entry("vertical-explosion","explosions/vertical_explosion/spritesheet/spritesheet.png"),
        entry("vertical-explosion-small","explosions/vertical_explosion_small/spritesheet/spritesheet.png"),
        entry("x-plosion","explosions/X_plosion/spritesheet/spritesheet.png")
    );

    private static final Map<String, String> starships = Map.ofEntries(
        entry("speedster-simple","ships/starships_0000_Ice-Speedster-simple.png"),
        entry("sun-killer-simple","ships/starships_0000_sun-killer-simple.png"),
        entry("centenial-hawk-simple","ships/starships_0001_Centenial-Hawk-simple.png"),
        entry("sun-killer","ships/starships_0001_Sun-killer.png"),
        entry("bow-fighter-simple","ships/starships_0002_bow-fighter-simple.png"),
        entry("ex-ving-simple","ships/starships_0003_Ex-ving-simple.png"),
        entry("ice-speedster","ships/starships_0004_Ice-Speedster.png"),
        entry("centenial-hawk","ships/starships_0005_Centenial-Hawk.png"),
        entry("bow-fighter","ships/starships_0006_Bow-fighter.png"),
        entry("ex-ving","ships/starships_0007_Ex-ving.png")
    );

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

        for(String asset:explosions.values()){
            load(asset, Texture.class);
        }

        for(String asset : starships.values()){
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

    public Texture getSpaceship(String name){
        return get(starships.get(name), Texture.class);
    }

    public Texture getExplosion(String name){
        return get(explosions.get(name), Texture.class);
    }

    public Texture getLaser(int index){
        return get(lasers[index].path(), Texture.class);
    }

}

