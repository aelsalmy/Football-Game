/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.DifficultyStrategies;

import finalproject.Model.Game.Game;

/**
 *
 * @author abdul
 */
public class NormalStrategy implements Strategy{

    @Override
    public void updateDifficulty(Game g) {
        g.setSpeed(2);
        g.setAvoidableCount(4);
        g.setHorizontalMotion(2);
    }
    
}
