package ch.crepe.game;

import ch.crepe.game.Screens.GameScreen;
import ch.crepe.game.assets.AssetsLoader;
import ch.crepe.game.assets.SpaceShip;
import ch.crepe.game.entities.Entity;
import ch.crepe.game.entities.Spaceship;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private EnnemySpawner ennemySpawner;
    private GameInfo gameInfo;
    private final Spaceship playerShip;
    private final List<Entity> entities;
    private final PlayerInput playerInput;


    public GameController(){
        this.playerShip = new Spaceship(new Vector2(), AssetsLoader.getInstance().getSpaceship(SpaceShip.bowFighter),new Vector2());
        this.entities = new ArrayList<>();
        this.playerInput = new PlayerInput(this, playerShip);
        this.gameInfo = new GameInfo();

    }

    public void update(float delta){
        for (Entity entity : entities) {
            entity.update(delta);
        }
        playerShip.update(delta);
    }

    public Spaceship getPlayerShip(){
        return playerShip;
    }

    public List<Entity> getEntities(){
        return entities;
    }

    public void pauseGame(){

    }

    public void resumeGame(){

    }

    public PlayerInput getPlayerInput() {
        return playerInput;
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }
}
