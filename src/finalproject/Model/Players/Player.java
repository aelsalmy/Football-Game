package finalproject.Model.Players;

import eg.edu.alexu.csd.oop.game.GameObject;
import finalproject.Model.Game.CollectableHitObservable;
import finalproject.Model.Objects.Ball;
import finalproject.Model.Objects.Shapes;
import java.awt.image.BufferedImage;
import java.util.Stack;


public abstract class Player implements GameObject{
    
    private int x;
    private int y;
    private int width;
    private int height;
    private final boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int playerLeftHandHeight = 0;
    private int playerRightHandHeight = 0;
    private final Stack<Shapes> leftStack = new Stack();
    private final Stack<Shapes> rightStack = new Stack();
    private int stackedOfSameTypeLeft = 0;
    private int stackedOfSameTypeRight = 0;
    private CollectableHitObservable collectObs;
    
    public Player(int x , int y , CollectableHitObservable collectObs){
        this.x = x;
        this.y = y;
        this.isVisible = true;
        this.collectObs = collectObs;
    }
    
    public void addToLeftStack(Shapes s){
        addLeftHandHeight(s.getHeight()); 
        if(!leftStack.empty()){    
            if(leftStack.peek().getItemType() == s.getItemType()){
                System.out.println("1");
                this.stackedOfSameTypeLeft++;
           }else{
                System.out.println("2");
                this.stackedOfSameTypeLeft = 1;
            }
        }
        else{
            this.stackedOfSameTypeLeft = 1;
        }
        leftStack.push(s);
        if(stackedOfSameTypeLeft == 3){
            collectObs.notifySubscribersLeft(leftStack.peek().getItemType());
            if(leftStack.empty()){
                this.stackedOfSameTypeLeft = 0;
            }
            else{
                this.stackedOfSameTypeLeft = 1;
            }
        }
    }
    
    public void addToRightStack(Shapes s){
        addRightHandHeight(s.getHeight()); 
        if(!rightStack.empty()){
            if(rightStack.peek().getItemType() == s.getItemType())
                this.stackedOfSameTypeRight++;
            else
                this.stackedOfSameTypeRight = 1;
        }
        else{
            this.stackedOfSameTypeRight = 1;
        }
        rightStack.push(s);
        if(stackedOfSameTypeRight == 3){
            collectObs.notifySubscribersRight(rightStack.peek().getItemType());
            if(rightStack.empty()){
                this.stackedOfSameTypeRight = 0;
            }
            else{
                if(rightStack.size() >= 2){
                    if(rightStack.get(rightStack.size() - 2).getItemType() == rightStack.get(rightStack.size() - 1).getItemType())
                        this.stackedOfSameTypeRight = 2;
                }
                else
                    this.stackedOfSameTypeRight = 1;
            }
        }
    }
    
    public Stack getLeftStack(){
        return leftStack;
    }
    
    public Stack getRightStack(){
        return rightStack;
    }
    
    public int getLeftHandHeight(){
        return playerLeftHandHeight;
    }
    
    public int getRightHandHeight(){
        return playerRightHandHeight;
    }
    
    public void addRightHandHeight(int h){
        this.playerRightHandHeight = this.playerRightHandHeight + h;
    }
    
    public void addLeftHandHeight(int h){
        this.playerLeftHandHeight = this.playerLeftHandHeight + h;
    }
    
    protected final void setSpriteImage(BufferedImage b){
        spriteImages[0] = b;
    }
    
    protected final void setHeight(int h){
        this.height = h;
    }
    
    protected final void setWidth(int w){
        this.width = w;
    }
    
    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        moveAllStacks(this.getX() - x);
        this.x = x;
    }
    
    private void moveAllStacks(int disp){
        if(disp > 0){
            leftStack.forEach((s)-> s.setX(s.getX() - Math.abs(disp)));
            rightStack.forEach((s)-> s.setX(s.getX() - Math.abs(disp)));
        }
        else if(disp < 0){
            leftStack.forEach((s)-> s.setX(s.getX() + Math.abs(disp)));
            rightStack.forEach((s)-> s.setX(s.getX() + Math.abs(disp)));
        }
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
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
    public boolean isVisible() {
        return isVisible;
    }

    @Override
    public final BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
    public abstract void playCelebration();
    public abstract int getLeftDisplcementY();
    public abstract int getRightDisplcementY();
    public abstract int getLeftHand();
    public abstract int getRightHand();
}
