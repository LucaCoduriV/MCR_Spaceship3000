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
    private final int upKey = Input.Keys.W;
    private final int downKey = Input.Keys.S;
    private final int leftKey = Input.Keys.A;
    private final int rightKey = Input.Keys.D;
    private final int quitKey = Input.Keys.ESCAPE;

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
            case upKey:
                entity.speed().y = entity.speed().y + 0.5f;
                break;
            case downKey:
                entity.speed().y = entity.speed().y - 0.5f;
                break;
            case leftKey:
                entity.speed().x = entity.speed().x - 0.5f;
                break;
            case rightKey:
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
            case upKey:
                entity.speed().y = entity.speed().y - 0.5f;
                break;
            case downKey:
                entity.speed().y = entity.speed().y + 0.5f;
                break;
            case leftKey:
                entity.speed().x = entity.speed().x + 0.5f;
                break;
            case rightKey:
                entity.speed().x = entity.speed().x - 0.5f;
                break;
            case quitKey:
                controller.pauseGame();
            default:
                System.out.println(keycode);
                break;
        }
        return true;
    }
}
