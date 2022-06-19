package ch.crepe.game.assets;

public enum Explosions implements AssetPath {
    ROUND_EXPLOSION("explosions/round_explosion/spritesheet/spritesheet.png"),
    ROUND_VORTEX("explosions/round_vortex/spritesheet/spritesheet.png"),
    VERTICAL_EXPLOSION("explosions/vertical_explosion/spritesheet/spritesheet.png"),
    VERTICAL_EXPLOSION_SMALL("explosions/vertical_explosion_small/spritesheet/spritesheet.png"),
    X_PLOSION("explosions/X_plosion/spritesheet/spritesheet.png");

    private final String path;

    Explosions(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
