/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Controller;

import finalproject.Model.Game.AvoidableHitObservor;
import finalproject.Model.Game.Game;
import finalproject.Model.Objects.Shapes;
import java.util.List;

/**
 *
 * @author abdul
 */
public class LivesController implements AvoidableHitObservor{
    
    private int lives = 3;
    private List livesList;
    private final Game game;
    
    public LivesController(List lives , Game g){
        this.livesList = lives;
        this.game = g;
    }
    
    @Override
    public void updateHit() {
        switch (lives) {
            case 3 -> {
                ((Shapes)livesList.get(0)).setVisibility(true);
                lives--;
            }
            case 2 -> {
                ((Shapes)livesList.get(1)).setVisibility(true);
                lives--;
            }
            case 1 -> {
                ((Shapes)livesList.get(2)).setVisibility(true);
                lives--;
                game.endGame();
            }
            default -> {
                
            }
        }
        
    }    
}
