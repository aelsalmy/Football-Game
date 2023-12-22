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
public class EasyStrategy implements Strategy{

    @Override
    public void updateDifficulty(Game g) {
        g.setSpeed(1);
        g.setAvoidableCount(3);
        g.setHorizontalMotion(0);
    }
    
}
