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

    private final String path;

    Asteroid(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
