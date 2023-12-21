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

public class BackgroundImage implements GameObject{
    
    private BufferedImage[] spriteImages = new BufferedImage[1];
    private int width;
    private int height;
    
    public BackgroundImage(){     
        try{
            spriteImages[0] = ImageIO.read(new File("resources/stadium.png"));
            this.width = spriteImages[0].getHeight();
            this.height = spriteImages[0].getWidth();
        }
        catch(IOException e){
            System.out.println("No Image Found");
        } 
    }
    
    @Override
    public int getX() {
        return 0;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public void setY(int y) {

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
        return true;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
    
}
