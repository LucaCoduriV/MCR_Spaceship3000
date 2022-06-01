package ch.crepe.game;

import com.badlogic.gdx.InputAdapter;

public class GameInputProcessor extends InputAdapter {
    @Override
    public boolean keyDown(int keycode) {
        System.out.println(keycode);
        return super.keyDown(keycode);
    }
}
