package ch.crepe.game.assets;

public enum SpaceShip implements AssetPath {
    // Realistic
    REALISTIC_USER("ships/realistic/user-spaceship.png"),
    REALISTIC_AI("ships/realistic/ai-spaceship.png"),

    // Arcade
    ARCADE_USER("ships/arcade/user-spaceship.png"),
    ARCADE_AI("ships/arcade/ai-spaceship.png"),

    // Paint
    PAINT_USER("ships/paint/user-spaceship.png"),
    PAINT_AI("ships/paint/ai-spaceship.png");

    private final String path;

    SpaceShip(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
