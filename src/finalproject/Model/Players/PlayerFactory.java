/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Players;

import finalproject.Model.Game.CollectableHitObservable;

/**
 *
 * @author abdul
 */
public class PlayerFactory {
    
    public Player getPlayer(PlayerNames p , CollectableHitObservable co){
        Player player = null;
        switch(p){
            case Messi -> player = new Messi(400 , 390 , co);
            case Nunez -> player = new Nunez(400 , 400 , co);
            case Bellingham -> player = new Bellingham(400 , 400 , co);
        }
        return player;
    }
        
}
