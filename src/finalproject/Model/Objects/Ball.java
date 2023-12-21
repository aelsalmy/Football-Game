package finalproject.Model.Objects;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ball extends Shapes{
    
    public Ball(int x , int y , int ballType){
        super(x,y);
        
        this.setImage(ballType);
        
        setType(ObjectTypes.Collectable);
        
        setHeight(getSpriteImages()[0].getHeight());
        setWidth(getSpriteImages()[0].getWidth());  
    }
    
    public final void setImage(int x){
        try{
            switch(x){
                case 0 -> {
                    setSpriteImage(ImageIO.read(new File("resources/collectibles/ball_soccer1.png")));
                    setItemType(ItemTypes.BallJabulani);
                }
                case 1 -> {
                    setSpriteImage(ImageIO.read(new File("resources/collectibles/rihla.png")));
                    setItemType(ItemTypes.BallRihla);
                }
                case 2 -> {
                    setSpriteImage(ImageIO.read(new File("resources/collectibles/brazuca.png")));
                    setItemType(ItemTypes.BallBrazuca);
                }
            }
        }
        catch(IOException e){}     
    } 
}
