package finalproject.Model.Game;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import finalproject.Controller.LivesController;
import finalproject.Model.Objects.*;
import finalproject.Model.Players.*;
import java.util.LinkedList;
import java.util.List;

public class Game implements World , AvoidableHitObservor{
    
    private static Game instance = new Game();
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
    public GameObject b;
    
    public Game(){
        b = new RedCard(400 , 200);
        constants.add(b);
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
        //System.out.println("LOLO");
        return true;
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
