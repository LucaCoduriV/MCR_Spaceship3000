package ch.crepe.game.assets;

public enum Laser implements AssetPath {
    BLUE_FAST("weapons/lasers/blue_fast.png"),
    BLUE_PLASMA("weapons/lasers/blue_plasma.png"),
    GREEN_PLASMA("weapons/lasers/green_plasma.png"),
    GREEN_ELECTRIC("weapons/lasers/green_electric.png");

    private final String path;
    Laser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
