package ch.crepe.game.assets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class DisplayedAnimation extends DisplayedAsset{

    private final Animation<TextureRegion> animation;
    private float elapsedTime = 0f;

    public DisplayedAnimation(Texture texture, Rectangle animationArea, int tileWidth, int tileHeight, float secondsPerFrame) {
        super(animationArea);

        TextureRegion[][] tmpFrames = TextureRegion.split(texture,tileWidth,tileHeight);

        int index = 0;

        int i_max = tmpFrames.length;
        int j_max = tmpFrames[0].length;

        TextureRegion[] animationFrames = new TextureRegion[i_max * j_max];

        for (int i = 0; i < i_max; i++){
            for(int j = 0; j < j_max; j++) {
                animationFrames[index++] = tmpFrames[i][j];
            }
        }

        animation = new Animation<>(secondsPerFrame, animationFrames);
    }

    @Override
    public void draw(Batch batch) {
        elapsedTime += Gdx.graphics.getDeltaTime(); // TODO mettre en parametre
        super.draw(batch);
    }

    @Override
    protected TextureRegion getDrawable() {
        return animation.getKeyFrame(elapsedTime, true);
    }
}
