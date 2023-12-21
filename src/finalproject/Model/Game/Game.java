package finalproject.Model.Game;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import finalproject.Controller.LivesController;
import finalproject.Model.Objects.*;
import finalproject.Model.Players.*;
import java.util.LinkedList;
import java.util.List;

public class Game implements World, AvoidableHitObservor, CollectableHitObservor {

    private final ObjectFactory factory;
    private final Player player;
    private GameState stateOfGame;
    private final int width = 1000;
    private final int height = 600;
    private final ScoresController scoreController;
    private final LivesController livesController;
    private final AvoidableHitObservable hitObs;
    private final List<GameObject> constants = new LinkedList();
    private final List<GameObject> movables = new LinkedList();
    private final List<GameObject> controlled = new LinkedList();
    private int speed = 1;
    private int controlSpeed = 10;
    private boolean init = false;
    private final List<GameObject> objs = new LinkedList();
    private final List<Shapes> destroy = new LinkedList();

    public Game(Player p , ScoresController sc , AvoidableHitObservable hitObs) {
        this.stateOfGame = new GameRunning();
        this.factory = ObjectFactory.getInstance();
        this.player = p;
        this.scoreController = sc;
        this.livesController = new LivesController();
        
        this.hitObs = hitObs;
        
        controlled.add(p);

        constants.add(new Whistle(10, 22));
        constants.add(new YellowCard(50, 2));
        constants.add(new RedCard(90, 2));
    }

    private void initialize() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                init = true;
                for (int i = 0; i < 3; i++) {
                    objs.add(factory.generateRandomAvoidable((int) (Math.random() * width), (int) (Math.random() * height / 3)));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

                    }
                    objs.add(factory.generateRandomCollectable((int) (Math.random() * width), (int) (Math.random() * height / 3)));

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {

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
        if (!init) {
            this.initialize();
        }

        objs.forEach((o) -> movables.add(o));
        objs.clear();
                          
        for (GameObject obj : movables) {
            Shapes s = (Shapes) obj;
            if (s.getY() >= height) {
                if (obj instanceof Ball ball) {
                    ball.setImage((int) (Math.random() * 3));
                }
                s.setX((int) (Math.random() * width));
                s.setY((int) (Math.random() * height / 3));
            }
            if(s.getType() == ObjectTypes.Avoidable){
                if(s.getY() + s.getHeight() == this.height - player.getHeight())
                    if(!(player.getX() > s.getX() + s.getWidth() -20 || player.getX() + player.getWidth() < s.getX() + 20))
                        this.collisionOccured(s , false);
            }
            else if(s.getY() + s.getHeight() == (this.height - player.getHeight()) - player.getLeftHandHeight() + player.getLeftDisplcementY()){
                if(leftHandCollides(s))
                    this.collisionOccured(s , false);
                }
            else if(s.getY() + s.getHeight() == (this.height - player.getHeight()) - player.getRightHandHeight() + player.getRightDisplcementY()){
                if(rightHandCollides(s))
                    this.collisionOccured(s , true);
            }
            
            s.setY(s.getY() + speed);
        }       
        destroy.forEach((o) -> movables.remove(o));
        destroy.clear();
        return stateOfGame.refreshGame();
    }
    
    private boolean rightHandCollides(Shapes s){
        boolean rightHand = (s.getX() + s.getWidth()) < player.getRightHand() + player.getX() - 10 || s.getX() > player.getRightHand() + player.getX(); 
        return !rightHand;
    }
    
    private boolean leftHandCollides(Shapes s){
        boolean leftHand = (s.getX() + s.getWidth()) < player.getLeftHand() + player.getX() || s.getX() > player.getLeftHand() + 10 + player.getX(); 
        return !leftHand;
    }

    private void collisionOccured(Shapes shape , boolean isRight) {
        if(shape.getType() == ObjectTypes.Avoidable)
            hitObs.notifySubscribers();
        else{
            if(isRight)
                collectRight(shape);
            else
                collectLeft(shape);
        }
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
        //TODO
        System.out.println("AYYY I'm Hit");
    }

    public void collectLeft(Shapes s) {
        destroy.add(s);
        s.setIsConstant(true);
        constants.add(s);
        player.addToLeftStack(s);
        objs.add(factory.generateRandomCollectable((int)(Math.random() * width), (int) (Math.random() * height / 3)));
    }

    public void collectRight(Shapes s) {
        destroy.add(s);
        s.setIsConstant(true);
        constants.add(s);
        player.addToRightStack(s);
        objs.add(factory.generateRandomCollectable((int)(Math.random() * width), (int) (Math.random() * height / 3)));
    }

    @Override
    public void updateCollectLeft(ItemTypes s) {
        //remove top 3 in LeftStack
        for(int i = 0 ; i < 3 ; i++){
            Shapes obj = (Shapes)player.getLeftStack().pop();
            constants.remove(obj);
            obj.setVisibility(false);
            player.addLeftHandHeight(-1 * obj.getHeight());
        }
        this.play();
    }
private void play()
{
    this.player.playCelebration();
}
    @Override
    public void updateCollectRight(ItemTypes s) {
        //remove top 3 in RightStack
        for(int i = 0 ; i < 3 ; i++){
            Shapes obj = (Shapes)player.getRightStack().pop();
            constants.remove(obj);
            obj.setVisibility(false);
            player.addRightHandHeight(-1 * obj.getHeight());
        }
    }
}
