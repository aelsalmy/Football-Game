/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Game;

import finalproject.Model.Objects.Shapes;

/**
 *
 * @author abdul
 */
class ScoresController implements AvoidableHitObservor , CollectableHitObservor{
    
    private int score = 0;
    
    @Override
    public void updateHit() {
        //TODO: Add logic to reset score 
    }
    
    public int getScore(){
        return score;
    }

    @Override
    public void updateCollect(Shapes s) {

    }
    
}
