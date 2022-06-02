package ch.crepe.game.assets;

public enum Star {
    asteroid("stars/asteroid.png", 100, 100),
    black_hole("stars/black_hole.png", 200, 200),
    desert("stars/desert.png", 100, 100),
    discs("stars/discs.png", 300, 300),
    earth("stars/earth.png", 100, 100),
    galaxy("stars/galaxy.png", 100, 100),
    gaz("stars/gaz.png", 100, 100),
    lava("stars/lava.png", 100, 100),
    rock("stars/rock.png", 100, 100),
    star("stars/star.png", 200, 200);

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
