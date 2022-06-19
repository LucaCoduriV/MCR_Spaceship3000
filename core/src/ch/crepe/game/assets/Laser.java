package ch.crepe.game.assets;

public enum Laser implements AssetPath {
    BLUE_SIMPLE("weapons/lasers/blue_simple.png"),
    BLUE_FAST("weapons/lasers/blue_fast.png"),
    BLUE_PLASMA("weapons/lasers/blue_plasma.png"),
    BLUE_ELECTRIC("weapons/lasers/blue_electric.png"),
    GREEN_SIMPLE("weapons/lasers/green_simple.png"),
    GREEN_FAST("weapons/lasers/green_fast.png"),
    GREEN_PLASMA("weapons/lasers/green_plasma.png"),
    GREEN_ELECTRIC("weapons/lasers/green_electric.png"),
    RED_SIMPLE("weapons/lasers/red_simple.png"),
    RED_FAST("weapons/lasers/red_fast.png"),
    RED_PLASMA("weapons/lasers/red_plasma.png"),
    RED_ELECTRIC("weapons/lasers/red_electric.png");

    private final String path;
    Laser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
