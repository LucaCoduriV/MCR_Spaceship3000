package ch.crepe.game.assets;

public enum Star implements AssetPath {
    ASTEROID("stars/asteroid.png", 100, 100),
    BLACK_HOLE("stars/black_hole.png", 200, 200),
    DESERT("stars/desert.png", 100, 100),
    DISCS("stars/discs.png", 300, 300),
    EARTH("stars/earth.png", 100, 100),
    GALAXY("stars/galaxy.png", 100, 100),
    GAZ("stars/gaz.png", 100, 100),
    LAVA("stars/lava.png", 100, 100),
    ROCK("stars/rock.png", 100, 100),
    STAR("stars/star.png", 200, 200);

    private final String path;

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }

    private final int tileWidth;
    private final int tileHeight;

    Star(String path, int tileWidth, int tileHeight) {
        this.path = path;
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
    }

    public String getPath() {
        return path;
    }
}
