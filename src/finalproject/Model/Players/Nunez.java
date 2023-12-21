/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Players;

import finalproject.Controller.AudioPlayer;
import finalproject.Model.Game.CollectableHitObservable;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdul
 */
public class Nunez extends Player {
    
    public Nunez(int x, int y, CollectableHitObservable co) {
        super(x, y, co);
        try {
            setSpriteImage(ImageIO.read(new File("resources/players/nunez3.png")));
            setHeight(getSpriteImages()[0].getHeight());
            setWidth(getSpriteImages()[0].getWidth());
            
        } catch (IOException e) {
            System.out.println("No File Found");
        }        
        
        super.setY(600 - getHeight());
    }
    
    @Override
    public int getLeftHand() {
        return 10;
    }
    
    @Override
    public int getRightHand() {
        return getWidth() - 5;
    }    
    
    @Override
    public int getLeftDisplcementY() {
        return 20;
    }
    
    @Override
    public int getRightDisplcementY() {
        return 0;
    }

    @Override
    public void setY(int y) {
        
    }
    
    @Override
    public void playCelebration() {
        AudioPlayer.NunezCeleb();
    }
}
