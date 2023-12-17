/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Players;

/**
 *
 * @author abdul
 */
public class PlayerFactory {
    
    public Player getPlayer(PlayerNames p){
        Player player = null;
        switch(p){
            case Messi -> player = new Messi(400 , 190);
            case Nunez -> player = new Nunez(400 , 200);
            case Bellingham -> player = new Bellingham(400 , 200);
        }
        return player;
    }
        
}
