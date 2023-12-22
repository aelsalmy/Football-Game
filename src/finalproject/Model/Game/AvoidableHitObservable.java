/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.Model.Game;

import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class AvoidableHitObservable {
    private ArrayList<AvoidableHitObservor> subscribers = new ArrayList();
        
    public void addSubscriber(AvoidableHitObservor o){
        subscribers.add(o);
    }
    
    public void removeSubscriber(AvoidableHitObservor o){
        subscribers.remove(o);
    }
    
    public void notifySubscribers(){
        for(AvoidableHitObservor subs : subscribers)
            subs.updateHit();
    }
}
