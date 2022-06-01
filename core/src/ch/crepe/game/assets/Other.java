package ch.crepe.game.assets;

public enum Other {
    skin("menu/neonskin/neon-ui.json");
    private final String path;
    Other(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
