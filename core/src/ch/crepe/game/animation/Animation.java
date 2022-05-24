package ch.crepe.game.animation;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Cette classe permet de gérer une animation.
 * @author Luca Coduri
 */
public class Animation {

    private Sprite[] frames;
    private int currentFrame;
    private boolean playedOnce;

    public Animation(Sprite[] frames) {

        this.frames = frames;
    }

    public void setFrames(Sprite[] frames) {

        this.frames = frames;
        currentFrame = 0;
        playedOnce = false;
    }

    public void tick(float dt) {
        this.currentFrame++;

        // If at the end, loop back to the first frame.
        if(currentFrame >= frames.length) {
            currentFrame = 0;
            playedOnce = true;
        }
    }

    public void setFrame(int i) {

        this.currentFrame = i;
    }

    public int getCurrentFrame() {

        return this.currentFrame;
    }

    public int getNFrames() {

        return this.frames.length;
    }

    public Sprite getCurrentSprite() {

        return frames[currentFrame];
    }

    public boolean hasPlayedOnce() {

        return this.playedOnce;
    }

}
