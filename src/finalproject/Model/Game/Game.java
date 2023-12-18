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
    private int speed = 1;
    private int controlSpeed = 10;
    private Random random = new Random();
    private boolean init = false;
    private List<GameObject> objs = new LinkedList();

    
    public Game(Player p){
        this.stateOfGame = new GameRunning();
        this.factory = ObjectFactory.getInstance();
        
        controlled.add(p);
        
        constants.add(new Whistle(10 , 22));
        constants.add(new YellowCard(50 , 2));
        constants.add(new RedCard(90 , 2)); 
    }
    
    private void initialize(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                init = true;
                for(int i = 0 ; i < 3 ; i++){
                    objs.add(factory.generateRandomAvoidable((int)(Math.random()*width), (int)(Math.random() * height/3)));
                    try{
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e){
            
                    }
                    objs.add(factory.generateRandomCollectable((int)(Math.random()*width), (int)(Math.random() * height/3)));
                    try{
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e){
            
                    }
                }
                
                System.out.println("Exit thread");
            }
        }).start();
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
        if(!init)
            this.initialize();
        
        objs.forEach((o) -> movables.add(o));
        objs.clear();
        
        System.out.println("Refreshing");
        
        for (GameObject obj : movables) {
            if(obj.getY() >= height){
                if(obj instanceof Ball ball){
                    ball.setImage((int)(Math.random()*3));
                }
                obj.setX((int)(Math.random()*width));
                obj.setY((int)(Math.random() * height/3));
            }
            else   
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
