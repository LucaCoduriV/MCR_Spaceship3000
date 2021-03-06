package ch.crepe.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Cette classe permet de charger les textures au lancement du jeu
 * et fournir les textures demandées.
 * Cette classe est un singleton pour faciliter son accès.
 */
public class AssetsLoader extends AssetManager {
    private static final String LEVEL_BACKGROUND_IMG = "backgrounds/space_background_3.png";
    private static AssetsLoader instance;

    private AssetsLoader() {
    }

    /**
     * Récupérer l'instance de la classe.
     *
     * @return le singleton.
     */
    public static AssetsLoader getInstance() {
        if (instance == null) {
            instance = new AssetsLoader();
        }
        return instance;
    }

    /**
     * Lancer le chargement des textures.
     */
    public void loadAll() {
        // loading is async

        for (SpaceShip s : SpaceShip.values()) {
            load(s.getPath(), Texture.class);
        }

        for (Star s : Star.values()) {
            load(s.getPath(), Texture.class);
        }

        for (Laser l : Laser.values()) {
            load(l.getPath(), Texture.class);
        }
        load(Other.SKIN.getPath(), Skin.class);

        load(LEVEL_BACKGROUND_IMG, Texture.class);

        for (Music music : Music.values()) {
            load(music.getPath(), com.badlogic.gdx.audio.Music.class);
        }

        for (Sound sound : Sound.values()) {
            load(sound.getPath(), com.badlogic.gdx.audio.Sound.class);
        }

        load(Other.LOGO.getPath(), Texture.class);

        for (Asteroid asteroid : Asteroid.values()) {
            load(asteroid.getPath(), Texture.class);
        }
    }

    /**
     * This method is used to get the texture of the given ship.
     *
     * @param ship the ship to get the texture.
     * @return the texture of the given ship.
     */
    public Texture getSpaceship(SpaceShip ship) {
        return get(ship.getPath(), Texture.class);
    }

    /**
     * This method is used to get the texture of the given star.
     *
     * @param star the star to get the texture.
     * @return the texture of the given star.
     */
    public Texture getStar(Star star) {
        return get(star.getPath(), Texture.class);
    }

    /**
     * This method is used to get the texture of the given laser.
     *
     * @param laser the laser to get the texture.
     * @return the texture of the given laser.
     */
    public Texture getLaser(Laser laser) {
        return get(laser.getPath(), Texture.class);
    }

    /**
     * This method is used to get the texture of the background.
     *
     * @return the texture of the background.
     */
    public Texture getBackground() {
        return get(LEVEL_BACKGROUND_IMG, Texture.class);
    }

    /**
     * This method is used to get the texture of the logo.
     *
     * @return the texture of the logo.
     */
    public Texture getLogo() {
        return get(Other.LOGO.getPath(), Texture.class);
    }

    /**
     * This method is used to get the skin of the ui.
     *
     * @return the skin of the ui.
     */
    public Skin getSkin() {
        return get(Other.SKIN.getPath(), Skin.class);
    }

    /**
     * This method is used to get the music.
     *
     * @param music the music to get.
     * @return the music.
     */
    public com.badlogic.gdx.audio.Music getMusic(Music music) {
        return get(music.getPath(), com.badlogic.gdx.audio.Music.class);
    }

    /**
     * This method is used to get a sound.
     *
     * @param sound the sound to get.
     * @return the sound.
     */
    public com.badlogic.gdx.audio.Sound getSound(Sound sound) {
        return get(sound.getPath(), com.badlogic.gdx.audio.Sound.class);
    }

    /**
     * This method is used to get the texture of the given asteroid.
     *
     * @param asteroid the asteroid to get the texture.
     * @return the texture of the given asteroid.
     */
    public Texture getAsteroid(Asteroid asteroid) {
        return get(asteroid.getPath(), Texture.class);
    }
}

