package ch.crepe.game.entities.ship.weapons.projectiles;

import ch.crepe.game.entities.SpaceShipAI;
import com.badlogic.gdx.graphics.Texture;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.math.Vector2;

abstract public class Laser extends Projectile {

    private final static float SIZE = 3;


    protected Laser(Spaceship owner, Vector2 position, float orientation, Texture texture) {
        super(owner, position, new Vector2(1, 0).rotateDeg(orientation), SIZE, SIZE);
        makeNoise();
    }

    @Override
    public void visit(Spaceship ship) {
        if(getOwner() == getOwner().getGameController().getPlayerShip() && ship != getOwner().getGameController().getPlayerShip()){
            return;
        }

        ship.setLife(ship.getLife() - getDamage());
        if(!ship.isAlive()) {
            getOwner().getGameController().getGameInfo().addScore(1);
        }
        kill();
    }

    @Override
    public void visit(SpaceShipAI ship) {
        visit((Spaceship) ship);
    }
}
