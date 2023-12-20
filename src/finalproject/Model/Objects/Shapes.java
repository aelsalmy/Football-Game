/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;

/**
 *
 * @author abdul
 */
public abstract class Shapes implements GameObject{
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    private ObjectTypes type;
    private boolean isConstant = false;
    
    
    
    public void setIsConstant(boolean isConst){
        this.isConstant = isConst;
    }
    
    public Shapes(int x , int y){
        this.x = x;
        this.y = y;
        this.isVisible = true;
    }
    
    public void setType(ObjectTypes type){
        this.type = type;
    }
    
    public ObjectTypes getType(){
        return type;
    }
    
    protected final void setSpriteImage(BufferedImage b){
        spriteImages[0] = b;
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
        if(!isConstant)
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
    
    public final void setVisibility(boolean vis){
        this.isVisible = vis;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
    
    protected final void setHeight(int h){
        this.height = h;
    }
    
    protected final void setWidth(int w){
        this.width = w;
    }
}
