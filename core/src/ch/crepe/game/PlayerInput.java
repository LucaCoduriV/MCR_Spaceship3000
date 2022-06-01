package ch.crepe.game;

import com.badlogic.gdx.math.Vector2;

public class PlayerInput {
    static private PlayerInput instance;

    static public PlayerInput getInstance() {
        if (instance == null)
            instance = new PlayerInput();
        return instance;
    }

    public Vector2 getMove() {
        //TODO à changer
        return new Vector2(1, 1);
    }
}
