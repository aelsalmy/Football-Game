package finalproject.Model.Objects;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Ball extends Shapes{

    private BallTypes ballType;
    
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
                    this.ballType = BallTypes.Jabulani;
                }
                case 1 -> {
                    setSpriteImage(ImageIO.read(new File("resources/collectibles/rihla.png")));
                    this.ballType = BallTypes.Rihla;
                }
                case 2 -> {
                    setSpriteImage(ImageIO.read(new File("resources/collectibles/brazuca.png")));
                    this.ballType = BallTypes.Brazuca;
                }
            }
        }
        catch(IOException e){}     
    } 
}
