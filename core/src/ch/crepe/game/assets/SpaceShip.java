package ch.crepe.game.assets;

public enum SpaceShip {
    speedsterSimple("ships/starships_0000_Ice-Speedster-simple.png"),
    sunKillerSimple("ships/starships_0000_sun-killer-simple.png"),
    centenialHawkSimple("ships/starships_0001_Centenial-Hawk-simple.png"),
    sunKiller("ships/starships_0001_Sun-killer.png"),
    bowFighterSimple("ships/starships_0002_bow-fighter-simple.png"),
    exVingSimple("ships/starships_0003_Ex-ving-simple.png"),
    iceSpeedster("ships/starships_0004_Ice-Speedster.png"),
    centenialHawk("ships/starships_0005_Centenial-Hawk.png"),
    bowFighter("ships/starships_0006_Bow-fighter.png"),
    exVing("ships/starships_0007_Ex-ving.png");

    private final String path;

    SpaceShip(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
