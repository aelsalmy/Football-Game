/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdul
 */
public class BallonDor implements GameObject{
    
    private final int IMAGE_SIZE = 40;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    
    public BallonDor(int x , int y){
        this.x = x;
        this.y = y;
        this.isVisible = true;
        spriteImages[0] = new BufferedImage(IMAGE_SIZE , IMAGE_SIZE , BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = spriteImages[0].createGraphics();
        try{
            g2d.drawImage(ImageIO.read(new File("resources/collectibles/balon.png")), 0, 0, IMAGE_SIZE, IMAGE_SIZE, null); 
            g2d.dispose();
        }
        catch(IOException e){
            System.out.println("IMAGE NOT FOUND");
        }
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
