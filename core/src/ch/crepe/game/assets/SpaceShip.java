package ch.crepe.game.assets;

public enum SpaceShip implements AssetPath {
    // Realistic
    realisticUser("ships/realistic/user-spaceship.png"),
    realisticAi("ships/realistic/ai-spaceship.png"),

    // Arcade
    arcadeUser("ships/arcade/user-spaceship.png"),
    arcadeAi("ships/arcade/ai-spaceship.png"),

    // Paint
    paintUser("ships/paint/user-spaceship.png"),
    paintAi("ships/paint/ai-spaceship.png");

    private final String path;

    SpaceShip(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
