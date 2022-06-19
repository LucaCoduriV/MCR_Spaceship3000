package ch.crepe.game.assets;

public enum Music implements AssetPath {
    DEFEAT("audios/musics/Defeated.ogg"),
    MENU("audios/musics/MenuScreen.ogg"),
    ALONE_AGAINST_ENEMY("audios/musics/Alone Against Enemy.ogg"),
    BATTLE_IN_THE_STARS("audios/musics/Battle in the Stars.ogg"),
    DEATH_MATCH("audios/musics/DeathMatch (Boss Theme).ogg"),
    EPIC_END("audios/musics/Epic End.ogg"),
    RAIN_OF_LASERS("audios/musics/Rain of Lasers.ogg"),
    TITLE_SCREEN("audios/musics/SkyFire (Title Screen).ogg"),
    SPACE_HEROES("audios/musics/Space Heroes.ogg"),
    VICTORY_TUNE("audios/musics/Victory Tune.ogg"),
    WITHOUT_FEAR("audios/musics/Without Fear.ogg");

    private final String path;

    Music(String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
