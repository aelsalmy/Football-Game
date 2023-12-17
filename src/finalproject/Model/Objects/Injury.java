package finalproject.Model.Objects;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Injury implements GameObject{
    
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isVisible;
    private BufferedImage[] spriteImages = new BufferedImage[1];
    
    public Injury(int x , int y){
        this.x = x;
        this.y = y;
        this.isVisible = true;
        try{
            spriteImages[0] = ImageIO.read(new File("resources/avoidables/injury.png"));
            this.height = spriteImages[0].getHeight();
            this.width = spriteImages[0].getWidth();
        }
        catch(IOException e){
            System.out.println("No Image Found");
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
