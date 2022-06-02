package ch.crepe.game;

import ch.crepe.game.Screens.GameScreen;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Entity;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector2;

public class PlayerInput extends InputAdapter {
    private final Entity entity;
    private final GameScreen screen;

    public PlayerInput(GameScreen gameScreen, Entity entity) {
        this.entity = entity;
        this.screen = gameScreen;
    }

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode){
            case Input.Keys.UP:
                entity.speed().y = 0.5f;
                break;
            case Input.Keys.DOWN:
                entity.speed().y = -0.5f;
                break;
            case Input.Keys.LEFT:
                entity.speed().x = -0.5f;
                break;
            case Input.Keys.RIGHT:
                entity.speed().x = 0.5f;
                break;
        }
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println(keycode);
        switch (keycode){
            case Input.Keys.UP:
            case Input.Keys.DOWN:
                entity.speed().y = 0;
                break;
            case Input.Keys.LEFT:
            case Input.Keys.RIGHT:
                entity.speed().x = 0;
                break;
            case Input.Keys.ESCAPE:
                screen.pauseGame();
        }
        return super.keyUp(keycode);
    }
}
