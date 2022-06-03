package ch.crepe.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.graphics.g2d.Animation;


public class LoopingAnimation extends LoopingSprite{ // TODO l'héritage est horriblement a chier faut refacto tout ça

    TextureRegion[] animationFrames;
    Animation<TextureRegion> animation;
    private float elapsedTime = 0f;

    public Vector2 getSize() {
        return size;
    }

    private Vector2 size;

    public LoopingAnimation(Texture texture, Vector2 size, Vector2 respawnPosition, Vector2 basePosition, Float speed, Rectangle bounds,
                            int tileWidth, int tileHeight) {
        super(texture, size, respawnPosition, basePosition, speed, bounds);

        TextureRegion[][] tmpFrames = TextureRegion.split(texture,tileWidth,tileHeight);

        int index = 0;

        int i_max = tmpFrames.length;
        int j_max = tmpFrames[0].length;

        animationFrames = new TextureRegion[i_max * j_max];

        for (int i = 0; i < i_max; i++){
            for(int j = 0; j < j_max; j++) {
                animationFrames[index++] = tmpFrames[i][j];
            }
        }

        animation = new Animation<>(1f/40f,animationFrames);
        this.size = size;
    }

    @Override
    public void draw(SpriteBatch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime,true),position().x,position().y, size.x, size.y);
    }
}
