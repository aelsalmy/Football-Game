package finalproject.Model.Game;

import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import finalproject.Controller.AudioPlayer;
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
    private final List<GameObject> lives = new LinkedList();
    private int speed;
    private final int controlSpeed = 10;
    private boolean init = false;
    private final List<GameObject> objs = new LinkedList();
    private final List<Shapes> destroy = new LinkedList();
    private long startTime = System.currentTimeMillis();
    private final int ALLOWED_TIME = 90 * 1000;
    private int avoidableCount;
    private int horizontalMotion;
    
    public Game(Player p , ScoresController sc , AvoidableHitObservable hitObs) {
        this.stateOfGame = new GameRunning();
        this.factory = ObjectFactory.getInstance();
        this.player = p;
        this.scoreController = sc;
        this.livesController = new LivesController(lives , this);
        
        this.hitObs = hitObs;
        hitObs.addSubscriber(livesController);
        
        constants.add(new BackgroundImage());
        controlled.add(p);
        
        lives.add(new Whistle(10, 22));
        lives.add(new YellowCard(50, 2));
        lives.add(new RedCard(90, 2));
        
        lives.forEach((obj) -> constants.add(obj));
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public void setHorizontalMotion(int h){
        this.horizontalMotion = h;
    }
    
    public void setAvoidableCount(int count){
        this.avoidableCount = count;
    }

    private void initialize() {
        AudioPlayer.ambient();
        new Thread(new Runnable() {
            @Override
            public void run() {
                init = true;
                for (int i = 0; i < avoidableCount ; i++) {
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
        
        boolean gameRunning = !(System.currentTimeMillis() - startTime > ALLOWED_TIME);

        objs.forEach((o) -> movables.add(o));
        objs.clear();
        
        if(!gameRunning)
            this.endGame();
                          
        for (GameObject obj : movables) {
            Shapes s = (Shapes) obj;
            //reuse Objects
            if (gameRunning && s.getY() >= height) {
                if (obj instanceof Ball ball) {
                    ball.setImage((int) (Math.random() * 3));
                }
                s.setX((int) (Math.random() * width));
                s.setY((int) (Math.random() * height / 3));
            }
            if(gameRunning && s.getType() == ObjectTypes.Avoidable){
                if(s.getY() + s.getHeight() == this.height - player.getHeight())
                    if(!(player.getX() > s.getX() + s.getWidth() -20 || player.getX() + player.getWidth() < s.getX() + 20))
                        this.collisionOccured(s , false);
            }
            else if(gameRunning && horizontalLeftCollision(s)){
                if(leftHandCollides(s))
                    this.collisionOccured(s , false);
                }
            else if(gameRunning && horizontalRightCollision(s)){
                if(rightHandCollides(s))
                    this.collisionOccured(s , true);
            }
            
            s.setY(s.getY() + 1);
            s.setX(s.getX() + (Math.random() > 0.5 ? horizontalMotion : -1 * horizontalMotion));
        }       
        destroy.forEach((o) -> movables.remove(o));
        destroy.clear();
        return stateOfGame.refreshGame();
    }
    
    public void endGame(){
        if(startTime != 0){
            stateOfGame = new GameEnded();
            AudioPlayer.finalWhistle();
            startTime = 0;
        }
    }
    
    private boolean horizontalLeftCollision(Shapes s){
        boolean b1 = s.getY() + s.getHeight() <= (this.height - player.getHeight()) - player.getLeftHandHeight() + player.getLeftDisplcementY() ;
        boolean b2 = s.getY() + s.getHeight() >= (this.height - player.getHeight()) - player.getLeftHandHeight() + player.getLeftDisplcementY()- speed;
        return b1 && b2;
    }
    
    private boolean horizontalRightCollision(Shapes s){
        boolean b1 = s.getY() + s.getHeight() <= (this.height - player.getHeight()) - player.getRightHandHeight() + player.getRightDisplcementY() ;
        boolean b2 = s.getY() + s.getHeight() >= (this.height - player.getHeight()) - player.getRightHandHeight() + player.getRightDisplcementY()- speed;
        return b1 && b2;
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
        return ("Time Left = " + (int)Math.max(0 , ALLOWED_TIME - (System.currentTimeMillis() - startTime))/1000 +  " | Score: " + scoreController.getScore());
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
        System.out.println("Hit");
        while(!player.getLeftStack().empty()){
            Shapes obj = (Shapes) player.getLeftStack().pop();
            constants.remove(obj);
            obj.setVisibility(false);
            player.addLeftHandHeight(-1 * obj.getHeight());
        }
        while(!player.getRightStack().empty()){
            Shapes obj = (Shapes) player.getRightStack().pop();
            constants.remove(obj);
            obj.setVisibility(false);
            player.addRightHandHeight(-1 * obj.getHeight());
        }
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
        playCelebration();
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
        playCelebration();
    }
    
    private void playCelebration(){
        this.player.playCelebration();
    }  
    
}
