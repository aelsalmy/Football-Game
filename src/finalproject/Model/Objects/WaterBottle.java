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
public class WaterBottle extends Shapes{
    
    public WaterBottle(int x , int y){
        super(x,y);
        
        setType(ObjectTypes.Avoidable);
        
        try{
            setSpriteImage(ImageIO.read(new File("resources/avoidables/waterBottle.png")));
            setHeight(getSpriteImages()[0].getHeight());
            setWidth(getSpriteImages()[0].getWidth());
        }
        catch(IOException e){
            System.out.println("No File Found");
        }      
    } 
    
    @Override
    public void setIsConstant(boolean b){
            
    }
}
