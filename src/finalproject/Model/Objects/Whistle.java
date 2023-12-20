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
public class Whistle extends Shapes {
    
    public Whistle(int x , int y){
        super(x,y);
        setVisibility(false);
        try{
            setSpriteImage(ImageIO.read(new File("resources/game_end/whistle.png")));
            setHeight(getSpriteImages()[0].getHeight());
            setWidth(getSpriteImages()[0].getWidth());  
        }
        catch(IOException e){
            System.out.println("NO FILE FOUND");
        }
    }
}
