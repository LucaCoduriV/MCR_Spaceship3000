package ch.crepe.game.assets;

public enum Laser implements AssetPath {
    blueFast("weapons/lasers/blue_fast.png"),
    bluePlasma("weapons/lasers/blue_plasma.png"),
    greenPlasma("weapons/lasers/green_plasma.png"),
    greenElectric("weapons/lasers/green_electric.png");

    private final String path;
    Laser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
