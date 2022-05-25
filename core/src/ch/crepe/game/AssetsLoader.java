package ch.crepe.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import java.io.File;
import java.nio.file.FileSystem;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;


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

    private static final Map<String, String> lasers = new HashMap<String, String>(){
        {
            put("blue_simple", "weapons/lasers/blue_simple.png");
            put("blue_fast", "weapons/lasers/blue_fast.png");
            put("blue_plasma", "weapons/lasers/blue_plasma.png");
            put("blue_electric", "weapons/lasers/blue_electric.png");
            put("green_simple", "weapons/lasers/green_simple.png");
            put("green_fast", "weapons/lasers/green_fast.png");
            put("green_plasma", "weapons/lasers/green_plasma.png");
            put("green_electric", "weapons/lasers/green_electric.png");
            put("red_simple", "weapons/lasers/red_simple.png");
            put("red_fast", "weapons/lasers/red_fast.png");
            put("red_plasma", "weapons/lasers/red_plasma.png");
            put("red_electric", "weapons/lasers/red_electric.png");
        }};

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

        for(String asset : lasers.values()){
            load(asset, Texture.class);
        }
    }

    public Texture getSpaceship(int index){
        return get(starships[index], Texture.class);
    }

    public Texture getExplosion(int index){
        return get(explosions[index], Texture.class);
    }

    public Texture getLaser(String key){
        return get(lasers.get(key), Texture.class);
    }

}

