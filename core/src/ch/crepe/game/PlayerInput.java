package ch.crepe.game;

import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;

public class PlayerInput extends InputAdapter {
    private final Spaceship entity;
    private final GameController controller;
    private final int upKey = Input.Keys.W;
    private final int downKey = Input.Keys.S;
    private final int leftKey = Input.Keys.A;
    private final int rightKey = Input.Keys.D;
    private final int quitKey = Input.Keys.ESCAPE;

    public PlayerInput(GameController gameController, Spaceship entity) {
        this.entity = entity;
        this.controller = gameController;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode){
            case upKey:
                entity.speed().y = 0.5f;
                break;
            case downKey:
                entity.speed().y = -0.5f;
                break;
            case leftKey:
                entity.speed().x = -0.5f;
                break;
            case rightKey:
                entity.speed().x = 0.5f;
                break;
            case Input.Keys.SPACE :
                entity.shoot();
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode){
            case upKey:
            case downKey:
                entity.speed().y = 0;
                break;
            case leftKey:
            case rightKey:
                entity.speed().x = 0;
                break;
            case quitKey:
                controller.pauseGame();
            default:
                System.out.println(keycode);
                break;
        }
        return super.keyUp(keycode);
    }
}
