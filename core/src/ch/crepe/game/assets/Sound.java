package ch.crepe.game.assets;

public enum Sound implements AssetPath {
    BLUE_LASER_SOUND("audios/soundeffects/laser5.mp3"),

    GREEN_LASER_SOUND("audios/soundeffects/laser8.mp3");
    private final String path;


    Sound(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
