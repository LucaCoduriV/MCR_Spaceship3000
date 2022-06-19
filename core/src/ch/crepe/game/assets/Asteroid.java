package ch.crepe.game.assets;

public enum Asteroid implements AssetPath {
    // Realistic
    REALISTIC_BLUE("asteroids/realistic/asteroid-blue.png"),
    REALISTIC_GREEN("asteroids/realistic/asteroid-green.png"),

    // Arcade
    ARCADE_BLUE("asteroids/arcade/asteroid-blue.png"),
    ARCADE_GREEN("asteroids/arcade/asteroid-green.png"),

    // Paint
    PAINT_BLUE("asteroids/paint/asteroid-blue.png"),
    PAINT_GREEN("asteroids/paint/asteroid-green.png");


    /*
    blue1("asteroids/blue/1.png"),
    blue2("asteroids/blue/2.png"),
    blue3("asteroids/blue/3.png"),
    green1("asteroids/green/1.png"),
    green2("asteroids/green/2.png"),
    green3("asteroids/green/3.png"),
    grey1("asteroids/grey/1.png"),
    grey2("asteroids/grey/2.png"),
    grey3("asteroids/grey/3.png"),
    orange1("asteroids/orange/1.png"),
    orange2("asteroids/orange/2.png"),
    orange3("asteroids/orange/3.png"),
    pink1("asteroids/pink/1.png"),
    pink2("asteroids/pink/2.png"),
    pink3("asteroids/pink/3.png"),
    purple1("asteroids/purple/1.png"),
    purple2("asteroids/purple/2.png"),
    purple3("asteroids/purple/3.png"),
    red1("asteroids/red/1.png"),
    red2("asteroids/red/2.png"),
    red3("asteroids/red/3.png"),
    yellow1("asteroids/yellow/1.png"),
    yellow2("asteroids/yellow/2.png"),
    yellow3("asteroids/yellow/3.png");
     */

    private final String path;

    Asteroid(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
