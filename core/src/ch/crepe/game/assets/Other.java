package ch.crepe.game.assets;

public enum Other implements AssetPath {
    SKIN("menu/neonskin/neon-ui.json"),
    LOGO("logo.png");
    private final String path;
    Other(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
