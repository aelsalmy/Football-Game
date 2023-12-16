/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdul
 */
public class WaterBottle implements GameObject{

    private final int IMAGE_SIZE = 40;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    
    public WaterBottle(int x , int y){
        this.x = x;
        this.y = y;
        this.isVisible = true;
        try{
            spriteImages[0] = ImageIO.read(new File("resources/avoidables/waterBottle.png"));
        }
        catch(IOException e){
            
        }
        this.height = spriteImages[0].getHeight();
        this.width = spriteImages[0].getWidth();
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
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
    
}
