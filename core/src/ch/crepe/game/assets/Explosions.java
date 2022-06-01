package ch.crepe.game.assets;

public enum Explosions {
    roundExplosion("explosions/round_explosion/spritesheet/spritesheet.png"),
    roundVortex("explosions/round_vortex/spritesheet/spritesheet.png"),
    verticalExplosion("explosions/vertical_explosion/spritesheet/spritesheet.png"),
    verticalExplosionSmall("explosions/vertical_explosion_small/spritesheet/spritesheet.png"),
    xPlosion("explosions/X_plosion/spritesheet/spritesheet.png");

    private final String path;

    Explosions(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
