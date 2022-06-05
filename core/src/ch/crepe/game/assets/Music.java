package ch.crepe.game.assets;

public enum Music implements AssetPath {
    defeat("audios/musics/Defeated.ogg"),
    menu("audios/musics/MenuScreen.ogg"),
    aloneAgainstEnemy("audios/musics/Alone Against Enemy.ogg"),
    battleInTheStars("audios/musics/Battle in the Stars.ogg"),
    deathMatch("audios/musics/DeathMatch (Boss Theme).ogg"),
    epicEnd("audios/musics/Epic End.ogg"),
    rainOfLasers("audios/musics/Rain of Lasers.ogg"),
    titleScreen("audios/musics/SkyFire (Title Screen).ogg"),
    spaceHeroes("audios/musics/Space Heroes.ogg"),
    victoryTune("audios/musics/Victory Tune.ogg"),
    withoutFear("audios/musics/Without Fear.ogg");

    private final String path;

    Music(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
