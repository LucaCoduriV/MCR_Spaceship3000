package ch.crepe.game.assets;

public enum Sound implements AssetPath {
    blueLaserSound("audios/soundeffects/laser5.mp3"),

    greenLaserSound("audios/soundeffects/laser8.mp3");
    private final String path;


    Sound(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
