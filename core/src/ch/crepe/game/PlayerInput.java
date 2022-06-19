package ch.crepe.game;

import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

/**
 * This class reacts on the input of the player.
 */
public class PlayerInput extends InputAdapter {
    private final Spaceship entity;
    private final GameController controller;
    private static final int UP_KEY = Input.Keys.W;
    private static final int DOWN_KEY = Input.Keys.S;
    private static final int LEFT_KEY = Input.Keys.A;
    private static final int RIGHT_KEY = Input.Keys.D;
    private static final int QUIT_KEY = Input.Keys.ESCAPE;

    /**
     * Constructor from the game controller and the user spaceship.
     *
     * @param gameController The game controller.
     * @param entity The user spaceship.
     */
    public PlayerInput(GameController gameController, Spaceship entity) {
        this.entity = entity;
        this.controller = gameController;
    }

    /**
     * This method is called when the user presses a key.
     * @param keycode the keycode of the key that was pressed.
     * @return whether the input was processed
     */
    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case UP_KEY:
                entity.speed().y = entity.speed().y + 0.5f;
                break;
            case DOWN_KEY:
                entity.speed().y = entity.speed().y - 0.5f;
                break;
            case LEFT_KEY:
                entity.speed().x = entity.speed().x - 0.5f;
                break;
            case RIGHT_KEY:
                entity.speed().x = entity.speed().x + 0.5f;
                break;
            case Input.Keys.SPACE:
                entity.shoot();
                break;
            case Input.Keys.R:
                controller.toggleRenderer();
                break;
            case Input.Keys.L:
                controller.toggleCollisionEngine();
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * This method is called when the user releases a key.
     * @param keycode the keycode of the key that was released.
     * @return whether the input was processed
     */
    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case UP_KEY:
                entity.speed().y = entity.speed().y - 0.5f;
                break;
            case DOWN_KEY:
                entity.speed().y = entity.speed().y + 0.5f;
                break;
            case LEFT_KEY:
                entity.speed().x = entity.speed().x + 0.5f;
                break;
            case RIGHT_KEY:
                entity.speed().x = entity.speed().x - 0.5f;
                break;
            case QUIT_KEY:
                controller.pauseGame();
                break;
            default:
                break;
        }
        return true;
    }
}
