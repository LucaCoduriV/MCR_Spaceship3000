package ch.crepe.game.assets;

public enum Laser {
    blueSimple("weapons/lasers/blue_simple.png"),
    blueFast("weapons/lasers/blue_fast.png"),
    bluePlasma("weapons/lasers/blue_plasma.png"),
    blueElectric("weapons/lasers/blue_electric.png"),
    greenSimple("weapons/lasers/green_simple.png"),
    greenFast("weapons/lasers/green_fast.png"),
    greenPlasma("weapons/lasers/green_plasma.png"),
    greenElectric("weapons/lasers/green_electric.png"),
    redSimple("weapons/lasers/red_simple.png"),
    redFast("weapons/lasers/red_fast.png"),
    redPlasma("weapons/lasers/red_plasma.png"),
    redElectric("weapons/lasers/red_electric.png");

    private final String path;
    Laser(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
