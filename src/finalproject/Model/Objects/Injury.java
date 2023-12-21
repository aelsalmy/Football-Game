package finalproject.Model.Objects;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Injury extends Shapes{
    
    public Injury(int x , int y){
        super(x,y);
        
        setItemType(ItemTypes.Injury);
        setType(ObjectTypes.Avoidable);
        
        try{
            setSpriteImage(ImageIO.read(new File("resources/avoidables/injury.png")));
            setHeight(getSpriteImages()[0].getHeight());
            setWidth(getSpriteImages()[0].getWidth());
        }
        catch(IOException e){
            System.out.println("No Image Found");
        }        
    }
}
