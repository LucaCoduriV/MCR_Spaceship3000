package ch.crepe.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class DisplayedAnimation extends DisplayedAsset{

    private TextureRegion[] animationFrames;
    private Animation<TextureRegion> animation;
    private float elapsedTime = 0f;
    private Vector2 size;

    public DisplayedAnimation(Texture texture, Vector2 size, Vector2 position, int tileWidth, int tileHeight, float secondsPerFrame) {
        super(position);

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

        animation = new Animation<>(secondsPerFrame, animationFrames);
        this.size = size;
    }

    @Override
    public void draw(Batch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime();
        batch.draw(animation.getKeyFrame(elapsedTime,true),position().x,position().y, size.x, size.y);
    }
}
