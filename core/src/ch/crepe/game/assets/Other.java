package ch.crepe.game.assets;

public enum Other implements AssetPath {
    skin("menu/neonskin/neon-ui.json"),
    logo("logo.png");
    private final String path;
    Other(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
