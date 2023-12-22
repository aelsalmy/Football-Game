/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package finalproject.Model.DifficultyStrategies;

import finalproject.Model.Game.Game;

/**
 *
 * @author abdul
 */
public interface Strategy {
    //Difficulty is controlled by speed of objects and amount of avoidables
    public void updateDifficulty(Game g);
}
