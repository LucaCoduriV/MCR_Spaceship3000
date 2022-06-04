package ch.crepe.game.assets;

public enum Sound {
    laserSound("audios/soundeffects/laser5.mp3");
    private final String path;


    Sound(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
