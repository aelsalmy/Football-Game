/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Objects;


import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdul
 */
public class BallonDor extends Shapes{
    
    public BallonDor(int x , int y){
        super(x,y);
        
        setItemType(ItemTypes.BalonDor);
        setType(ObjectTypes.Collectable);
        
        try{
            setSpriteImage(ImageIO.read(new File("resources/collectibles/balon.png")));
            setHeight(getSpriteImages()[0].getHeight());
            setWidth(getSpriteImages()[0].getWidth());  
        }
        catch(IOException e){
            System.out.println("IMAGE NOT FOUND");
        }
    }

}
