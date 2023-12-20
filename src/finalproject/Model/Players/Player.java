package finalproject.Model.Players;

import eg.edu.alexu.csd.oop.game.GameObject;
import finalproject.Model.Objects.Shapes;
import java.awt.image.BufferedImage;
import java.util.Stack;


public abstract class Player implements GameObject{
    
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int playerLeftHandHeight = 0;
    private int playerRightHandHeight = 0;
    private Stack<Shapes> leftStack = new Stack();
    private Stack<Shapes> rightStack = new Stack();
    
    public Player(int x , int y){
        this.x = x;
        this.y = y;
        this.isVisible = true;
    }
    
    public Stack getLeftStack(){
        return leftStack;
    }
    
    public Stack getRightStack(){
        return leftStack;
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
        this.x = x;
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
    
    public abstract int getLeftDisplcementY();
    public abstract int getRightDisplcementY();
    public abstract int getLeftHand();
    public abstract int getRightHand();
}
