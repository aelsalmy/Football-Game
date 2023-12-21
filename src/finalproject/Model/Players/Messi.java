/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Players;

import finalproject.Model.Game.CollectableHitObservable;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdul
 */
public class Messi extends Player{
    
    public Messi(int x , int y , CollectableHitObservable co){
        super(x,y,co);
        try{
            setSpriteImage(ImageIO.read(new File("resources/players/goat.png")));
            setHeight(getSpriteImages()[0].getHeight());
            setWidth(getSpriteImages()[0].getWidth());   
            
            super.setY(600 - getHeight());
        }
        catch(IOException e){
            System.out.println("NO FILE FOUND");
        }
    }
    
    @Override
    public void setY(int y){
        
    }

    @Override
    public int getLeftHand() {
        return 10;
    }

    @Override
    public int getRightHand() {
        return getWidth() - 10;
    }

    @Override
    public int getLeftDisplcementY() {
        return 0;
    }

    @Override
    public int getRightDisplcementY() {
        return 0;
    }
    
}
