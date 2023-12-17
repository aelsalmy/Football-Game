/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdul
 */
public class Ball implements GameObject{
    
    private final int BALL_SIZE = 30;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    private BallTypes ballType;
    
    public Ball(int x , int y , BallTypes ball){
        this.x = x;
        this.y = y;
        this.isVisible = true;
        this.ballType = ball;
        try{
            switch(ball){
                case Jabulani -> spriteImages[0] = ImageIO.read(new File("resources/collectibles/jabulani.png")); 
                case Rihla -> spriteImages[0] = ImageIO.read(new File("resources/collectibles/rihla.png"));
                case Brazuca -> spriteImages[0] = ImageIO.read(getClass().getResourceAsStream("resources/collectibles/rihla.png"));
            }
            this.height = spriteImages[0].getHeight();
            this.width = spriteImages[0].getWidth();
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
    
    public void setVisibility(boolean vis){
        this.isVisible = vis;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
    
}
