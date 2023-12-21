/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Game;

import finalproject.Model.Objects.ItemTypes;

/**
 *
 * @author abdul
 */
public class ScoresController implements AvoidableHitObservor , CollectableHitObservor{
    
    private int score = 0;
    
    @Override
    public void updateHit() {
        score = score - 10; 
        if(score < 0)
            score = 0;
    }
    
    public int getScore(){
        return score;
    }

    @Override
    public void updateCollectRight(ItemTypes s) {
        this.updateCollectScore(s);
    }

    @Override
    public void updateCollectLeft(ItemTypes s) {
        this.updateCollectScore(s);
    }   
    
    private void updateCollectScore(ItemTypes i){
        if(i == ItemTypes.BalonDor)
            score = score + 3;
        else
            score = score + 1;
        System.out.println("Score: " + score);
    }
}
