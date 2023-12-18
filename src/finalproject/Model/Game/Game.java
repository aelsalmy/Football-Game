package finalproject.Model.Game;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import finalproject.Controller.LivesController;
import finalproject.Model.Objects.*;
import finalproject.Model.Players.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Game implements World , AvoidableHitObservor{
    
    private ObjectFactory factory;
    private Player player;
    private GameState stateOfGame;
    private LivesController livesController;
    private ScoresController scoresController;
    private final int width = 800;
    private final int height = 400;
    private final List<GameObject> constants = new LinkedList();
    private final List<GameObject> movables = new LinkedList();
    private final List<GameObject> controlled = new LinkedList();
    private int speed = 10;
    private int controlSpeed = 10;
    private Random random = new Random();

    
    public Game(Player p){
        this.stateOfGame = new GameRunning();
        this.factory = ObjectFactory.getInstance();
        controlled.add(p);
        constants.add(new Whistle(10 , 22));
        constants.add(new YellowCard(50 , 2));
        constants.add(new RedCard(90 , 2));
        
    }
    
    @Override
    public List<GameObject> getConstantObjects() {
        return constants;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return movables;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return controlled;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean refresh() {
    
        if (random.nextInt(100) < 1.2) {
            GameObject collectableObject = factory.generateRandomCollectable(0, 0);
            collectableObject.setX(random.nextInt(getWidth()));
            collectableObject.setY(0);
            movables.add(collectableObject);
        }
        if (random.nextInt(100) < 0.5) {
            GameObject avoidableObject = factory.generateRandomAvoidable(0, 0);
            avoidableObject.setX(random.nextInt(getWidth()));
            avoidableObject.setY(0);
            movables.add(avoidableObject);
        }
        for (GameObject obj : movables.toArray(GameObject[]::new)) {
            obj.setY(obj.getY() + speed);
        }
        return stateOfGame.refreshGame();
    }
    
    @Override
    public String getStatus() {
        return " Game is Running 7ad yel7a2o hhhhh";
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public int getControlSpeed() {
        return controlSpeed;
    }

    @Override
    public void updateHit() {
        System.out.println("AYYY I'm Hit");
    }
    
}
