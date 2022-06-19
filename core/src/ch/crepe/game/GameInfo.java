package ch.crepe.game;

/**
 * This class contains all the information about the game.
 */
public class GameInfo {
    private int score = 0;
    private int lives = 100;
    private int level = 1;
    private GameState state = GameState.playing;

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public enum GameState {
        playing,
        pause
    }
}
