package ch.crepe.game.engines.Renderer;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

public class Renderer {

    private PolygonSpriteBatch batch;
    private static Renderer renderer;

    private Renderer() {
        batch = new PolygonSpriteBatch();
    }

    public static Renderer getInstance() {
        if(renderer == null) {
            renderer = new Renderer();
        }

        return renderer;
    }

    public PolygonSpriteBatch getBatch() {
        return batch;
    }
}
