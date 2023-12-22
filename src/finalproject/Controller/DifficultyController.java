/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Controller;

import finalproject.Model.DifficultyStrategies.Strategy;
import finalproject.Model.Game.Game;

/**
 *
 * @author abdul
 */
public class DifficultyController {
    
    private Strategy difficulty;
    private static DifficultyController instance = new DifficultyController();
    
    private DifficultyController(){
        
    }
    
    public static DifficultyController getInstance(){
        return instance;
    }
    
    public void setDifficulty(Strategy s){
        this.difficulty = s;
    }
    
    public void updateDifficulty(Game g){
        difficulty.updateDifficulty(g);
    }
}
