package ch.crepe.game.assets;

public enum Asteroid implements AssetPath {
    // Realistic
    realisticBlue("asteroids/realistic/asteroid-blue.png"),
    realisticGreen("asteroids/realistic/asteroid-green.png"),

    // Arcade
    arcadeBlue("asteroids/arcade/asteroid-blue.png"),
    arcadeGreen("asteroids/arcade/asteroid-green.png"),

    // Paint
    paintBlue("asteroids/paint/asteroid-blue.png"),
    paintGreen("asteroids/paint/asteroid-green.png");

    private final String path;

    Asteroid(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
